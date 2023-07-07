
// 모달창
$(function () {
    $(".message-content").click(function () {
        $(".send-wrap").fadeIn();
    });
});

// 모달창이 나타났을 때 스크롤 제거
$(".message-content").on("click", function () {
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


// 답장하기 모달창
$(function () {
    $(".send-reply").click(function () {
        $(".input-wrap").fadeIn();
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










