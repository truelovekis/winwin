$("#inputMessage").keyup(function () {
    let content2 = $(this).val();

    // 글자수 세기
    if (content2.length == 0 || content2 == "") {
        $(".send-text-count").text("0");
    } else {
        $(".send-text-count").text(content2.length);
    }

    // 글자수 제한
    if (content2.length > 400) {
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
        url: '/mentor/inputModal',
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
        },
        error : function (){
            console.log(num);
            alert("실패함요");
        }
    })

});