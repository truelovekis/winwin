// 슬라이드
let $slideBox = $(".project-slide");
let $slideContent = $(".project-box");

let slideWidth = 490;

let slideCnt = $slideContent.length;

let currentIdx = 0;

checkEnd();

$(".bi-chevron-right").on("click", function () {
  if (currentIdx >= 2) {
    return;
  }
  console.log("next");

  currentIdx++;
  $slideContent.css("transition", "0.5s");
  $slideContent.css("left", -(currentIdx * slideWidth));
  addTransition();
  checkEnd();
});

$(".bi-chevron-left").on("click", function () {
  if (currentIdx <= 0) {
    return;
  }
  console.log("prev");
  currentIdx--;
  $slideContent.css("transition", "0.5s");
  $slideContent.css("left", -(currentIdx * slideWidth));
  addTransition();
  checkEnd();
});

// 슬라이드 이동속도
function addTransition() {
  for (let i = 0; i < $slideContent.length; i++) {
    if (i != currentIdx) {
      $slideContent.eq(i).css("transition", "0.2s");
    } else {
      $slideContent.eq(i).css("transition", "0.2s");
    }
  }
  checkEnd();
}

// 슬라이드 끝났을 때
function checkEnd() {
  console.log(currentIdx);
  console.log(slideCnt);
  if (currentIdx <= 0) {
    $(".prev").attr("stroke", "#ddd");
    $(".bi-chevron-left").css("cursor", "not-allowed");
    $slideContent.css("left", 0);
  } else {
    $(".prev").attr("stroke", "#000");
    $(".bi-chevron-left").css("cursor", "pointer");
  }
  if (currentIdx >= 2) {
    $(".next").attr("stroke", "#ddd");
    $(".bi-chevron-right").css("cursor", "not-allowed");
  } else {
    $(".next").attr("stroke", "#000");
    $(".bi-chevron-right").css("cursor", "pointer");
  }
}

//헤더 서브카테고리 생기게
$("li").hover(
  function () {
    $(this).css("border-bottom", "2px solid #1b5192");
    $(this).find(".h-font").css("color", "#1b5192");
    $(this).find(".sub").removeClass("none");
  },
  function () {
    $(this).css("border-bottom", "");
    $(this).find(".h-font").css("color", "#868686");
    $(this).find(".sub").addClass("none");
  }
);

// 모달창
// $(function () {
//   $(".login-join").click(function () {
//     $(".login-container").fadeIn();
//   });
//
//   $(".login-wrap").click(function () {
//     $(".login-container").fadeOut();
//   });
//
//   // $(".find-id-containder").fadeIn();
// });
//
// $(".login-join").on("click", function () {
//   $(".login-container").removeClass("none");
//   $(".login-container").css({
//     position: "fixed",
//     left: "50%",
//     top: "50%",
//     transform: "translate(-50%, -50%)",
//   });
// });
//
// $(".login-container").on("click", function (e) {
//   if ($(e.target).hasClass("login-container")) {
//     $(".login-container").addClass("none");
//   }
// });
