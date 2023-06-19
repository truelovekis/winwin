// 1,2,3차 카테고리 선택

const selectBoxElements = document.querySelectorAll(".select");

function toggleSelectBox(selectBox) {
    selectBox.classList.toggle("active");
}

function selectOption(optionElement) {
    const selectBox = optionElement.closest(".select");
    const selectedElement = selectBox.querySelector(".selected-value");
    selectedElement.textContent = optionElement.textContent;
}

selectBoxElements.forEach((selectBoxElement) => {
    selectBoxElement.addEventListener("click", function (e) {
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
    // $('.arrow').css({"transform":"rotate(180deg)","transition":"all ease 0.5s"})

    // $(this).find('.arrow').css({"transform":"rotate(180deg)","transform-origin":"center","transition":"all ease 0.5s"})

    if (e.target.tagName != "LI") {
        $(this).find(".arrow").addClass("arrow-after");
    }
});

$(".third-job-box").on("click", ".option2", function () {
    let text = $(this).text();

    let existingTags = $(".select-tag .tag");
    if (existingTags.length >= 3) {
        return; // 최대 3개의 태그만 생성 가능
    }

    let tagHtml = `<div class="tag">@${text}</div>`;

    $(".select-tag").append(tagHtml);
});

$(".select-tag").on("click", ".tag", function () {
    $(this).detach();
});

// 1, 2, 3차 카테고리 별 항목 띄우기

// 1차 카테고리
let $category = $(".first-option-box");
// 2차 카테고리
let $jobBox = $(".second-job-box");
// 3차 카테고리
let $depBox = $(".third-job-box");

$(".option").on("click", function () {
    let text = "";
    $jobBox.html(text);
    // 직무일때
    if ($(this).val() == "1") {
        // 백엔드 작업시 비동기 통신 사용해서 꽂기
        // $.ajax({
        //   url: "....",
        //   type: "get",
        //   data: { cateNumber: 1 },
        //   success: function (result) {
        //     text = makeMiddleCate(result);
        //   },
        // });

        let obj = [
            { number: 1, name: "서비스업" },
            { number: 2, name: "의료/제약" },
            { number: 3, name: "제조/화학" },
            { number: 4, name: "판매/유통" },
            { number: 5, name: "IT/웹/통신" },
        ];
        text = makeMiddleCate(obj);
    }

    // 학과일때
    if ($(this).val() == "2") {
        // 백엔드 작업시 비동기 통신 사용해서 꽂기
        // $.ajax({
        //   url: "....",
        //   type: "get",
        //   data: { cateNumber: 1 },
        //   success: function (result) {
        //     text = makeMiddleCate(result);
        //   },
        // });

        let obj = [
            { number: 11, name: "사회" },
            { number: 12, name: "자연과학" },
            { number: 13, name: "의약" },
            { number: 14, name: "교육" },
        ];
        text = makeMiddleCate(obj);
    }

    $jobBox.html(text);
});

$(".second-job-box").on("click", ".option", function () {
    let text = "";

    if ($(this).val() == "1") {
        let obj = [{ number: 1, name: "서비스업1" }];
        text = makeSmallCate(obj);
    } else if ($(this).val() == "2") {
        let obj = [{ number: 2, name: "의료/제약1" }];
        text = makeSmallCate(obj);
    } else if ($(this).val() == "3") {
        let obj = [{ number: 3, name: "제조/화학1" }];
        text = makeSmallCate(obj);
    } else if ($(this).val() == "4") {
        let obj = [{ number: 4, name: "판매/유통1" }];
        text = makeSmallCate(obj);
    } else if ($(this).val() == "5") {
        let obj = [{ number: 5, name: "IT/웹/통신1" }];
        text = makeSmallCate(obj);
    } else if ($(this).val() == "11") {
        let obj = [{ number: 11, name: "사회1" }];
        text = makeSmallCate(obj);
    } else if ($(this).val() == "12") {
        let obj = [{ number: 12, name: "자연과학1" }];
        text = makeSmallCate(obj);
    } else if ($(this).val() == "13") {
        let obj = [{ number: 13, name: "의약1" }];
        text = makeSmallCate(obj);
    } else if ($(this).val() == "14") {
        let obj = [{ number: 14, name: "교육1" }];
        text = makeSmallCate(obj);
    }

    $depBox.html(text);
});

// 2, 3차 카테고리 선택 시 항목 띄어주는 함수

function makeMiddleCate(obj) {
    let list = obj;
    let text = "";

    list.forEach((cate) => {
        text += `<li class="option" value="${cate.number}">${cate.name}</li>`;
    });

    return text;
}

function makeSmallCate(obj) {
    let list = obj;
    let text = "";

    list.forEach((cate) => {
        text += `<li class="option2" value="${cate.number}">${cate.name}</li>`;
    });

    return text;
}