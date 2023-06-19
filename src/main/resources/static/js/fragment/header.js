//헤더 서브카테고리 생기게
$("li").hover(
    function () {
        $(this).css("border-bottom", "2px solid #1b5192");
        $(this).find(".h-font").css("color", "#1b5192");
        $(this).find(".sub").removeClass("none");
    },
    function () {
        $(this).css("border-bottom", "");
        $(this).find(".h-font").css("color", "#868686");
        $(this).find(".sub").addClass("none");
    }
);