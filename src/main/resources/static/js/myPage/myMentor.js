// 멘토 프로필 처리
let check = $("input[type='checkbox']");
check.click(function () {
  $(".toggle-ment").toggleClass("none");
});

let moreInfo = $(".mento-more-info-box");
moreInfo.click(function () {
  $(this).find(".mento-more-info").toggleClass("none");
});

$(".message-button").on("click", function () {
  $(".modal-wrap").removeClass("none");
  $(".modal-wrap").css({
    position: "fixed",
    left: "50%",
    top: "50%",
    transform: "translate(-50%, -50%)",
  });
});

$(".modal-wrap").on("click", function (e) {
  if ($(e.target).hasClass("modal-wrap")) {
    $(".modal-wrap").addClass("none");
  }
});

// ======================================
// 본인 프로필 이미지 변경
let $fileInput = $("#profile-img-upload");

$fileInput.on("change", function () {
  let src = URL.createObjectURL(this.files[0]);
  $(".pfp-icon-image").attr("src", src);
});


//=======================
// 추천 채우기
// const dislikeBtn = document.querySelector('.bi-hand-thumbs-up');
// const likeBtn = document.querySelector('.bi-hand-thumbs-up-fill');

// // 누를 시 꽉 찬 추천으로 변경
// dislikeBtn.onclick = function () { 
// dislikeBtn.classList.add('hide');  
// likeBtn.classList.remove('hide');   
// }

// // 다시 누르면 빈 추천으로 변경
// likeBtn.onclick = function(){
//   likeBtn.classList.add('hide');
//   dislikeBtn.classList.remove('hide');

// }

let $likeUp = $('.x1n2onr6');
let $likeDown = $('.bi-heart-fill');

$likeUp.on('click', function(){
  $(this).parents('.sec1').find('.bi-heart-fill').show();
  $(this).parents('.sec1').find('.x1n2onr6').hide();
});

$likeDown.on('click', function(){
  $(this).parents('.sec1').find('.bi-heart-fill').hide();
  $(this).parents('.sec1').find('.x1n2onr6').show();
});
  

let $likeUp2 = $('.bi-hand-thumbs-up');
let $likeDown2 = $('.bi-hand-thumbs-up-fill');

$likeUp2.on('click', function(){
  $(this).parents('.like-btn').find('.bi-hand-thumbs-up-fill').show();
  $(this).parents('.like-btn').find('.bi-hand-thumbs-up').hide();
});

$likeDown2.on('click', function(){
  $(this).parents('.like-btn').find('.bi-hand-thumbs-up-fill').hide();
  $(this).parents('.like-btn').find('.bi-hand-thumbs-up').show();
});

let $likeUp3 = $('.bi-hand-thumbs-up');
let $likeDown3 = $('.bi-hand-thumbs-up-fill');

$likeUp3.on('click', function(){
  $(this).parents('.share-like').find('.bi-hand-thumbs-up-fill').show();
  $(this).parents('.share-like').find('.bi-hand-thumbs-up').hide();
});

$likeDown3.on('click', function(){
  $(this).parents('.share-like').find('.bi-hand-thumbs-up-fill').hide();
  $(this).parents('.share-like').find('.bi-hand-thumbs-up').show();
});
  