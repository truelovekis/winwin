let modalWrap = $(".modal-wrap");

function fn_modal(){
    modalWrap.css("display","flex");
    $("body").css("overflow","hidden"); //모달창 스크롤 막기
}
function fn_modal_close(target, e){
    if($(e.target).hasClass("modal-wrap")) {
        modalWrap.css("display", "none");
        $("body").css("overflow", "unset"); //모달창 스크롤 막기
    }
}


//무한스크롤 영역
let count = 3;
window.onscroll = function() {
    if((window.innerHeight + window.scrollY) >= document.body.offsetHeight){
        // // // div 코드가 1개 생성됨 = 내가 작성하고자하는 영역을 대입하면됨.
        // let toAdd = document.createElement("div");
        // toAdd.classList.add("box")
        // toAdd.textContent = `${++count}번째 블록`
        // document.querySelector('section').appendChild(toAdd);

    }
}


// 네비 영역 마우스오버 시 텍스트 강조
$('.nav-span1').on('mouseover', function(){
    $('.nav-span1').css("color","rgb(37, 99, 235)")
    $('.nav-span1').css("font-weight","600")
});

$('.nav-span1').on('mouseout', function(){
    $('.nav-span1').css("color","rgb(100, 116, 139)")
    $('.nav-span1').css("font-weight","500")
});

$('.nav-span2').on('mouseover', function(){
    $('.nav-span2').css("color","rgb(37, 99, 235)")
    $('.nav-span2').css("font-weight","600")
});

$('.nav-span2').on('mouseout', function(){
    $('.nav-span2').css("color","rgb(100, 116, 139)")
    $('.nav-span2').css("font-weight","500")
});

$('.nav-span3').on('mouseover', function(){
    $('.nav-span3').css("color","rgb(37, 99, 235)")
    $('.nav-span3').css("font-weight","600")
});

$('.nav-span3').on('mouseout', function(){
    $('.nav-span3').css("color","rgb(100, 116, 139)")
    $('.nav-span3').css("font-weight","500")
});


// 카드박스 백그라운드 마우스오버 처리
$('.project-cardbox').on('mouseover', function(){
    $(this).css("background-color","rgba(241, 245, 249, 0.4)")
});

$('.project-cardbox').on('mouseout', function(){
    $('.project-cardbox').css("background-color","")
});


// 하트 마우스오버 처리
$('.heart').on('mouseover', function(){
    $(this).css("fill","black")
});

$('.heart').on('mouseout', function(){
    $('.heart').css("fill","rgb(203, 213, 225)")
});
