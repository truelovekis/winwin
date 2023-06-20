$("#selectbox > option");
$("#selectbox > option:checked");
$('select[name="selectbox"] > option:checked').val();
$('select[name="selectbox"] > option:checked').text();

document.querySelector("#selectbox > option:checked");
document.querySelector("#selectbox > option:checked").value;
document.querySelector('select[name="selectbox"] > option:checked').innerText;

// document.querySelector("#selectbox")[];
makeYear();
makeMonth();

function makeYear() {
    let year = new Date().getFullYear();
    let frame = "";

    for (year; year >= 1970; year--) {
        frame += `<option value="${year}">${year}년</option>`;
    }
    $(".year1").append(frame);
    $(".year2").append(frame);
}

function makeMonth() {
    let frame = "";
    for (let i = 1; i < 13; i++) {
        frame += `<option value="${i}">${i}월</option>`;
    }

    $(".month1").append(frame);
    $(".month2").append(frame);
}

$(".year1").on("change", function () {
    let year = $(this).val();
    let month = $(".month1").val();

    switchSelectBox(year, month);
});

$(".month1").on("change", function () {
    let month = $(this).val();
    let year = $(".year1").val();

    switchSelectBox(year, month);
});

function switchSelectBox(year, month) {
    if (year && month) {
        $(".year2").attr("disabled", false);
        $(".month2").attr("disabled", false);
        $(".year2").css("color", "black");
        $(".year2").css("background-color", "white");

        $(".month2").css("color", "black");
        $(".month2").css("background-color", "white");
    }
}

//================================
let nowBox = $("#now-box").html();

$("#is-current-career").on("change", function () {
    console.log($(this).is(":checked"));
    let selectBox = `
    <input id="now-input" value="현재" disabled>
  `;
    if ($(this).is(":checked")) {
        $("#now-box").html(selectBox);
    } else {
        $("#now-box").html(nowBox);
    }
});
