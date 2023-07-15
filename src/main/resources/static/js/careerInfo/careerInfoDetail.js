import * as comment from '../module/careerInfoCommentModule.js';

// 진로정보 댓글 리스트
const boardNumber = $('.careerInfo-num').val();
let page = 1;

console.log(boardNumber)
console.log($('.careerInfo-num'))

comment.getList({careerInfoNumber : boardNumber, page : page} ,appendComment, showError);

// 무한 스크롤 페이징
$(window).on('scroll', function (){
    console.log($(window).scrollTop());
    console.log(`document : ${$(window).height()}`);
    console.log(`document : ${$(window).scrollTop()}`);

    if (Math.ceil($(window).scrollTop()) == $(document).height() - $(window).height()){
        console.log(++page);
        console.log("==========================================")
        comment.getList({careerInfoNumber : boardNumber, page : page} ,appendComment, showError);
    }
});

function appendComment(map) {
    let text = '';


    map.careerInfoCommentList.forEach(c => {
        text += `
             <div class="reply-cardbox" data-index="0" style="" data-num="${c.commentNumber}">
                <div class="reply-content1">
                    <div class="profile-wrap">
                        <div class="profile-icon-wrap">
                            <img class="profile-icon-img" src="../../static/img/careerpathdetail.png">
                        </div>
                        <div class="profile-text-wrap">
                            <div><span class="profile-text-id">${c.userNickname}</span></div>
                            <div><span class="profile-text-date">${comment.timeForToday(c.commentDate)}</span></div>
                        </div>
                        <div class="reply-time">
                            <span class="time-text"></span>
                        </div>
                    </div>
                </div>
                <br>
                <div class="reply-content2">
                    <div class="reply-content">
                <span class="reply-text">${c.commentContent}</span>
                    </div>
                </div>
                <div class="reply-content3">
                `;
        if (c.userNumber == loginNumber) {
            text += `
                    <div class="btn-wrap">
                        <div class="btn-sub-wrap">
                            <div class="modify-btn">수정</div>
                            <div class="remove-btn">삭제</div>
                        </div>
                    </div>`
        }

        text += `
                </div>
            </div>`;
    });

    $('.reply').append(text);
}

function showComment(result) {
    let text = '';

    result.careerInfoCommentList.forEach(c => {
        text += `
             <div class="reply-cardbox" data-index="0" style="" data-num="${c.commentNumber}">
                <div class="reply-content1">
                    <div class="profile-wrap">
                        <div class="profile-icon-wrap">
                            <img class="profile-icon-img" src="../../static/img/careerpathdetail.png">
                        </div>
                        <div class="profile-text-wrap">
                            <div><span class="profile-text-id">${c.userNickname}</span></div>
                            <div><span class="profile-text-date">${comment.timeForToday(c.commentDate)}</span></div>
                        </div>
                        <div class="reply-time">
                            <span class="time-text"></span>
                        </div>
                    </div>
                </div>
                <br>
                <div class="reply-content2">
                    <div class="reply-content">
                <span class="reply-text">${c.commentContent}</span>
                    </div>
                </div>
                <div class="reply-content3">
                `;
        if (c.userNumber == loginNumber) {
            text += `
                    <div class="btn-wrap">
                        <div class="btn-sub-wrap">
                            <div class="modify-btn">수정</div>
                            <div class="remove-btn">삭제</div>
                        </div>
                    </div>`
        }

        text += `
                </div>
            </div>`;
    });

    $('.reply').html(text);
}

function showError(a, b, c) {
    // console.error(c);
}

// 진로정보 댓글 작성하기
$('.submit-btn').on('click', function () {
    let content = $('#content').val();
    let boardNumber = $('.careerInfo-num').val();
    comment.register({commentContent: content, careerInfoNumber: boardNumber});

    $('#content').val('');

    page = 1;
    let obj = {
        careerInfoNumber : boardNumber,
        page : page
    }

    comment.getList(obj, showComment, showError);
});

// 진로정보 댓글 삭제하기
$('.reply').on('click', '.remove-btn', function () {

    let commnetNumber = $(this).closest('.reply-cardbox').data('num');

    page = 1;
    let obj = {
        careerInfoNumber : boardNumber,
        page : page
    }

    comment.remove(commnetNumber, function (){
        comment.getList(obj, showComment, showError)
    }, showError)



});

// 진로정보 댓글 수정하기
$('.reply').on('click', '.modify-btn', function () {
    let content = $(this).closest('.reply-cardbox').find('.reply-text');
    let num = $(this).closest('.reply').find('.reply-cardbox').data('num');
    let content1 = $(this).closest('.reply-cardbox').find('.reply-text').text();
    console.log(num);
    console.log(content);
    content.replaceWith(`
    <div class='modify-box'>
    <textarea class='modify-content'>${content1}</textarea>
    <button type='button' class='modify-content-btn'>수정 완료</button>
    </div>
    `);
    // $('comment-btn__box').addClass('.none');
});

// 진로정보 댓글 수정 완료처리
$('.reply').on('click', '.modify-content-btn', function (){
    console.log('modify!!!!')
    let commentNumber = $(this).closest('.reply-cardbox').data('num');
    let commentContent = $(this).closest('.reply').find('.modify-content').val();
    // let comment = $(this).closest('.reply');
    console.log("=================================")
    console.log(commentNumber);
    console.log(commentContent);
    console.log("=================================")

    let commnetObj = {
        commentNumber : commentNumber,
        commentContent : commentContent
    }
    page = 1;
    let obj = {
        careerInfoNumber : boardNumber,
        page : page
    }

    comment.modify(commnetObj, function (){
        comment.getList(obj, showComment, showError)
    } , showError)
});

//====================================================================

$(".like-btn").on("click", function () {
    $(this).find(".bi-heart").toggleClass("none");
    $(this).find(".bi-heart-fill").toggleClass("none");

    $(".hate-btn").find(".bi-heart").removeClass("none");
    $('.hate-btn').find(".bi-heart-fill").addClass("none");
});

$(".hate-btn").on("click", function () {
    $(this).find(".bi-heart").toggleClass("none");
    $(this).find(".bi-heart-fill").toggleClass("none");

    $(".like-btn").find(".bi-heart").removeClass("none");
    $(".like-btn").find(".bi-heart-fill").addClass("none");
});

