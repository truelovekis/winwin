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

$('.my-mentee-content').on('click', '.mentee1' ,function (){
    let userNumber = $(this).closest('.mentee-date').find('.mentor-num').val();
    let status =  $(this).closest('.mentee-date').find('.umStatus').val() == 'N' ? 'Y' : 'N';
    let $btnHtml = $(this).closest('.mentee-date').find('.btn');
    console.log(userNumber);
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