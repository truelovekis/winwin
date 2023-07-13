// 코드 정리 필요함...

// getListByTag();

// 태그 필터
const selectBoxElements3 = document.querySelectorAll(".select");

function toggleSelectBox(selectBox) {
    selectBox.classList.toggle("active");
}

function selectOption(optionElement) {
    const selectBox = optionElement.closest(".select");
    const selectedElement = selectBox.querySelector(".selected-value");
    selectedElement.textContent = optionElement.textContent;
}

selectBoxElements3.forEach((selectBoxElement) => {
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

});

$(".middle-option-box").on("click", ".middle-option", function () {
    let text = $(this).text();

    let tagHtml = `<span class="tag">@${text}</span>`;

    $(".select-tag").append(tagHtml);
});

$(".select-tag").on("click", ".tag", function () {
    $(this).detach();
    $('.main2').html('');
    page = 1;
    getListByTag();
});

// 나의 관심분야 3가지 카테고리 박스

let $boxes2 = $('.select');

//클릭하면 리스트 div 보기,닫기

$boxes2.on('click', function () {
    if ($(this).closest('.select').find('.option-box').hasClass('none')) {
        $('.option-box').addClass('none');
        $(this).closest('.select').find('.option-box').toggleClass('none');
    } else {
        $('.option-box').addClass('none');
    }
});

//고른 항목 텍스트 상위로 복사

$('.select').on('click', '.option', function () {
    $(this).closest('.select').find('.selected-value').text($(this).text());
});

//다른 곳 클릭 시 리스트 div 닫기

$("body").on('click', function (e) {
    if (!$(e.target).closest('.select').hasClass('select')) {
        $boxes2.each((i, box) => {
            $(box).find('.option-box').addClass('none');
        });
    }
});

//3차 카테고리 선택 시 태그 추가(최대 3개)

$(".third-job-box").on("click", ".option", function () {
    let text = $(this).text();
    let val = $(this).val();

    let existingTags = $(".select-tag .tag");
    if (existingTags.length >= 10) {
        return;
    }

    for (let i = 0; i < existingTags.length; i++) {
        if (existingTags.eq(i).text() == '@' + text) {
            return;
        }
    }

//  ajax SUB_CATEGORY 배열에 저장해서 리스트 뿌려주기

    let tagHtml = `<div class="tag" data-value="${val}">@${text}</div>`;
    $(".select-tag").append(tagHtml);

    let list = [];

    $('.tag').each((i, obj) => {
        let tmp = $(obj).data('value');
        list.push(tmp);
    });

    console.log(list)

    $.ajax({
        type: 'get',
        url: '/careerInfo/list/1',
        data: {tagList: list},
        dataType: 'json',
        traditional: true,
        success: function (result) {
            console.log(result)
            $('.main2').html('');
            page = 1;
            showInfo(result.careerInfoList); //+++++++++++++++++++++++++++++++++++++++++++++++++==
        },
        error: function (a, b, c) {
            console.error(c);
        }

    });
});

function getListByTag() {
    let list = [];

    $('.tag').each((i, obj) => {
        let tmp = $(obj).data('value');
        list.push(tmp);
    });

    console.log(list)

    $.ajax({
        type: 'get',
        url: `/careerInfo/list/1`, //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        data: {tagList: list},
        dataType: 'json',
        traditional: true,
        success: function (result) {
            // console.log(result)
            showInfo(result.careerInfoList);
        },
        error: function (a, b, c) {
            console.error(c);
        }

    });
}

//--------------------------------------------------------------------------

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
    if ($(this).val() == "1") {
        $.ajax({
            url: "/category/categoryJ",
            type: "get",
            data: {mainCode: ss},
            dataType: 'json',
            success: function (result) {
                makeMiddleCate(result);
            },
        });
    }
    if ($(this).val() == "2") {
        $.ajax({
            url: "/category/categoryH",
            type: "get",
            data: {mainCode: ss},
            dataType: 'json',
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
        url: '/category/subCategory',
        type: 'get',
        data: {mainCode: ss},
        dataType: 'json',
        success: function (result) {
            let text2 = '';
            result.forEach(r => {
                text2 += `
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

//---------------------------------------------------------------------------------------

// ajax SUB_CATEGORY 배열에 저장해서 리스트 뿌려주기 및 무한 스크롤

function showInfo(careerInfoList) {
    console.log('==========================================')
    console.log(careerInfoList);
    console.log('==========================================')
    if (careerInfoList.length == 0) {
        // $('.main2').html('');
        return;
    }
    // console.log('in!!')
    let text = ``;
    let flag = 0;

    careerInfoList.forEach(career => {
        if (flag % 3 == 0) {
            text += `<section class="card-wrap">`;
        }
        console.log(career);
        text += `
        <div class="card-box">
                <div class="inner-card-box">
                    <div class="title">
                        <a class="careerInfo-title-path" href="/career/detail?careerInfoNumber=${career.careerInfoNumber}">
                            <h1 class="card-box-title">${career.careerInfoTitle}</h1>
                        </a>
                    </div>
                    <div class="msg">
                        ${career.careerInfoContent}
                    </div>
                    <div class="profile-like-wrap">
                        <div class="profile">
                            <div class="pf">
                                ${career.pfpSystemname == null ?
            '<img src="/img/default-camera.png" width="50px" height="50px" border-radius="70%">' :
            '<img src="/profile/' + career.pfpUploadPath + career.pfpUuid + '_' + career.pfpSystemname + '>'
        }
                            </div>
                            <div class="text-box">
                                <span class="user-name">${career.userNickname}</span>
                                <br/>
                                <span class="user-bottom">${career.subName},${career.gradeName}</span>
                            </div>

                            <div class="content">
                                <div class="sec1">
                                    <div>
                                        <svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)"
                                             fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24"
                                             width="24">
                                            <path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path>
                                        </svg>
                                    </div>
                                    <div class="number1">${career.careerInfoLike}</div>
                                </div>
                                <div class="sec2">
                                    <div>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                             fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                            <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                            <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                        </svg>
                                    </div>
                                    <div class="number2">${career.careerInfoCnt}</div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        `;

        flag++;

        if (flag % 3 == 0) {
            text += `</section>`;
        }
    });

    if (flag % 3 != 0) {
        text += `</section>`;
    }
    $('.main2').append(text);
}

// 진로정보 무한 스크롤
let page = 1;

getCareerListPage({page: page}, careerShowError);

$(window).on('scroll', function () {
    console.log(Math.round($(window).scrollTop()));
    if (Math.round($(window).scrollTop()) == $(document).height() - $(window).height()) {
        console.log(++page)
        console.log("====================================")
        getCareerListPage({page: page}, careerShowError)
    }
});

function getCareerListPage(pageInfo, error) {
    let list = [];

    $('.tag').each((i, obj) => {
        let tmp = $(obj).data('value');
        list.push(tmp);
    });

    $.ajax({
        url: `/careerInfo/list/${pageInfo.page}`,
        type: 'get',
        data: {tagList: list},
        traditional: true,
        dataType: 'json',
        success: function (result) {
            showInfo(result.careerInfoList); //++++++++++++++++++++++++++++++++++++
        },
        error: error
    });
}

function careerShowError(a, b, c) {
    console.log(c);
}

// 진로정보 글 작성하기 페이지 이동
$('.write-btn').on('click', function () {
    location.href = "/career/write";
});


