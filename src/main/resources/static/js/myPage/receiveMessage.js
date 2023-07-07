
// 모달창
$(function () {
    $(".message-content").click(function () {
        $(".send-wrap").fadeIn();

        let chattingNumber= $('.message-list').data('ctnum');

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
            }
        })


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

// 신고하기 버튼 클릭 시 컨펌 및 신고처리
// let $reportButton = $('.report-btn');
// $reportButton.on("click", function (){
//
//     let result = confirm("정말 신고하시겠습니까?");
//
//     if(result){
//         userReport();
//     }
// });










