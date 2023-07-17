// 댓글신고 상태 변경
$(document).ready(function() {
    $("#changeStatusBtn").on("click", function() {
        changeStatus2();
    });
});

function changeStatus2() {
    let $checkedBox = $('.check-box:checked');
    let policeVo = {};
    let policeVoArr = [];

    let commentNumber = [];
    let status = [];
    let bigCode = [];

    for(let i=0; i<$checkedBox.length; i++){
        policeVo.commentNumber= $checkedBox.eq(i).data('number');
        policeVo.status = $checkedBox.eq(i).closest('.user-table-category').find('.user-report-select').val();
        policeVo.bigCode = $checkedBox.eq(i).data('code');

        policeVoArr.push({...policeVo});
    }

    console.log(policeVoArr)


    // console.log(commentNumber)
    // console.log('=============================')
    // console.log(status)
    // var communityNumber = document.getElementById("communityNumber").value;
    // var currentStatus = document.getElementById("currentStatus").value; // 현재 상태 값을 가져옵니다.

    // if (commentNumber == "") {
    //     alert("게시글 번호를 입력해주세요.");
    //     return false;
    // }

    // var newStatus = currentStatus == "1" ? "0" : "1";
    // let status = $('.status1').val() == '1' ? '0' : '1';
    // let commentNumber1 = $('.commentNumber1').val();
    // console.log(commentNumber);
    $.ajax({
        type: "PATCH",
        url: "/status/updateCommentReport",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(policeVoArr),
        success: function() {
            // console.log(commentNumber);
            // alert("변경 성공");
            // $('.status1').val(status);
            // console.log(status);
        },
        error: function() {
            alert("변경 실패");
        }
    });
}




// $('#changeStatusBtn').on('click', function (){
//     let status = $('.status1').val() == '1' ? '0' : '1';
//     let commentNumber1 = $('.commentNumber1').val();
//     let code = $('#checking').data('code');
//     console.log("--------------------")
//     console.log(commentNumber1);
//     console.log("--------------------")
//     $.ajax({
//         type: "PATCH",
//         url: "/status/updateCommentReport",
//         contentType: "application/json; charset=utf-8",
//         traditional : true,
//         data: JSON.stringify({commentNumber: commentNumber1, status: status, bigCode : code}),
//         success: function() {
//             console.log(commentNumber1);
//             alert("변경 성공");
//             $('.status1').val(status);
//             console.log(status);
//         },
//         error: function() {
//             alert("변경 실패");
//         }
//     });
// })


// 체크박스 선택시 색깔 변경
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
                "background-color": "#eaf4ff",
                color: "#007aff",
            });
            successButton.text("공개").css({
                "background-color": "#eaf4ff",
                color: "#007aff",
            });
            // } else if (selectValue === "2") {
            //     blindButton.text("14일 정지").css({
            //         "background-color": "#eaf4ff",
            //         color: "#007aff",
            //     });
            //     successButton.text("14일 정지").css({
            //         "background-color": "#eaf4ff",
            //         color: "#007aff",
            //     });
            // } else if (selectValue === "3") {
            //     blindButton.text("30일 정지").css({
            //         "background-color": "#eaf4ff",
            //         color: "#007aff",
            //     });
            //     successButton.text("30일 정지").css({
            //         "background-color": "#eaf4ff",
            //         color: "#007aff",
            //     });
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

    function resetReportSelect(row) {
        // var blindButton = row.find(".blind-button");
        var successButton = row.find(".success-button");

        // blindButton.text("신고회원").css({
        //     "background-color": "#eaf4ff",
        //     color: "#007aff",
        // });
        successButton.text("영구 정지").css({
            "background-color": "rgb(220 255 226)",
            color: "#587c60",
        });
    }
});




