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