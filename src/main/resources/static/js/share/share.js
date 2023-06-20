let $likeUp = $('.bi-hand-thumbs-up');
let $likeDown = $('.bi-hand-thumbs-up-fill');

let $shareLike = $('.share-like');

$likeUp.on('click', function(){
  $(this).parents('.share-btn').find('.bi-hand-thumbs-up-fill').show();
  $(this).parents('.share-btn').find('.bi-hand-thumbs-up').hide();
});

$likeDown.on('click', function(){
  $(this).parents('.share-btn').find('.bi-hand-thumbs-up-fill').hide();
  $(this).parents('.share-btn').find('.bi-hand-thumbs-up').show();
});