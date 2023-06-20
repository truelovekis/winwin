// 직무 or 학과 checkbox클릭시 발생되는 이벤트

$("#job-dep").on("change", function () {
    console.log($(this).val());
    let val = $(this).val();
    let $jobList = $(".job-list");
    let $depList = $(".dep-list");

    if (val == 1) {
        $jobList.hide();
        $depList.hide();
    } else if (val == 2) {
        $jobList.show();
        $depList.hide();
    } else if (val == 3) {
        $jobList.hide();
        $depList.show();
    }
});

// 직무 or 학과 선택 시 check박스 background-color 변경
let $jobSelect = $(".job-big-cateogry");
let $depSelect = $(".dep-big-cateogry");
let $selectedCheckbox = null;

$jobSelect.on("click", function () {
    if ($selectedCheckbox !== null) {
        $selectedCheckbox.css("background-color", "");
        $selectedCheckbox.css("color", "");
        $selectedCheckbox.css("font-weight", "");
    }

    $selectedCheckbox = $(this); // 새로 선택한 체크박스 저장
    $selectedCheckbox.css("background-color", "#eaf4ff");
    $selectedCheckbox.css("color", "#007aff");
    $selectedCheckbox.css("font-weight", "bold");
});

$depSelect.on("click", function () {
    if ($selectedCheckbox !== null) {
        $selectedCheckbox.css("background-color", "");
        $selectedCheckbox.css("color", "");
        $selectedCheckbox.css("font-weight", "");
    }

    $selectedCheckbox = $(this); // 새로 선택한 체크박스 저장
    $selectedCheckbox.css("background-color", "#eaf4ff");
    $selectedCheckbox.css("color", "#007aff");
    $selectedCheckbox.css("font-weight", "bold");
});

// 체크박스 선택하고 공개 비공개 설정하기
$(document).ready(function () {
    $("input.check").change(function () {
        var checkboxes = $("input.check:checked");
        var checkboxIndexes = checkboxes
            .map(function () {
                return $(this).closest("tr").index();
            })
            .get();

        checkboxes.each(function () {
            var checkbox = $(this);
            var checkboxIndex = checkbox.closest("tr").index();
            var isChecked = checkbox.is(":checked");

            if (isChecked) {
                $(".user-table tbody tr:eq(" + checkboxIndex + ") .public-secret-select").change(function () {
                    var selectElement = $(this);
                    var selectValue = selectElement.val();
                    handlePublicSecret(checkboxIndexes, selectValue);
                });
            }
        });
    });
});

function handlePublicSecret(checkboxIndexes, selectValue) {
    checkboxIndexes.forEach(function (index) {
        var publicSecretButton = $(".user-table tbody tr:eq(" + index + ") .public-secret-button");

        if (selectValue === "1") {
            publicSecretButton.text("공개").css({
                "background-color": "#eaf4ff",
                color: "#007aff",
            });
        } else if (selectValue === "2") {
            publicSecretButton.text("비공개").css({
                "background-color": "rgb(255, 237, 237)",
                color: "red",
            });
        }
    });
}
