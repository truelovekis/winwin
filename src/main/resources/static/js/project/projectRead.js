const dislikeBtn = document.querySelector('.heart-click');
const likeBtn = document.querySelector('.bi-heart-fill');

dislikeBtn.onclick = function () {    // 빈하트 클릭했을 때
    dislikeBtn.classList.add('hide');  // 빈하트에 .hide 적용
    likeBtn.classList.remove('hide');   // 빨간하트에 적용되어 있던 .hide 삭제
}
likeBtn.onclick = function(){
    likeBtn.classList.add('hide');
    dislikeBtn.classList.remove('hide');

}

/*수정 하기*/
function fn_modify(studyNumber){
    console.log("aaaaaaaaaaa")
    if(confirm("정말 수정하시겠습니까?")){
        location.href = "/project/modify?studyNumber=" + studyNumber;
    }
}