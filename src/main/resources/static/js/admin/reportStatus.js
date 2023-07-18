// 신고게시글 상태 변경
$(document).ready(function() {
    $("#changeStatusBtn").on("click", function() {
        changeStatus3();
    });
});


function changeStatus3() {
    let $checkedBox = $('.check-box:checked');
    let policeVo = {};
    let policeVoArr = [];

    let postNumber = [];
    let status = [];
    let bigCode = [];

    for(let i=0; i<$checkedBox.length; i++){
        policeVo.postNumber= $checkedBox.eq(i).data('number');
        policeVo.status = $checkedBox.eq(i).closest('.user-table-category').find('.user-report-select').val();
        policeVo.bigCode = $checkedBox.eq(i).data('code');

        policeVoArr.push({...policeVo});
    }


    console.log(policeVoArr)
    // var communityNumber = document.getElementById("communityNumber").value;
    // var currentStatus = document.getElementById("currentStatus").value; // 현재 상태 값을 가져옵니다.

    // if (policeNumber == "") {
    //     alert("게시글 번호를 입력해주세요.");
    //     return false;
    // }

    // var newStatus = currentStatus == "1" ? "0" : "1";

    $.ajax({
        type: "patch",
        url: "/status/updateBoard",
        contentType: "application/json; charset=utf-8",
        traditional : true,
        data: JSON.stringify(policeVoArr),
        success: function() {
            alert("변경 성공");
        },
        error: function() {
            alert("변경 실패");
        }
    });
}

$(document).ready(function () {
    $("input.check").change(function () {
        var checkbox = $(this);
        var isChecked = checkbox.is(":checked");
        var row = checkbox.closest("tr");

        if (isChecked) {
            var selectElement = row.find(".user-report-select");
            var selectValue = selectElement.val();
            handleReportSelect(row, selectValue);
        } else {
            resetReportSelect(row);
        }
    });

    $(".user-report-select").change(function () {
        var selectElement = $(this);
        var row = selectElement.closest("tr");
        var isChecked = row.find("input.check").is(":checked");

        if (isChecked) {
            var selectValue = selectElement.val();
            handleReportSelect(row, selectValue);
        }
    });

    function handleReportSelect(row, selectValue) {
        var blindButton = row.find(".blind-button");
        var successButton = row.find(".success-button");

        if (selectValue === "1") {
            blindButton.text("공개").css({
                "background-color": "rgb(255, 214 ,156)",
                color: "rgb(254, 143, 0)",
            });
            successButton.text("공개").css({
                "background-color": "rgb(255, 214 ,156)",
                color: "rgb(254, 143, 0)",
            });

        } else if (selectValue === "0") {
            blindButton.text("비공개").css({
                "background-color": "rgb(255, 237, 237)",
                color: "red",
            });
            successButton.text("비공개").css({
                "background-color": "rgb(255, 237, 237)",
                color: "red",
            });
        }
    }
});
