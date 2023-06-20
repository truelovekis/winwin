

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



