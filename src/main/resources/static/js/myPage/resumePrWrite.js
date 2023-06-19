$("#growth").keyup(function (e) {
  let content = $(this).val();

  // 글자수 세기
  if (content.length == 0 || content == "") {
    $(".growth-count").text("0");
  } else {
    $(".growth-count").text(content.length);
  }

  // 글자수 제한
  if (content.length > 300) {
    // 300자 부터는 타이핑 되지 않도록
    $(this).val($(this).val().substring(0, 300));
    // 300자 넘으면 알림창 뜨도록
    alert("글자수는 300자까지 입력 가능합니다.");
  }
});

// =================================중복되는 코드

$("#personality").keyup(function (e) {
  let content = $(this).val();

  if (content.length == 0 || content == "") {
    $(".personality-count").text("0");
  } else {
    $(".personality-count").text(content.length);
  }

  if (content.length > 300) {
    $(this).val($(this).val().substring(0, 300));
    alert("글자수는 300자까지 입력 가능합니다.");
  }
});

$("#case").keyup(function (e) {
  let content = $(this).val();

  if (content.length == 0 || content == "") {
    $(".case-count").text("0");
  } else {
    $(".case-count").text(content.length);
  }

  if (content.length > 300) {
    $(this).val($(this).val().substring(0, 300));
    alert("글자수는 300자까지 입력 가능합니다.");
  }
});

$("#motive").keyup(function (e) {
  let content = $(this).val();

  if (content.length == 0 || content == "") {
    $(".motive-count").text("0");
  } else {
    $(".motive-count").text(content.length);
  }

  if (content.length > 300) {
    $(this).val($(this).val().substring(0, 300));
    alert("글자수는 300자까지 입력 가능합니다.");
  }
});

// ===============================반복
