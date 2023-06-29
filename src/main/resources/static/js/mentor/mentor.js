$('.name-box').keyup(function (e){
    var content = $(this).val();
    $('.cnt').html(content.length);    //글자수 실시간 카운팅

    if (content.length > 20){
        alert("최대 20자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 20));
        $('.cnt').html("20");
    }
});

$('.title-box').keyup(function (e){
    var content = $(this).val();
    $('.cnt2').html(content.length);    //글자수 실시간 카운팅

    if (content.length > 40){
        alert("최대 40자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 40));
        $('.cnt2').html("40");
    }
});

$('.short-box').keyup(function (e){
    var content = $(this).val();
    $('.cnt3').html(content.length);    //글자수 실시간 카운팅

    if (content.length > 150){
        alert("최대 150자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 150));
        $('.cnt3').html("150");
    }
});

let $fileInput = $('#file');

$fileInput.on('change', function (){
   let src = URL.createObjectURL(this.files[0]);
   $('.photo-in').attr('src', src);
});

let $back = $('.back-button');

$back.on('click', function (){
    window.location.href = '/mentor/apply';
});