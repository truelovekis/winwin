//회원탈퇴 확인창
$('.no-point-page').on('click', function(e){
    if(confirm("정말 탈퇴하시겠습니까?")){
        if(!confirm("정말요?")){
            e.preventDefault();
        }
    }else{
        e.preventDefault();
    }
})