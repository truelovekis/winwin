//무한 스크롤 페이징
$(window).on('scroll', function(){
  //    $(window).scrollTop() : 현재 브라우저 스크롤 위치를 반환함
      console.log($(window).scrollTop());
      //$(document).height() : 문서 전체의 높이를 의미함
      console.log(`document : ${$(document).height()}`);
      //$(window).height() : 브라우저 화면의 높이를 의미함
      console.log(`window : ${$(window).height()}`);
  
      if($(window).scrollTop() == $(document).height() - $(window).height()){
          console.log(++page);
          reply.getListPage({boardNumber : boardNumber , page : page}, appendReply, showError);
      }
  });


// 프로필 이미지 변경
let $fileInput = $('#file');

$fileInput.on('change', function(){
    let src = URL.createObjectURL(this.files[0]);
    $('.userpfp').attr('src', src);
});

// 좋아요 처리
let $likeUp = $('.bi-hand-thumbs-up');
let $likeDown = $('.bi-hand-thumbs-up-fill');

$likeUp.on('click', function(){
    $(this).parents('.community-btn').find('.bi-hand-thumbs-up-fill').show();
    $(this).parents('.community-btn').find('.bi-hand-thumbs-up').hide();
});

$likeDown.on('click', function(){
    $(this).parents('.community-btn').find('.bi-hand-thumbs-up-fill').hide();
    $(this).parents('.community-btn').find('.bi-hand-thumbs-up').show();
});


function fn_read(communityNumber){
    location.href = "/community/read?communityNumber="+communityNumber;
}



// 모달창
$(function () {
    $(".pfp-main-btn").click(function () {
        $(".modal-container").fadeIn();
    });
});

// 모달창이 나타났을 때 스크롤 제거
$(".pfp-main-btn").on("click", function () {
    $(".modal-container").removeClass("none");
    $('body').css('overflow', 'hidden');
});

// 검은 화면 누르면 모달창 제거
$(".modal-container").on("click", function (e) {
    if ($(e.target).hasClass("modal-container")) {
        $(".modal-container").addClass("none");
        $('body').css('overflow', 'auto');
        modalSetUp2();
    }
});

function modalSetUp2(){
    $('.modal-wrap>div').addClass('none');
    $('.modal-wrap>button').addClass('none');
    $('.modal-wrap>div').removeClass('disappear');
    $('.login-box').removeClass('none');
    $('.login-end').removeClass('none');
    $('.login-box').removeClass('disappear');
    $current = $('.login-box');
    $next = null;
    $('.form-reset')[0].reset();
}


// 병구가 확인한 질문하기 모달창 처리
// $('.pfp-main-btn').on('click', function (e) {
//     e.preventDefault();
//
//     let userNumber = $('.pfp-main-btn').data('usernumber');
//     console.log(userNumber);
//
//     if(userNumber){
//         window.location.href = '/share/write';
//     }else {
//         $('.login-move').trigger('click');
//     }
// });


