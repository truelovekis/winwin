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
