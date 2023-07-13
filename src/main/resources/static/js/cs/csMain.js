function fn_read(csNumber){
    location.href = "/cs/read?csNumber="+csNumber;
}

//  글 작성시 날짜

const communityTimeElements = document.getElementsByClassName('community-time');


for (let i = 0; i < communityTimeElements.length; i++) {
    const communityTimeElement = communityTimeElements[i];
    const postCreationTime = new Date(communityTimeElement.dataset.creationTime);
    const currentTime = new Date();
    const timeDifference = currentTime - postCreationTime;

    const seconds = Math.floor(timeDifference / 1000);
    const minutes = Math.floor(seconds / 60);
    const hours = Math.floor(minutes / 60);
    const days = Math.floor(hours / 24);

    let elapsedTime;

    if (days >= 3) {
        elapsedTime = days + '일 전';
    } else if (hours >= 12 || (hours >= 1 && minutes >= 30)) {
        const dayCount = Math.ceil(hours / 24);
        elapsedTime = dayCount + '일 전';
    } else if (hours >= 6) {
        elapsedTime = '12시간 전';
    } else if (hours >= 3) {
        elapsedTime = '6시간 전';
    } else if (hours >= 1 || minutes >= 30) {
        elapsedTime = '3시간 전';
    } else {
        elapsedTime = '1시간 미만';
    }


    const elapsedTimeElement = communityTimeElement.querySelector('.elapsed-time');
    elapsedTimeElement.textContent = elapsedTime;
}




 //  작성 수정 삭제

$('.pfp-main-btn').on('click', function (e) {
    e.preventDefault();

    let userNumber = $('.pfp-main-btn').data('usernumber');
    console.log(userNumber);

    if(userNumber){
        window.location.href = '/cs/write';
    }else {
        $('.login-move').trigger('click');
    }
});

$('.login-btn').on('click', function (e){
    e.preventDefault();

    let userNumber = $('.login-btn').data('usernumber');

    if (userNumber){
        window.location.href = '이동할 주소'
    }else{
        $('.login-move').trigger('click');
    }

});

// 프로필 이름











