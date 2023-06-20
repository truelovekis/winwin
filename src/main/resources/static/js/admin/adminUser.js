// 프로필 이미지 변경
let $fileInput = $("#adminImageUpload");

$fileInput.on("change", function () {
    let src = URL.createObjectURL(this.files[0]);
    $(".pfp-icon-image").attr("src", src);
    console.log(src);
});

//체크박스 전체선택

$("#checkAll").on("click", function () {
    console.log("checkAll");
    if ($(this).is(":checked")) {
        $(".check").prop("checked", true);
    } else {
        $(".check").prop("checked", false);
    }
});

$(".check").on("click", function () {
    console.log("check");
    if ($(".check:checked").length === $(".check").length) {
        $("#checkAll").prop("checked", true);
    } else {
        $("#checkAll").prop("checked", false);
    }
});
