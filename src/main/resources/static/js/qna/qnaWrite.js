$('#count_memo').keyup(function (e){
    var content = $(this).val();
    $('#cnt').html("("+content.length+" / 50)");    //글자수 실시간 카운팅

    if (content.length > 50){
        alert("최대 50자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 50));
        $('#cnt').html("(50 / 50)");
    }
});