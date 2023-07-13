
// 모달창
$(function () {
    $(".message-box").click(function () {
        $(".send-wrap").fadeIn();

        let chattingNumber= $(this).closest('.message-box').find('.message-list').data('ctnum');

        $.ajax({
           url: "/chattings/sendModal",
            type: 'get',
            data: {chattingNumber : chattingNumber},
            success: function (result){
               if(result == null){
               alert("삭제된 쪽지입니다.");
               }
                $('.send-sender').text(result.userNickname);
                $('.send-content-chat').text(result.chattingContent);
                $('.send-date-s').text(result.chattingDate);
            }
        })


    });
});

// 모달창이 나타났을 때 스크롤 제거
$(".message-box").on("click", function () {
    $(".send-wrap").removeClass("none");

    $('body').css('overflow', 'hidden');
});

// 검은 화면 누르면 모달창 제거
$(".send-wrap").on("click", function (e) {

    if ($(e.target).hasClass("send-wrap")) {
        $(".send-wrap").addClass("none");
        $('body').css('overflow', 'auto');

        $('.form-reset')[0].reset();
    }
});

// 신고하기 모달창
$(function () {
    $(".message-police").click(function () {
        $(".reportModal").fadeIn();
    });
});

$(".message-police").on("click", function () {
    $(".reportModal-content").removeClass("none");
    $(".reportModal").css("display", "flex");

    $('body').css('overflow', 'hidden');
});

$(".reportModal").on("click", function (e) {

    if ($(e.target).hasClass("reportModal")) {
        $(".reportModal").addClass("none");
        $('body').css('overflow', 'auto');
        $(".reportModal").css("display", "none");

        $('.form-reset')[0].reset();
    }
});

// 답장하기 모달창
$(function () {
    $(".send-reply").click(function (e) {
        e.stopPropagation();
        $(".input-wrap").fadeIn();

        let userNickname = $(this).closest('.message-box').find('.sender').text();
        let num = $(this).data('unum');

        $('.chattingTo').text(userNickname);
        $('.chattingTo').data('num', num);
    });


});

$(".send-reply").on("click", function () {
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













