// 진로정보 상태 변경
$(document).ready(function() {
    $("#changeStatusBtn").on("click", function() {
        changeStatus();
    });
});


function changeStatus() {
    let $checkedBox = $('.check-box:checked');
    let careerInfoNumber = [];
    let careerInfoStatus = [];

    for(let i=0; i<$checkedBox.length; i++){
        careerInfoNumber.push( $checkedBox.eq(i).data('number'));
        careerInfoStatus.push($checkedBox.closest('.user-table-category').find('.public-secret-select').val());
    }


    console.log(careerInfoNumber)
    console.log('=============================')
    console.log(careerInfoStatus)
    // var communityNumber = document.getElementById("communityNumber").value;
    // var currentStatus = document.getElementById("currentStatus").value; // 현재 상태 값을 가져옵니다.

    if (careerInfoNumber === "") {
        alert("게시글 번호를 입력해주세요.");
        return false;
    }

    // var newStatus = currentStatus == "1" ? "0" : "1";

    $.ajax({
        type: "PATCH",
        url: "/status/updateCareer",
        contentType: "application/json; charset=utf-8",
        traditional : true,
        data: JSON.stringify({careerInfoNumber: careerInfoNumber, careerInfoStatus: careerInfoStatus}),
        success: function() {
            alert("변경 성공");
        },
        error: function() {
            alert("변경 실패");
        }
    });
}