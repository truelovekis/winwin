function fn_read(csNumber){
    location.href = "/cs/read?csNumber="+csNumber;
}

//  글 작성시 날짜

// function timeForToday(value){
//     // new Date() 현재 날짜와 시간
//     const today = new Date();
//     const timeValue = new Date(value);
//
//     console.log(today);
//     console.log(timeValue);
//
//     // Math.floor()는 소수점을 내림 처리 해준다.
//     // getTime()은 1970년 01/01 을 기준으로 지금까지 몇 ms가 지났는지 알려준다.
//     const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
//
//     console.log(betweenTime);
//
//     if(betweenTime < 1) { return "방금 전"; }
//     if(betweenTime < 60) {
//         return `${betweenTime}분 전`;
//     }
//
//     const betweenTimeHour = Math.floor(betweenTime / 60);
//     if(betweenTimeHour < 24){
//         return `${betweenTimeHour}시간 전`;
//     }
//
//     const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
//     if(betweenTimeDay < 365){
//         return `${betweenTimeDay}일 전`;
//     }
//
//     return `${Math.floor(betweenTimeDay / 365)}년 전`;
// }

function updateTime() {
    const timeValueElements = document.getElementsByClassName("elapsed-time");
    const currentTime = new Date();

    for (let i = 0; i < timeValueElements.length; i++) {
        const timeValue = new Date(timeValueElements[i].textContent);
        const formattedTime = timeForToday(timeValue, currentTime);
        timeValueElements[i].textContent = formattedTime;
    }
}

// 1분마다 updateTime 함수를 호출하여 시간 업데이트
setInterval(updateTime, 60000); // 60000ms = 1분




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

// 무한스크롤

//===============
//무한 스크롤 페이징
//===============

let page = 1;
getListPage({page: page}, appendList, showError);

$(window).on('scroll', function () {
    console.log(Math.round($(window).scrollTop()));
    if (Math.ceil($(window).scrollTop()) == $(document).height() - $(window).height()) {Math.floor($(window).scrollTop()) == $(document).height() - $(window).height() || Math.ceil($(window).scrollTop()) == $(document).height() - $(window).height()
        console.log(++page)
        console.log("====================================")
        getListPage({page: page}, appendList, showError)
    }
});

function getListPage(pageInfo, appendList, error) {
    $.ajax({
        url: `/csScroll/list/${pageInfo.page}`,
        type: 'get',
        dataType: 'json',
        success: function (result) {
            if (appendList) {
                appendList(result);
            }
        },
        error: error

    });
}

function appendList(map) {
    let text = '';

    map.csVoList.forEach(csVo => {
        text += `
        <!-- 게시글 리스트 -->
        <!-- 시작! -->
        <div class="community-main-box">
            <div class="community-box">
                <div class="community-sub-content" onclick="fn_read(${csVo.csNumber});">
                    <div class="community-title">${csVo.csTitle}</div>
                    <div class="community-content">${csVo.csContent}</div>
                </div>
                <div class="community-sub-box">
                    <div class="community-btn">
                        <div class="community-cnt">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-eye" viewBox="0 0 16 16">
                                <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                            </svg>
                            <span>${csVo.csReadCnt}</span>
                        </div>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-chat-dots" viewBox="0 0 16 16">
                            <path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                            <path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z"/>
                        </svg>
                        <span>${csVo.commentCnt}</span>
                    </div>
                    <div class="community-time"><span class="elapsed-time"></span></div>
                </div>
            </div>
        </div>`;
        <!-- 끝! -->
    });

    $('.community-list').append(text);
}

function showError(a, b, c) {
    // console.error(c);
}