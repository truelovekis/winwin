const selectBoxElements = document.querySelectorAll(".certi-select");

function toggleSelectBox(selectBox) {
    selectBox.classList.toggle("certi-active");
}

function selectOption(optionElement) {
    const selectBox = optionElement.closest(".certi-select");
    const selectedElement = selectBox.querySelector(".certi-selected-value");
    selectedElement.textContent = optionElement.textContent;
}

selectBoxElements.forEach((selectBoxElement) => {
    selectBoxElement.addEventListener("click", function (e) {
        const targetElement = e.target;
        const isOptionElement = targetElement.classList.contains("certi-option");

        if (isOptionElement) {
            selectOption(targetElement);
        }

        toggleSelectBox(selectBoxElement);
        if (e.target.classList.contains("certi-option")) {
            $(e.target).closest(".certi-select").find(".certi-arrow").removeClass("certi-arrow-after");
        }

        e.preventDefault();
    });
});

document.addEventListener("click", function (e) {
    const targetElement = e.target;
    const isSelect = targetElement.classList.contains("certi-select") || targetElement.closest(".certi-select");

    if (isSelect) {
        return;
    }

    const allSelectBoxElements = document.querySelectorAll(".certi-select");

    allSelectBoxElements.forEach((boxElement) => {
        boxElement.classList.remove("certi-active");
        $(boxElement).find(".certi-arrow").removeClass("certi-arrow-after");
    });
});

// 클릭시 arrow 180도 회전
$(".certi-select").on("click", function (e) {
    // $('.arrow').css({"transform":"rotate(180deg)","transition":"all ease 0.5s"})

    // $(this).find('.arrow').css({"transform":"rotate(180deg)","transform-origin":"center","transition":"all ease 0.5s"})

    // if (e.target.tagName != "LI") {
    //     $(this).find(".job-arrow").addClass("job-arrow-after");
    // }
});

$(".certi-third-job-box").on("click", ".certi-option2", function () {
    let text = $(this).text();

    // let existingTags = $(".job-select-tag .job-tag");
    // if (existingTags.length >= 3) {
    //     return; // 최대 3개의 태그만 생성 가능
    // }

    let tagHtml = `<div class="certi-tag">@${text}</div>`;

    $(".certi-select-tag").append(tagHtml);
});

$(".certi-select-tag").on("click", ".certi-tag", function () {
    $(this).detach();
});

// 나의 관심분야 3가지 카테고리 박스
let $boxes = $('.certi-select');

//클릭하면 리스트 div 보기,닫기
$boxes.on('click', function(){
    if($(this).closest('.certi-select').find('.certi-option-box').hasClass('none')){
        $('.certi-option-box').addClass('none');
        $(this).closest('.certi-select').find('.certi-option-box').toggleClass('none');
    }else{
        $('.certi-option-box').addClass('none');
    }
});

//고른 항목 텍스트 상위로 복사
$('.certi-select').on('click', '.option', function(){
    $(this).closest('.certi-select').find('.certi-selected-value').text($(this).text());
});

//다른 곳 클릭 시 리스트 div 닫기
$("body").on('click', function(e){
    if(!$(e.target).closest('.certi-select').hasClass('certi-select')){
        $boxes.each((i, box) => {$(box).find('.certi-option-box').addClass('none');});
    }
});

//3차 카테고리 선택 시 태그 추가(최대 3개)
$(".certi-third-job-box").on("click", ".certi-option", function () {
    let text = $(this).text();
    let val = $(this).val();

    let existingTags = $(".certi-select-tag .certi-tag");
    if (existingTags.length >= 3) { return; }

    for(let i=0; i<existingTags.length; i++){
        if(existingTags.eq(i).text() == '@' + text){
            return;
        }
    }

    let tagHtml = `<div class="certi-tag" name="subNumber" value="${val}">@${text}
                                <input type="hidden" name="subNumber" value="${val}"/>
                            </div>
                            `;

    $(".certi-select-tag").append(tagHtml);
});

// 태그 눌렀을 때 삭제
$(".certi-select-tag").on("click", ".certi-tag", function () {
    $(this).detach();
});

// 1, 2, 3차 카테고리 별 항목 띄우기

// 1차 카테고리
let $category = $(".certi-first-option-box");
// 2차 카테고리
let $jobBox = $(".certi-second-job-box");
// 3차 카테고리
let $depBox = $(".certi-third-job-box");

$(".certi-option").on("click", function () {
    let text = "";
    $jobBox.html(text);
    // 직무일때
    let ss = $(this).val();
    if ($(this).val() == "1") {
        // 백엔드 작업시 비동기 통신 사용해서 꽂기
        $.ajax({
            url: "/users/certificationJ",
            type: "get",
            data: { mainCode: ss },
            dataType : 'json',
            success: function (result) {
                makeMiddleCate(result);
            },
        });

        // let obj = [
        //     { number: 1, name: "서비스업" },
        //     { number: 2, name: "의료/제약" },
        //     { number: 3, name: "제조/화학" },
        //     { number: 4, name: "판매/유통" },
        //     { number: 5, name: "IT/웹/통신" },
        // ];
        // text = makeMiddleCate(obj);
    }

    // 학과일때
    if ($(this).val() == "2") {
        // 백엔드 작업시 비동기 통신 사용해서 꽂기
        $.ajax({
            url: "/users/certificationH",
            type: "get",
            data: { mainCode: ss },
            dataType : 'json',
            success: function (result) {
                makeMiddleCate(result);
            },
        });
        //
        // let obj = [
        //     { number: 11, name: "사회" },
        //     { number: 12, name: "자연과학" },
        //     { number: 13, name: "의약" },
        //     { number: 14, name: "교육" },
        // ];
        // text = makeMiddleCate(obj);
    }

    $jobBox.html(text);
});

$(".certi-second-job-box").on("click", ".certi-option", function () {
    let text = "";

    $depBox.html(text)
    let ss = $(this).val();
    $.ajax({
        url : '/users/certificationSub',
        type : 'get',
        data : { mainCode : ss },
        dataType : 'json',
        success : function (result) {
            let text2 = '';
            result.forEach(r => {
                text2 +=`
                    <li class="certi-option" value="${r.subNumber}">${r.subName}</li>
                    `;
            });
            $('.certi-third-job-box').html(text2);
        }
    });
    $depBox.html(text);

    // if ($(this).val() == "1") {
    //     let obj = [{ number: 1, name: "서비스업1" }];
    //     text = makeSmallCate(obj);
    // } else if ($(this).val() == "2") {
    //     let obj = [{ number: 2, name: "의료/제약1" }];
    //     text = makeSmallCate(obj);
    // } else if ($(this).val() == "3") {
    //     let obj = [{ number: 3, name: "제조/화학1" }];
    //     text = makeSmallCate(obj);
    // } else if ($(this).val() == "4") {
    //     let obj = [{ number: 4, name: "판매/유통1" }];
    //     text = makeSmallCate(obj);
    // } else if ($(this).val() == "5") {
    //     let obj = [{ number: 5, name: "IT/웹/통신1" }];
    //     text = makeSmallCate(obj);
    // } else if ($(this).val() == "11") {
    //     let obj = [{ number: 11, name: "사회1" }];
    //     text = makeSmallCate(obj);
    // } else if ($(this).val() == "12") {
    //     let obj = [{ number: 12, name: "자연과학1" }];
    //     text = makeSmallCate(obj);
    // } else if ($(this).val() == "13") {
    //     let obj = [{ number: 13, name: "의약1" }];
    //     text = makeSmallCate(obj);
    // } else if ($(this).val() == "14") {
    //     let obj = [{ number: 14, name: "교육1" }];
    //     text = makeSmallCate(obj);
    // }
    //
    // $depBox.html(text);
});

// 2, 3차 카테고리 선택 시 항목 띄어주는 함수

function makeMiddleCate(result) {
    let text2 = '';

    result.forEach((r) => {
        text2 += `<li class="certi-option" value="${r.mainCode}">${r.mainName}</li>`;
    });

    $('.certi-second-job-box').html(text2);

    return text2;
}

// function makeSmallCate(obj) {
//     let list = obj;
//     let text = "";
//
//     list.forEach((cate) => {
//         text += `<li class="job-option job-option2" value="${cate.number}">${cate.name}</li>`;
//     });
//
//     return text;
// }