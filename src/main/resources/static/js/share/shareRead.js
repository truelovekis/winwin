// const dislikeBtn = document.querySelector('.bi-hand-thumbs-up');
// const likeBtn = document.querySelector('.bi-hand-thumbs-up-fill');

// // 누를 시 꽉 찬 추천으로 변경
// dislikeBtn.onclick = function () {
// dislikeBtn.classList.add('hide');
// likeBtn.classList.remove('hide');
// }

// // 다시 누르면 빈 추천으로 돌아옴
// likeBtn.onclick = function(){
//     likeBtn.classList.add('hide');
//     dislikeBtn.classList.remove('hide');
// }

let $likeUp = $('.bi-hand-thumbs-up');
let $likeDown = $('.bi-hand-thumbs-up-fill');

$likeUp.on('click', function(){
    $(this).parents('.like-btn').find('.bi-hand-thumbs-up-fill').show();
    $(this).parents('.like-btn').find('.bi-hand-thumbs-up').hide();
});

$likeDown.on('click', function(){
    $(this).parents('.like-btn').find('.bi-hand-thumbs-up-fill').hide();
    $(this).parents('.like-btn').find('.bi-hand-thumbs-up').show();
});


let $empty = $('.bi-hand-thumbs-up');
let $full = $('.bi-hand-thumbs-up-fill');

$empty.on('click', function(){
    $(this).parents('.good').find('.bi-hand-thumbs-up-fill').show();
    $(this).parents('.good').find('.bi-hand-thumbs-up').hide();
});

$full.on('click', function(){
    $(this).parents('.good').find('.bi-hand-thumbs-up-fill').hide();
    $(this).parents('.good').find('.bi-hand-thumbs-up').show();
});



let $dislikeBtn = $('.bi-hand-thumbs-down');
let $fulllikeBtn = $('.bi-hand-thumbs-down-fill');

$dislikeBtn.on('click', function(){
    $(this).parents('.bad').find('.bi-hand-thumbs-down-fill').show();
    $(this).parents('.bad').find('.bi-hand-thumbs-down').hide();
});

$fulllikeBtn.on('click', function(){
    $(this).parents('.bad').find('.bi-hand-thumbs-down-fill').hide();
    $(this).parents('.bad').find('.bi-hand-thumbs-down').show();
});

// 상세보기 페이지 진입시 이미지 띄어주기
displayAjax();

function displayAjax(){
    let shareNumber = $('.share-num').val();
    // console.log(shareNumber);

    $.ajax({
        url : '/sharefiles/imgList',
        type : 'get',
        data : {shareNumber : shareNumber},
        success : function (files){
            let text = '';

            files.forEach(file => {
                let fileName = file.fileUploadPath + '/' + file.fileUuid + '_' + file.fileSystemName;
                text += `<img src="/sharefiles/display?fileSystemName=${fileName}" data-number="${file.fileNumber}" data-name="${fileName}" width="200px" height="200px">`;
            });
            // console.log(shareNumber)
            // console.log(files);
            $('.img-box').html(text);
        }
    });
}

// 수정 페이지 이동

function fn_modify(shareNumber){
    if(confirm("정말 수정하시겠습니까?")){
        location.href = "/share/modify?shareNumber="+shareNumber;
    }
}

// 삭제하기 페이지 이동
function fn_remove(shareNumber) {
    if (confirm("정말 삭제하시겠습니까?")) {
        location.href = "/share/remove?shareNumber=" + shareNumber;
    }
}

// 신고하기 페이지 이동
let reportModal = document.querySelector(".reportModal");
let reportBtn = document.querySelector(".police-btn");

reportBtn.addEventListener("click", function (){
    reportModal.style.display = "flex";
    document.body.style.overflow = "hidden";
});

reportModal.addEventListener("click", function (e){
    if ($(e.target).hasClass("reportModal")){
        reportModal.style.display = "none";
        document.body.style.overflow = "unset";
    }
});

// 신고하기 버튼 클릭 시 컨펌 및 신고처리
let $reportButton = $('.report-btn');
$reportButton.on("click", function (){
    console.log($('.report-list input:checked').val());

    let result = confirm("정말 신고하시겠습니까?");


   if(result){
       reportAjax();
   }
});

// 신고하기 처리
function reportAjax(){
    let shareNumber = $('.share-num').val();
    let policeCategory = $('.report-list input:checked').val();

    $.ajax({
        url:'/police/share',
        type: 'post',
        data: JSON.stringify({boardNumber: shareNumber, policeCategory:policeCategory}),
        contentType : 'application/json; charset=utf-8',
        success : function (){
            alert("정상적으로 신고처리 되었습니다.")
            location.href = "/share/list";
        }

    })
}









