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
$('.send-btn').on('click', function (){

    let num = $('.chattingTo').data('num');

    console.log("드러와 !!!!!!!!!!");
    console.log(num);

    $.ajax({
        url: "/chattings/inputModal",
        type: 'post',
        data: JSON.stringify({chattingTo : num, chattingContent : $('#inputMessage').val()}),
        contentType : "application/json; charset=utf-8",
        success: function (){
            alert("전송이 완료되었습니다.");
            $('.input-wrap').addClass('none');
            $('.form-reset')[0].reset();
        }
    })
});















