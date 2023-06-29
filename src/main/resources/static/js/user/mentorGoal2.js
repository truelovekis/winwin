$("#mentor-goal-2-file").on("change", function () {
  let files = [...this.files];

  if (files.length == 1) {
    $(this).closest(".mentor-goal-2-box").find(".mentor-goal-2-file-name1").text(files[0].name);
    $(this).closest(".mentor-goal-2-box").find(".mentor-goal-2-name1").removeClass("mentor-goal-2-none");
    $(this).closest(".mentor-goal-2-box").find(".mentor-goal-2-file-name2").text("");
    $(this).closest(".mentor-goal-2-box").find(".mentor-goal-2-name2").addClass("mentor-goal-2-none");
  } else if (files.length == 2) {
    $(this).closest(".mentor-goal-2-box").find(".mentor-goal-2-file-name1").text(files[0].name);
    $(this).closest(".mentor-goal-2-box").find(".mentor-goal-2-name1").removeClass("mentor-goal-2-none");
    $(this).closest(".mentor-goal-2-box").find(".mentor-goal-2-file-name2").text(files[1].name);
    $(this).closest(".mentor-goal-2-box").find(".mentor-goal-2-name2").removeClass("mentor-goal-2-none");
  } else {
    alert("파일은 최대 2개까지 업로드 가능합니다.");
  }
});

$(".bi-trash2").on("click", function () {
  let targetName = $(this).closest(".mentor-goal-2-name-box").find(".mentor-goal-2-file-name1").text();
  $(this).closest(".mentor-goal-2-name-box").find(".mentor-goal-2-file-name1").text("");
  $(this).closest(".mentor-goal-2-name-box").find(".mentor-goal-2-name1").addClass("mentor-goal-2-none");
  $(this).closest(".mentor-goal-2-name-box").find(".mentor-goal-2-file-name2").text("");
  $(this).closest(".mentor-goal-2-name-box").find(".mentor-goal-2-name2").addClass("mentor-goal-2-none");

  let $input = $("#mentor-goal-2-file");
  let oldFiles = $input[0].files;
  console.log($input[0].files);

  let dt = new DataTransfer();

  for (let i = 0; i < 2; i++) {
    if ($input[0].files[i].name != targetName) {
      dt.items.add(oldFiles[i]);
    }
  }
  let newFiles = dt.files;

  $input[0].files = newFiles;

  console.log($input[0].files);
});
