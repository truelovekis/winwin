$('#count_memo').keyup(function (e){
    var content = $(this).val();
    $('#cnt').html("("+content.length+" / 50)");    //글자수 실시간 카운팅

    if (content.length > 50){
        alert("최대 50자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 50));
        $('#cnt').html("(50 / 50)");
    }
});

// 카테고리

// let page = 1;
// $(window).on('scroll', function(){
// //    $(window).scrollTop() : 현재 브라우저 스크롤 위치를 반환함
//     console.log($(window).scrollTop());
//     //$(document).height() : 문서 전체의 높이를 의미함
//     console.log(`document : ${$(document).height()}`);
//     //$(window).height() : 브라우저 화면의 높이를 의미함
//     console.log(`window : ${$(window).height()}`);
//
//     if($(window).scrollTop() == $(document).height() - $(window).height()){
//         console.log(++page);
//         // reply.getListPage({boardNumber : boardNumber , page : page}, appendReply, showError);
//     }
// });


let moreInfo = $(".mento-more-info-box");

moreInfo.click(function () {
    $(this).find(".mento-more-info").toggleClass("none");
});

let share = $(".share-button");

share.click(function CopyUrlToClipboard() {
    var url = 'http://localhost:10000/mentor/list'; // 현재 페이지의 URL 가져오기
    var tempInput = $("<input>"); // 임시로 input 요소 생성
    share.append(tempInput);
    tempInput.val(url); // input 요소의 값에 URL 설정
    tempInput.select(); // input 요소 내용 선택
    document.execCommand("copy"); // 복사 명령 실행
    tempInput.remove(); // 임시 input 요소 제거
    alert("복사가 완료 되었습니다.");
});

$(".message-button").on("click", function () {
    $(".modal-wrap1").removeClass("none");
    $(".modal-wrap1").css({
        position: "fixed",
        left: "50%",
        top: "50%",
        transform: "translate(-50%, -50%)",
    });

    let name = $(this).closest('.item__box').find('.mento-name').text();
    let number = $(this).closest('.item__box').find('.add-num').val();
    console.log(number);
    console.log(name);
    $('.mentorName').text(name);
    $('.addNumber').text(number);
});

$(".modal-wrap1").on("click", function (e) {
    if ($(e.target).hasClass("modal-wrap1")) {
        $(".modal-wrap1").addClass("none");
    }
});

// 태그 필터
const selectBoxElements2 = document.querySelectorAll(".select");

function toggleSelectBox(selectBox) {
    selectBox.classList.toggle("active");
}

function selectOption(optionElement) {
    const selectBox = optionElement.closest(".select");
    const selectedElement = selectBox.querySelector(".selected-value");
    selectedElement.textContent = optionElement.textContent;
}

selectBoxElements2.forEach((selectBoxElement) => {
    selectBoxElement.addEventListener("click", function (e) {
        console.log("aaaaaaa")
        const targetElement = e.target;
        const isOptionElement = targetElement.classList.contains("option");

        if (isOptionElement) {
            selectOption(targetElement);
        }

        toggleSelectBox(selectBoxElement);
        if (e.target.classList.contains("option")) {
            $(e.target).closest(".select").find(".arrow").removeClass("arrow-after");
        }

        e.preventDefault();
    });
});

document.addEventListener("click", function (e) {
    const targetElement = e.target;
    const isSelect =
        targetElement.classList.contains("select") ||
        targetElement.closest(".select");

    if (isSelect) {
        return;
    }

    const allSelectBoxElements = document.querySelectorAll(".select");

    allSelectBoxElements.forEach((boxElement) => {
        boxElement.classList.remove("active");
        $(boxElement).find(".arrow").removeClass("arrow-after");
    });
});

// 클릭시 arrow 180도 회전
$(".select").on("click", function (e) {

});

$(".middle-option-box").on("click", ".middle-option", function () {
    let text = $(this).text();

    let tagHtml = `<span class="tag">@${text}</span>`;

    $(".select-tag").append(tagHtml);
});

$(".select-tag").on("click", ".tag", function () {
    $(this).detach();
});

// 나의 관심분야 3가지 카테고리 박스
let $boxes = $('.select');

//클릭하면 리스트 div 보기,닫기
$boxes.on('click', function(){
    if($(this).closest('.select').find('.option-box').hasClass('none')){
        $('.option-box').addClass('none');
        $(this).closest('.select').find('.option-box').toggleClass('none');
    }else{
        $('.option-box').addClass('none');
    }
});

//고른 항목 텍스트 상위로 복사
$('.select').on('click', '.option', function(){
    $(this).closest('.select').find('.selected-value').text($(this).text());
});

//다른 곳 클릭 시 리스트 div 닫기
$("body").on('click', function(e){
    if(!$(e.target).closest('.select').hasClass('select')){
        $boxes.each((i, box) => {$(box).find('.option-box').addClass('none');});
    }
});

//3차 카테고리 선택 시 태그 추가(최대 3개)
$(".third-job-box").on("click", ".option", function () {
    let text = $(this).text();
    let val = $(this).val();

    let existingTags = $(".select-tag .tag");
    if (existingTags.length >= 10) { return; }

    for(let i=0; i<existingTags.length; i++){
        if(existingTags.eq(i).text() == '@' + text){
            return;
        }
    }

    let tagHtml = `<div class="tag" value="${val}">@${text}</div>`;
    // <input type="hidden" value="${val}" name="subNumber"/>

    $(".select-tag").append(tagHtml);
});

$(".select-tag").on("click", ".tag", function () {
    $(this).detach();
});


// 1, 2, 3차 카테고리 별 항목 띄우기

// 1차 카테고리
// let $category = $(".first-option-box");
// 2차 카테고리
let $jobBox2 = $(".second-job-box");
// 3차 카테고리
let $depBox2 = $(".third-job-box");

$(".option").on("click", function () {
    let text = "";
    $jobBox2.html(text);
    let ss = $(this).val();
    if($(this).val() == "1"){
        $.ajax({
            url: "/category/categoryJ",
            type: "get",
            data: {mainCode: ss},
            dataType : 'json',
            success: function (result) {
                makeMiddleCate(result);
            },
        });
    }
    if($(this).val() == "2"){
        $.ajax({
            url: "/category/categoryH",
            type: "get",
            data: {mainCode: ss},
            dataType : 'json',
            success: function (result) {
                makeMiddleCate(result);
            },
        });
    }
    $jobBox2.html(text);
});

$(".second-job-box").on("click", ".option", function () {
    let text = "";
    $depBox2.html(text)
    let ss = $(this).val();
    $.ajax({
        url : '/category/subCategory',
        type : 'get',
        data : { mainCode : ss },
        dataType : 'json',
        success : function (result) {
            let text2 = '';
            result.forEach(r => {
                text2 +=`
                    <li class="option" value="${r.subNumber}">${r.subName}</li>
                    `;
            });
            $('.third-job-box').html(text2);
        }
    });
    $depBox2.html(text);
});

// 2, 3차 카테고리 선택 시 항목 띄어주는 함수

function makeMiddleCate(result) {
    let text2 = '';

    result.forEach(r => {
        text2 += `
        <li class="option" value="${r.mainCode}">${r.mainName}</li>
        `;
    });
    $('.second-job-box').html(text2);

    return text2;
}

let check = $("#suggest-profile");
let height = parseInt($(".myProfile").css("height")) + 25;

check.click(function () {
    $(".toggle-ment").toggleClass("none");

    if ($('p[class="toggle-ment none"]').text().trim() != "올림") {
        $(".myProfile-box").css("height", height);
    } else {
        $(".myProfile-box").css("height", 0);
    }
});

