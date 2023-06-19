let check = $("input[type='checkbox']");
check.click(function () {
  $(".toggle-ment").toggleClass("none");
});

let moreInfo = $(".mento-more-info-box");
moreInfo.click(function () {
  $(this).find(".mento-more-info").toggleClass("none");
});

// let share = $(".share-button");
// a.click(function CopyUrlToClipboard() {
//   var url = window.location.href; // 현재 페이지의 URL 가져오기
//   var tempInput = $("<input>"); // 임시로 input 요소 생성
//   share.append(tempInput);
//   tempInput.val(url); // input 요소의 값에 URL 설정
//   tempInput.select(); // input 요소 내용 선택
//   document.execCommand("copy"); // 복사 명령 실행
//   tempInput.remove(); // 임시 input 요소 제거
// });

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
