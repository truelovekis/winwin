const dislikeBtn = document.querySelector('.heart-click');
const likeBtn = document.querySelector('.bi-heart-fill');

dislikeBtn.onclick = function () {
    let user = $('.user').val();
    if (user != ''){
        dislikeBtn.classList.add('hide');  // 빈하트에 .hide 적용
        likeBtn.classList.remove('hide');   // 빨간하트에 적용되어 있던 .hide 삭제
    }

    if(user == ''){
        confirm("아이디를 로그인 하셨나요?" +
            " 안하셨으면 좋아요 수가 안올라가요😂")// 빈하트 클릭했을 때
    }

}
likeBtn.onclick = function(){
    confirm("좋아요를 취소 할까요?😢")
    likeBtn.classList.add('hide');
    dislikeBtn.classList.remove('hide');

}

checkLike();
function checkLike(){
    let studyNumber = $(".Like").data("number");
    $.ajax({
       url: `/likes/${studyNumber}`,
        type: 'get',
        success: function(cnt){
           console.log(cnt);
           if(cnt==0){
               likeBtn.classList.add('hide');
               dislikeBtn.classList.remove('hide');
           }else{
               dislikeBtn.classList.add('hide');
               likeBtn.classList.remove('hide');
           }
        }
    });
}
/*수정 하기*/
function fn_modify(studyNumber){
    console.log("aaaaaaaaaaa")
    if(confirm("정말 수정하시겠습니까?")){
        location.href = "/project/modify?studyNumber=" + studyNumber;
    }
}
/*삭제 하기*/
function fn_delete(studyNumber){
    console.log("bbbbbb")
    if(confirm("정말 삭제하시겠습니까?")){
        location.href = "/project/delete?studyNumber=" + studyNumber;
    }
}



// 신고하기 페이지 이동
let reportModal = document.querySelector(".reportModal");
let reportBtn = document.querySelector(".police-btn");

reportBtn.addEventListener("click", function (){
    console.log("cccc");
    reportModal.style.display = "flex";
    document.body.style.overflow = "hidden";
});

reportModal.addEventListener("click", function (e){
    if ($(e.target).hasClass("reportModal")){
        reportModal.style.display = "none";
        document.body.style.overflow = "unset";
    }
});

// 신고하기 버튼 클릭 시 컨펌 및 신고처리
let $reportButton = $('.report-btn');
$reportButton.on("click", function (){
    console.log($('.report-list input:checked').val());

    let result = confirm("정말 신고하시겠습니까?");


    if(result){
        reportAjax();
    }
});

// 신고하기 처리
function reportAjax(){
    let studyNumber = $('.study-num').val();
    let policeCategory = $('.report-list input:checked').val();

    $.ajax({
        url:'/police/study',
        type: 'post',
        data: JSON.stringify({boardNumber: studyNumber, policeCategory:policeCategory}),
        contentType : 'application/json; charset=utf-8',
        success : function (){
            alert("정상적으로 신고처리 되었습니다.")
            location.href = "/meeting/home";
        }

    })
}

// 좋아요 처리
$('.Like').on("click", function () {
    let studyNumber = $(this).data('number');

    $.ajax({
       url: `/likes/${studyNumber}`,
        type: 'post',
        success : function (){
           console.log("성공입니다^_^");
        }
    });
});


//===================================================
let currentIdx = 1;

// 다른 프로젝트 슬라이드 배너 영역
$(function(){
    let frontLength = $(".front").length;
    let otherBoxWidth = frontLength * 507.5;
    $(".otherProject-box").css("width",`${otherBoxWidth}px`);



    $(".right-arrow").on(
        "click",
        function(){

            if (currentIdx < (frontLength/2) ){
                $('.left-arrow').attr("fill", "#000");
                $('.left-arrow').css("cursor", "pointer");

                let tmp = currentIdx*1050;
                $(".otherProject-box").css("transform",`translate(-${tmp}px)`);
                currentIdx += 1;
            }
            if(currentIdx >= (frontLength/2)){
                $('.right-arrow').attr("fill", "#cbd5e1");
                $('.right-arrow').css("cursor", "auto");
            }
        }
    );
    $(".left-arrow").on(
        "click",
        function(){
            if (currentIdx > 1 ) {
                $('.right-arrow').attr("fill", "#000");
                $('.right-arrow').css("cursor", "pointer");
                currentIdx -= 1;
                let tmp = -((currentIdx-1) * 1050);
                $(".otherProject-box").css("transform", `translate(${tmp}px)`);

            }

            if(currentIdx <= 1){
                $('.left-arrow').attr("fill", "#cbd5e1");
                $('.left-arrow').css("cursor", "auto");
            }
        }
    );
});

$('.chat-box').on('click', function (){
    let user = $('.user').val();
    let link = $('.link').val();

    if(user == ''){
        alert("로그인 하세요.");
        $('.login-move').trigger('click');
    }

    if(user != ''){
        window.location.href = link;
    }
})

$('.next-button').on('click', function (){
   window.location.href = '/meeting/home';
});













