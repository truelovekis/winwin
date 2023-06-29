// 신고회원 상태 변경
$(document).ready(function() {
    $("#changeStatusBtn").on("click", function() {
        changeStatus();
    });
});


function changeStatus() {
    let $checkedBox = $('.check-box:checked');
    let userNumber = [];
    let userStatus = [];

    for(let i=0; i<$checkedBox.length; i++){
        userNumber.push( $checkedBox.eq(i).data('number'));
        userStatus.push($checkedBox.closest('.user-table-category').find('.user-report-select').val());
    }


    console.log(userNumber)
    console.log('=============================')
    console.log(userStatus)
    // var communityNumber = document.getElementById("communityNumber").value;
    // var currentStatus = document.getElementById("currentStatus").value; // 현재 상태 값을 가져옵니다.

    if (userNumber === "") {
        alert("게시글 번호를 입력해주세요.");
        return false;
    }

    // var newStatus = currentStatus == "1" ? "0" : "1";

    $.ajax({
        type: "PATCH",
        url: "/status/updateReport",
        contentType: "application/json; charset=utf-8",
        traditional : true,
        data: JSON.stringify({userNumber: userNumber, userStatus: userStatus}),
        success: function() {
            alert("변경 성공");
        },
        error: function() {
            alert("변경 실패");
        }
    });
}