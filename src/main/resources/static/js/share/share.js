let $likeUp = $('.bi-hand-thumbs-up');
let $likeDown = $('.bi-hand-thumbs-up-fill');

let $shareLike = $('.share-like');

$likeUp.on('click', function () {
    $(this).parents('.share-btn').find('.bi-hand-thumbs-up-fill').show();
    $(this).parents('.share-btn').find('.bi-hand-thumbs-up').hide();
});

$likeDown.on('click', function () {
    $(this).parents('.share-btn').find('.bi-hand-thumbs-up-fill').hide();
    $(this).parents('.share-btn').find('.bi-hand-thumbs-up').show();
});

// 작성하기 session없을 때 모달창 띄어주고, 있으면 작성페이지 이동
// 제이쿼리 트리거 -> 이벤트 발생 시켜주는 함수

$('.pfp-main-btn').on('click', function (e) {
    e.preventDefault();

    let userNumber = $('.pfp-main-btn').data('usernumber');
    console.log(userNumber);

    if (userNumber) {
        window.location.href = '/share/write';
    } else {
        alert("로그인이 필요합니다.")
        $('.login-move').trigger('click');
    }
});

//무한 스크롤 페이징

let page = 1;

getListPage({page: page}, appendList, showError);

$(window).on('scroll', function () {
    console.log(Math.round($(window).scrollTop()));
    if (Math.round($(window).scrollTop()) == $(document).height() - $(window).height() - 1) {
        console.log(++page)
        console.log("====================================")
        getListPage({page: page}, appendList, showError)
    }
});

function getListPage(pageInfo, appendList, error) {
    $.ajax({
        url: `/scroll/list/${pageInfo.page}`,
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

    map.shareList.forEach(share => {
        text += `
           <div class="share-main-box"">
            <div class="share-box">
                <div class="share-sub-content">
                    <div class="share-sub-title">
                        <a class="share-title-path" href="/share/read?shareNumber=${share.shareNumber}">
                            <div class="share-title">
                                <span>
                                    ${share.shareStatus == '1' ? '<span class="N">나눔 중</span>'
                                    : '<span class="E">마감</span>'
                                        } 
                                </span>
                                |
                                <span>${share.shareTitle}</span>
                            </div>
                        </a>
                        <div class="share-content">${share.shareContent}</div>
                    </div>
                    <div class="share-sub-box">
                        <div class="share-btn">
                            <div class="share-cnt">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-eye" viewBox="0 0 16 16">
                                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                </svg>
                                <span>${share.shareReadCnt}</span></div>
                        </div>
                        <div class="share-time">${share.shareDate}</div>
                    </div>

                </div>
                <div class="share-sub-img">
                    <div class="share-img">
                        ${share.fileSystemName == null ?
            '<img src="/img/default-camera.png">' :
            '<img src=/upload/' + share.fileUploadPath + '/th_' + share.fileUuid + '_' + share.fileSystemName + '>'
        }
                
                    </div>
                </div>
            </div>
        </div>
        `;

        // text += ``
    });
    $('.community').append(text);
}

function showError(a, b, c) {
    console.error(c);
}

//-----------------------------------------------------------------------------------------