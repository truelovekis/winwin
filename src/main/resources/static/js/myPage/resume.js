$('.addResume').on('click', function(e){
    if($('.resume-box').length > 2){
        e.preventDefault();
        alert("이력서는 최대 3개까지만 등록이 가능합니다.");
    }
});

$('.addPr').on('click', function(e){
    if($('.resume-box').length > 4){
        e.preventDefault();
        alert("자기소개서는 최대 5개까지만 등록이 가능합니다.");
    }
});

