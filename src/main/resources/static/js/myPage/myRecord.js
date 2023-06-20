// 다이어리 작성하기
let $plus = $('.plusBtn');
let $Diary = $('.diary');
let $cancleBtn = $('.cancle');

$plus.on('click', function(){
    $Diary.eq(0).show();
});

$cancleBtn.on('click', function(){
    $Diary.eq(0).hide();
});

// 작성 완료 버튼
let $submitBtn = $('.submit');
let $form = $('.diary-form');

$submitBtn.on('click', function(){
    $form.submit();
    $Diary.eq(0).hide();
});


// 이미 기록한 다이어리 보기
let $closeBtn = $('.closeBtn');
let $diaryContent = $('.diary-content');
let $diaryTitle = $('.diary-title');

$diaryTitle.on('click', function(){
    $(this).next('.my-diary').find('.diary-content').show();
    $(this).parents('.diary-main').find('.diary-title').hide();
});

$closeBtn.on('click', function(){
    $(this).closest('.diary-content').hide();
    $(this).parents('.diary-main').find('.diary-title').show();
});


// 수정 버튼
let $editBtn = $('.editBtn');
let $Content = $('.list-content');

$editBtn.on('click', function(){
    $(this).closest('.diary-content').hide();
    $(this).parents('.my-diary').find('.diary2').show();
});

// 수정 완료 버튼
let $editSubmit = $('.edit-submit');
let $form2 = $('.diary-form2');

$editSubmit.on('click', function(){
    $form2.submit();
    $(this).parents('.my-diary').find('.diary2').hide();
    $(this).parents('.my-diary').find('.diary-content').show();
});


// 취소 버튼
let $editCancle = $('.edit-cancle');

$editCancle.on('click', function(){
    $(this).parents('.my-diary').find('.diary-content').show();
    $(this).parents('.my-diary').find('.diary2').hide();
});


$('.btn-fullscreen').remove();
$('.btn-codeview').remove();


// $('.note-form-label').text('파일 첨부하기');
// $('.note-image-url').text('링크 첨부하기');