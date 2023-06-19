//체크박스 전체선택
$("#check1").on("click", function () {
  if ($(this).is(":checked")) {
    $(".check").prop("checked", true);
  } else {
    $(".check").prop("checked", false);
  }
});

$(".agreement-input-btn").on("click", ".check", function () {
  console.log("check");
  $("#check1").prop("checked", false);
});

$(".check").on("change", function () {
  if ($("#check2").is(":checked") && $("#check3").is(":checked") && $("#check4").is(":checked")) {
    $("#check1").prop("checked", true);
  }
});
