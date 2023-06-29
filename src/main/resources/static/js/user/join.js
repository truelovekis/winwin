// let $checkIdMsg = $("#join-check-id-msg");
// let $checkPwMsg = $("#join-check-pw-msg");
// let $checkPwMsg2 = $("#join-check-pw-msg2");
//
// /*영어, 숫자, 특수문자로 이루어진 비밀번호 8글자 이상
//     영어 대소문자를 구분하지 않음*/
// const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;
//
// // 비밀번호 조건
// $("#join-pw-input").on("blur", function () {
//   if (regex.test($(this).val())) {
//     $checkPwMsg.text("사용가능한 비밀번호 입니다.");
//   } else {
//     $checkPwMsg.html("사용 불가능한 비밀번호입니다.<br>영어, 숫자, 특수문자를 포함한 8글자 이상으로 작성해주세요.");
//   }
//   if ($("#join-pw-input2").val() != "" && $("#join-pw-input").val() == $("#join-pw-input2").val()) {
//     $checkPwMsg2.html("비밀번호가 일치합니다.");
//   } else if ($("#join-pw-input2").val() != "" && $("#join-pw-input").val() != $("#join-pw-input2").val()) {
//     $checkPwMsg2.text("비밀번호가 일치하지 않습니다.");
//   }
// });
//
// // 비밀번호 동일확인
// $("#join-pw-input2").on("blur", function () {
//   console.log($("#join-pw-input").val());
//   if ($("#join-pw-input").val() != $("#join-pw-input2").val()) {
//     $checkPwMsg2.text("비밀번호가 일치하지 않습니다.");
//   } else {
//     $checkPwMsg2.html("비밀번호가 일치합니다.");
//   }
// });