
// 모달창
$(function () {
    $(".message-box").click(function () {
        $(".send-wrap").css("display", "flex");
        $(".send-wrap").fadeIn();

        let chattingNumber= $(this).closest('.message-box').find('.message-list').data('cnum');

        $.ajax({
            url: "/chattings/sendModal2",
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
$(".message-content").on("click", function () {
    $(".send-wrap").removeClass("none");

    $('body').css('overflow', 'hidden');
});

// 검은 화면 누르면 모달창 제거
$(".send-wrap").on("click", function (e) {

    if ($(e.target).hasClass("send-wrap")) {
        $(".send-wrap").css("display", "none");
        $(".send-wrap").addClass("none");
        $('body').css('overflow', 'auto');

        $('.form-reset')[0].reset();
    }
});


// 답장하기 모달창
$(function () {
    $(".send-reply").click(function (e) {
        e.stopPropagation();
        $(".input-wrap").fadeIn();

        let userNickname = $(this).closest('.message-box').find('.sender').text();
        let num = $(this).data('uunum');

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










