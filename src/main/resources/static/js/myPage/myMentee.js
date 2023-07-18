$("#inputMessage").keyup(function (e) {
    let content = $(this).val();

    // 글자수 세기
    if (content.length == 0 || content == "") {
        $(".send-text-count").text("0");
    } else {
        $(".send-text-count").text(content.length);
    }

    // 글자수 제한
    if (content.length > 400) {
        // 400자 부터는 타이핑 되지 않도록
        $(this).val($(this).val().substring(0, 400));
        // 400자 넘으면 알림창 뜨도록
        $('.warning-text').html("글자수는 400자까지 입력 가능합니다.");
    }
});


// 쪽지 보내기
$('.input-container').on('click','.send-btn', function (){

    let num = $('.chattingTo').data('num');
    let shareNumber = $('.share-num').val();
    let wingAmount = $('.share-wing-count').text();

    console.log("드러와 !!!!!!!!!!");
    console.log(num);

    $.ajax({
        url: "/mentor/inputModal",
        type: 'post',
        data: JSON.stringify({chattingTo : num, chattingContent : $('#inputMessage').val()}),
        contentType : "application/json; charset=utf-8",
        success: function (){
            alert("전송이 완료되었습니다.");
            $('#inputMessage').val('');
            $('.input-wrap').addClass('none');
            $('body').css('overflow', 'auto');
            $('.form-reset')[0].reset();

            // window.location.href = '/myPage/myMentee';
        }
    })

});

/* 쪽지 모달창 */
$(function () {
    $(".message-button").click(function () {
        $(".input-wrap").fadeIn();
        let userNickname = $(this).closest('.mentee-box').find('.mentee-name').text();
        let num = $(this).closest('.mentee-box').find('.mentee-number').data('num');
        console.log(userNickname);
        console.log(num);

        $('.chattingTo').text(userNickname);
        $('.chattingTo').data('num', num);
    });
});

$(".message-button").on("click", function () {
    $(".input-wrap").removeClass("none");

    $('body').css('overflow', 'hidden');
});

$(".input-wrap").on("click", function (e) {

    if ($(e.target).hasClass("input-wrap")) {
        $(".input-wrap").addClass("none");
        $('body').css('overflow', 'auto');

        $('.form-reset')[0].reset();
    }
});

//멘티 수락&거절
$('.my-mentee-content').on('click', '.mentee1' ,function (){
    let userNumber = $(this).closest('.mentee-date').find('.mentor-num').val();
    let user = $(this).closest('.mentee-date').data('num');
    let status =  $(this).closest('.mentee-date').find('.umStatus').val() == 'N' ? 'Y' : 'N';
    let $btnHtml = $(this).closest('.mentee-date').find('.btn');
    console.log(userNumber);
    console.log(user);
    $.ajax({
        url : '/mentor/okmentee',
        type : 'patch',
        data : {
            userNumber : userNumber,
            umStatus : status
        },
        success : function (){
            alert("멘티를 수락하였습니다.");
            $('.umStatus').val(status);
            let text = '';
            text += `
            <button class="message-button">메시지</button>
            `;
            $btnHtml.html(text);
        },
        error : function (){
            console.log("실패여요");
        }
    });
});

$('.my-mentee-content').on('click', '.mentee2',function (){
    let userNumber = $(this).closest('.mentee-date').find('.mentor-num').val();
    $.ajax({
        url : '/mentor/nomentee',
        type: 'delete',
        data : {userNumber : userNumber},
        success : function (r){
            alert("거절하였습니다");
            console.log(r);
            menteeList(r)

        },
        error : function (){
            console.log("실패했다.");
        }
    })
});

//멘티 리스트
function menteeList(result){
    let text = '';

    result.forEach(r => {
        text += `
        <div class="mentee-box">
              <div class="mentee-profile">
                <input type="hidden" class="mentee-number" data-num="${r.userNumber}" value="${r.userNumber}"/>
                <div class="mentee-img">
                    ${r.pfpSystemName == null ? '<img class="img-box" src="/img/profile-basic.png"/>' :
                    '<img class="img-box" src=/profile/' + r.pfpUuid + '_' + r.pfpSystemName + '>' }
                </div>
                <span class="mentee-name">${r.userName}</span>
              </div>
              <div class="mentee-age">
                <span>${r.userBelong}</span>
              </div>
              <div class="mentee-gender">
                <span>${r.userIdentity}</span>
              </div>
              <div class="mentee-date">
                  <input type="hidden" class="mentor-num" value="${r.userNumber}"/>
                  <input type="hidden" class="add-num" value="${r.userNumber}"/>
                  <input type="hidden" class="umStatus" value="${r.umStatus}"/>
                  <div class="btn">`;
                if(r.umStatus == 'Y'){
                    text += `
                    <button class="message-button">메시지</button>
                    `;
                }
                if(r.umStatus == 'N'){
                    text +=
                    `
                    <button type="button" class="mentee1">수락</button>
                        <button type="button" class="mentee2">거절</button>
                    `;
                }
                  text += `
                </div>
              </div>
             </div>
        `;
    });
    $('.my-mentee-content').html(text);
}

//버튼 누를 시 이동처리
$('.point-mentor').on('click', function (){
    window.location.href = '/myPage/myMentor';
});

$('.point-mentee').on('click', function (){
    window.location.href = '/myPage/myMentee';
});

$('.like-mentor').on('click', function (){
    window.location.href = '/myPage/loveMentor';
});