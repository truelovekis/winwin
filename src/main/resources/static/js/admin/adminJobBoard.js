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

// mainCategory 불러오기
function sendSelection() {
    // 선택한 옵션 값을 가져옵니다.
    const selectElement = document.getElementById('job-dep');
    const selectedValue = selectElement.value;

    // 백엔드 서버에 선택한 값을 전송합니다.
    fetch('/admin/mainCategory', {
        method: 'POST', // HTTP 메소드를 변경하십시오 (GET, POST, PUT 등)
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ selectedValue: selectedValue })
    })
        .then(response => response.json()) // JSON 형식으로 서버 응답을 가져옵니다.
        .then(data => {
            // 요청 완료 후 필요한 작업 수행 (여기서는 콘솔에 서버 응답을 출력)
            console.log('data');
            console.log(data);
        })
        .catch(error => {
            // 요청에 문제가 발생한 경우 오류 처리를 수행합니다.
            console.error('Error:', error);
        });
}


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
        } else if (selectValue === "0") {
            publicSecretButton.text("비공개").css({
                "background-color": "rgb(255, 237, 237)",
                color: "red",
            });
        }
    });
}

// span에 디비 값 넣기
