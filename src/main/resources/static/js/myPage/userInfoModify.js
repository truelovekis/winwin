// 프로필 사진 미리보기
$('.profile-file').on('change', function(){
    let files = this.files;

    let src = URL.createObjectURL(files[0]);

    $('.img-box').css('background-image', `url(${src})`).css('background-size', 'cover').data('name', `${files[0].name}`);
})

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
    if (existingTags.length >= 3) { return; }

    for(let i=0; i<existingTags.length; i++){
        if(existingTags.eq(i).find('input').val() == val){
            return;
        }
    }

    let tagHtml = `
        <div class="tag">@${text}
            <input type="hidden" value="${val}" name="subNumber">
        </div>
    `;

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
        text += `<li class="option" value="${cate.number}">${cate.name}</li>`;
    });

    return text;
}

