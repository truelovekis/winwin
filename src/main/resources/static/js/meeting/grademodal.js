// 모집글 작성하기 모달창 영역
let searchButton = document.querySelector(".search-button");
let modalWrap = document.querySelector(".modal-wrap");

searchButton.addEventListener("click", function () {
    modalWrap.style.display = "flex";
    document.body.style.overflow = "hidden"; //모달창 스크롤 막기
});

modalWrap.addEventListener("click", function (e) {
    if($(e.target).hasClass("modal-wrap")){
        modalWrap.style.display = "none";
        document.body.style.overflow = "unset"; //모달창 스크롤 복구
    }

});
