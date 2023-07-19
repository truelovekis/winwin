//글자수 실시간 카운팅
$('#count_memo').keyup(function (e){
    var content = $(this).val();
    $('#cnt').html("("+content.length+" / 50)");

    if (content.length > 50){
        alert("최대 50자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 50));
        $('#cnt').html("(50 / 50)");
    }
});


// 태그 필터
const selectBoxElements2 = document.querySelectorAll(".select");

function toggleSelectBox(selectBox) {
    selectBox.classList.toggle("active");
}

function selectOption2(optionElement) {
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
            selectOption2(targetElement);
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
let $boxes2 = $('.select');

//클릭하면 리스트 div 보기,닫기
$boxes2.on('click', function(){
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
        $boxes2.each((i, box) => {$(box).find('.option-box').addClass('none');});
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

    let tagHtml = `<div class="tag" data-value="${val}">@${text}</div>`;
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
let $jobBox2 = $(document.querySelector('.second-job-box'));
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
                text = makeMiddleCate(result);
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
                text = makeMiddleCate(result);
            },
        });
    }
    $jobBox2.eq(0).html(text);
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

$('.writeOk').on('click', function(){
    let $tagList = $('.tag')

    if($tagList.length == 0){
        alert("카테고리를 선택 후 작성해주세요");
        return false;
    }


    let valueList = [];
    $tagList.each((i, tag) => {
        valueList.push($(tag).data('value'));

    });
    console.log(valueList)

    let input = '';

    valueList.forEach(value => {
        input += `<input type="hidden" value="${value}" name="subList">`;
    });

    $('.qna-form').append(input);


    $('.qna-form').submit();
})