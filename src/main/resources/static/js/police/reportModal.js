// 신고 모달창 체크박스 한가지만 선택하게 하기
$(document).ready(function () {
    $('input[type="checkbox"][name="report-checkbox"]').click(function () {
        if ($(this).prop("checked")) {
            $('input[type="checkbox"][name="report-checkbox"]').prop("checked", false);
            $(this).prop("checked", true);
        }
    });
});
