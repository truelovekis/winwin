let check = $("input[type='checkbox']");
check.click(function () {
  $(".toggle-ment").toggleClass("none");
});

let moreInfo = $(".mento-more-info-box");
moreInfo.click(function () {
  $(this).find(".mento-more-info").toggleClass("none");
});

//메세지 버튼
$(".message-button").on("click", function () {
  $(".modal-wrap").removeClass("none");
  $(".modal-wrap").css({
    position: "fixed",
    left: "50%",
    top: "50%",
    transform: "translate(-50%, -50%)",
  });
});

//좋아요 버튼
$('.like-button').on("click", function (e){
  e.preventDefault();
  let user = $('.user').val();
  if (user == ''){
    alert("로그인 해주세요!");
    $('.login-move').trigger('click')
  }

  if(user != ''){
    e.preventDefault();
    let btn = $(this).find('.bi-heart');
    let btn2 =$(this).find('.bi-heart-fill');
    if ($(this).val() == 0){
      let mentorNum = $(this).closest('.mento-button-box').find('.mentor-num').val();
      let num2 = $(this).closest('.main-mentor').find('.mentor-num').data('num');
      // console.log(num2);
      console.log(mentorNum);
      $.ajax({
        url : '/mentor/like',
        type : 'post',
        data : {mentorNumber : mentorNum},
        success : function (){
          console.log("성공");
        },
        error : function (){
          console.log("실패");
        }
      });
      btn2.show();
      btn.hide();
    }

    if($(this).val() == 1){
      e.preventDefault();
      let mentorNum =  $(this).closest('.mento-button-box').find('.mentor-num').val();
      let num2 = $(this).closest('.main-mentor').find('.mentor-num').data('num');
      $.ajax({
        url : '/mentor/delete',
        type : 'delete',
        data : {mentorNumber : mentorNum},
        success : function (){

          console.log("성공");
        },
        error : function (){
          console.log("실패");
        }
      });
      btn2.hide();
      btn.show();
    }
  }
});

//신청하기 모달
$(".modal-wrap1").on("click", function (e) {
  if ($(e.target).hasClass("modal-wrap1")) {
    $(".modal-wrap1").addClass("none");
  }
});

//멘토 신청하기
$('.modal-wrap1').on('click', '.um-btn' , function (e){
  let number = $(this).closest('.modal-wrap1').find('.addNumber').text();
  console.log(number);
  $.ajax({
    url : '/mentor/add',
    type : 'post',
    data : {mentorNumber : number},
    success : function (){
      console.log("성공");
      alert("신청에 성공하셨습니다.");
      $(e.target).hasClass("modal-wrap1");
      $(".modal-wrap1").addClass("none");
    },
    error : function (){
      console.log("실패");
    }
  })

});

//멘토 신청하기 버튼
$('.message-button').on("click",function () {
  let user =  $('.user').val();
  console.log(user);
  if(user == ''){
    alert("로그인 해주세요");
    $('.login-move').trigger('click');
  }
  if(user != ''){
    $(".modal-wrap1").removeClass("none");
    $(".modal-wrap1").css({
      position: "fixed",
      left: "50%",
      top: "50%",
      transform: "translate(-50%, -50%)",
    });
  }

  let name = $(this).closest('.item__box').find('.mento-name').text();
  let number = $(this).closest('.item__box').find('.add-num').val();
  $('.mentorName').text(name);
  $('.addNumber').text(number);
  console.log(number);

  $.ajax({
    url : '/mentor/profile2',
    type : 'get',
    data : {mentorNumber : number},
    success : function (r){
      mentorProfile(r);
    },
    error : function (){
      console.log("실패");
    }
  });
});

//멘토 프로필 불러오기
function mentorProfile(mentor){
  let text = '';
  text += `
    ${mentor.pfpSystemName == null ? '<img class="img-box" src="/img/profile-basic.png"/>' :
      '<img class="img-box" src=/profile/' + mentor.pfpUuid + '_' + mentor.pfpSystemName + '>' }
    `;
  $('.mento-profile-photo-box2').html(text);
}

/* 쪽지 모달창 */
$(function () {
  $(".chatting-button").click(function () {
    $(".input-wrap").fadeIn();
    let userNickname = $(this).closest('.item').find('.mento-name').text();
    let num = $(this).closest('.item').find('.mentor-num').data('num');

    $('.chattingTo').text(userNickname);
    $('.chattingTo').data('num', num);
  });
});

$(".chatting-button").on("click", function () {
  $(".input-wrap").removeClass("none");

  $('body').css('overflow', 'hidden');
});

$(".input-wrap").on("click", function (e) {

  if ($(e.target).hasClass("input-wrap")) {
    $(".input-wrap").addClass("none");
    $('body').css('overflow', 'auto');

    $('.form-reset')[0].reset();
  }
});

//더보기 클릭
$('.mento-more-info-box').on('click',function (){
  console.log("선택 됐다");
  let $target = $(this).prev('.mento-profile');

  if($target.css('max-height') == 'none'){
    $target.css('max-height' , "170px")
  }else {
    $target.css('max-height' , "none");
  }

});

//버튼 누를 시 이동처리
$('.point-mentor').on('click', function (){
  window.location.href = '/myPage/myMentor';
});

$('.point-mentee').on('click', function (){
  window.location.href = '/myPage/myMentee';
});

$('.like-mentor').on('click', function (){
  window.location.href = '/myPage/loveMentor';
});