$('#communityContent').on('keyup', function(e) {
    let $content = $(this).val();
    $('.cnt').html(""+$content.length+"");

    if($content.length > 500){
        alert("최대 500자까지 입력 가능합니다.");
        $(this).val($content.substring(0,500));
        $('.text-cnt').html("글자수 : 500/500");
    }
});