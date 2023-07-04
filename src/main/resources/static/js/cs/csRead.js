// 사용자가 입력한 내용을 서버에 전송하고 응답을 받아와서 내용을 업데이트하는 함수
function updateContent() {
    // 사용자가 입력한 값들을 받아온다고 가정
    var userNameInput = "";
    var questionTitleInput = "";

    // AJAX 요청 설정
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/updateQuestionContent', true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    // 요청 데이터 설정
    var requestData = {
        userName: userNameInput,
        questionTitle: questionTitleInput
    };

    // 요청 전송
    xhr.send(JSON.stringify(requestData));

    // 요청에 대한 응답 처리
    xhr.onload = function() {
        if (xhr.status === 200) {
            var response = JSON.parse(xhr.responseText);
            var questionContent = response.questionContent;

            // 응답 받은 내용으로 내용을 업데이트
            document.getElementById("questionContent").innerText = questionContent;
        }
    };
}

// 페이지 로드 시 내용 업데이트 함수 호출
window.onload = updateContent;

function fn_modify(csNumber){
    if(confirm("정말 수정하시겠습니까?")){
        location.href = "/cs/modify?csNumber="+csNumber;
    }
}

function fn_remove(csNumber) {
    if (confirm("정말 삭제하시겠습니까?")) {
        location.href = "/cs/remove?csNumber="+csNumber;
    }
}


// 댓글 작성

