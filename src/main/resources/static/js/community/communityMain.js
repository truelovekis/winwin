//=================
// 프로필 이미지 변경
//=================
let $fileInput = $('#file');

$fileInput.on('change', function(){
    let src = URL.createObjectURL(this.files[0]);
    $('.userpfp').attr('src', src);
});

function fn_read(communityNumber){
    location.href = "/community/read?communityNumber="+communityNumber;
}


//=================
// 모달창 구현 영역
//=================
$(function () {
    $(".pfp-main-btn").click(function () {
        $(".modal-container").fadeIn();
    });
});

// 모달창이 나타났을 때 스크롤 제거
$(".pfp-main-btn").on("click", function () {
    $(".modal-container").removeClass("none");
    $('body').css('overflow', 'hidden');
});

// 검은 화면 누르면 모달창 제거
$(".modal-container").on("click", function (e) {
    if ($(e.target).hasClass("modal-container")) {
        $(".modal-container").addClass("none");
        $('body').css('overflow', 'auto');
        modalSetUp2();
    }
});

function modalSetUp2(){
    $('.modal-wrap>div').addClass('none');
    $('.modal-wrap>button').addClass('none');
    $('.modal-wrap>div').removeClass('disappear');
    $('.login-box').removeClass('none');
    $('.login-end').removeClass('none');
    $('.login-box').removeClass('disappear');
    $current = $('.login-box');
    $next = null;
    $('.form-reset')[0].reset();
}


// 병구가 확인한 질문하기 모달창 처리
// $('.pfp-main-btn').on('click', function (e) {
//     e.preventDefault();
//
//     let userNumber = $('.pfp-main-btn').data('usernumber');
//     console.log(userNumber);
//
//     if(userNumber){
//         window.location.href = '/share/write';
//     }else {
//         $('.login-move').trigger('click');
//     }
// });


//===============
//무한 스크롤 페이징
//===============

let page = 1;
//
getListPage({page: page}, appendList, showError);

$(window).on('scroll', function () {
    console.log(Math.round($(window).scrollTop()));
    if (Math.ceil($(window).scrollTop()) == $(document).height() - $(window).height()) {
        console.log(++page)
        console.log("====================================")
        getListPage({page: page}, appendList, showError)
    }
});

function getListPage(pageInfo, appendList, error) {
    let categoryTypeStr = $("#categoryTypeStr").val();
    $.ajax({
        url: `/communityScroll/list/${categoryTypeStr}/${pageInfo.page}`,
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

    map.communityList.forEach(communityVoList => {
        text += `
      <!-- 게시글 리스트 -->
      <!-- 시작! -->
      <div class="community-main-box" onclick="fn_read(${communityVoList.communityNumber});">
        <div class="community-box">
          <div class="community-sub-content">
            <div class="user-identity hsc">${communityVoList.categoryName}</div>
            <div class="community-title">${communityVoList.communityTitle}</div>
            <div class="community-content">
              ${communityVoList.communityContent}
            </div>
          </div>
          <div class="community-sub-box">
            <div class="community-btn">
              <div class="community-cnt">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" style="fill:rgb(148, 155, 160);" class="bi bi-eye" viewBox="0 0 16 16">
                  <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                  <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                </svg>
                <span>${communityVoList.communityCnt}</span>
              </div>
              <div class="community-like">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" style="fill:rgb(148, 155, 160);" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
                  <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" style="fill:rgb(148, 155, 160);" class="bi bi-hand-thumbs-up-fill hide" viewBox="0 0 16 16" >
                  <path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a9.84 9.84 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733.058.119.103.242.138.363.077.27.113.567.113.856 0 .289-.036.586-.113.856-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.163 3.163 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.82 4.82 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
                </svg>
                <span>${communityVoList.likeCnt}</span>
              </div>
              <div class="community-comment">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" style="fill:rgb(148, 155, 160);" class="bi bi-chat-dots" viewBox="0 0 16 16">
                  <path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                  <path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z"/>
                </svg>
                <span>${communityVoList.commentCnt}</span>
              </div>
            </div>
            <div class="community-time">${communityVoList.communityDate}</div>
          </div>
        </div>
      </div>
      <!-- 끝! -->
      <input type="hidden" class="community-number" value="${communityVoList.communityNumber}">`;
        <!-- 리스트 끝! -->
    });
    $('.community-list').append(text);
}

function showError(a, b, c) {
    // console.error(c);
}
