// 나눔 상태 변경
$(document).ready(function() {
    $("#changeStatusBtn").on("click", function() {
        changeStatus();
    });
});


function changeStatus() {
    let $checkedBox = $('.check-box:checked');
    let shareNumber = [];
    let shareStatus = [];

    for(let i=0; i<$checkedBox.length; i++){
        shareNumber.push( $checkedBox.eq(i).data('number'));
        shareStatus.push($checkedBox.closest('.user-table-category').find('.public-secret-select').val());
    }


    console.log(shareNumber)
    console.log('=============================')
    console.log(shareStatus)
    // var communityNumber = document.getElementById("communityNumber").value;
    // var currentStatus = document.getElementById("currentStatus").value; // 현재 상태 값을 가져옵니다.

    if (shareNumber === "") {
        alert("게시글 번호를 입력해주세요.");
        return false;
    }

    // var newStatus = currentStatus == "1" ? "0" : "1";

    $.ajax({
        type: "PATCH",
        url: "/status/updateShare",
        contentType: "application/json; charset=utf-8",
        traditional : true,
        data: JSON.stringify({shareNumber: shareNumber, shareStatus: shareStatus}),
        success: function() {
            alert("변경 성공");
        },
        error: function() {
            alert("변경 실패");
        }
    });
}


// 선택시 비공개로 바꾸기
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