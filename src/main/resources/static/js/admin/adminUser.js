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

// let $OfficeWorkersBtn = $('.officeWorkers');
// let $CollegeStudentBtn = $('.collegeStudent');
//
// $OfficeWorkersBtn.on('change', function(){
//     $(this).parents('.select-btn').find('.hideNone').show();
//     $(this).parents('.select-btn').find('.hide').hide();
// });
//
// $CollegeStudentBtn.on('change', function(){
//     $(this).parents('.select-btn').find('.hideNone').hide();
//     $(this).parents('.select-btn').find('.hide').show();
// });

$("#identity").on("change", function () {
    console.log($(this).val());
    let val = $(this).val();
    let $first = $(".hideNone");
    let $second = $(".hide");
    let $third = $(".hide2")

    if (val == 'W') {
        $first.show();
        $second.hide();
        $third.hide();
    } else if (val == 'U') {
        $first.hide();
        $second.show();
        $third.hide();
    } else if (val == 'H') {
        $first.hide();
        $second.hide();
        $third.show();
    }
});
