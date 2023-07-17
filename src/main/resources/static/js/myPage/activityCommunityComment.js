//무한 스크롤 페이징

let page = 1;

getListPage({page: page}, appendList, showError);

$(window).on('scroll', function () {
  if (Math.ceil($(window).scrollTop()) == $(document).height() - $(window).height()) {
    ++page;
    getListPage({page: page}, appendList, showError)
  }
});

function getListPage(pageInfo, appendList, error) {
  $.ajax({
    url: `/myPages/myCommunityComment/${pageInfo.page}`,
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

function getObj(bigCategory){
    let obj = {};

    if (bigCategory == 200){
        obj.url=`/career/detail?careerInfoNumber`;
        obj.text='진로정보';
    }else if(bigCategory == 300){
        obj.url=`/qna/read?qnaNumber`;
        obj.text='QnA';
    }else if(bigCategory == 400){
        obj.url=`/community/read?communityNumber`;
        obj.text='커뮤니티';
    }else if(bigCategory == 500){
        obj.url=`/project/read?studyNumber`;
        obj.text='모임';
    }else if(bigCategory == 600){
        obj.url=`/share/read?shareNumber`;
        obj.text='나눔';
    }else if(bigCategory == 700){
        obj.url=`/cs/read?csNumber`;
        obj.text='문의사항';
    }

    return obj;
}

function appendList(map) {
  let text = '';

  map.activeCommentVoList.forEach(comment => {
      let obj = getObj(comment.bigCategory);

    text += `
                  <a class="reply-box" href="${obj.url}=${comment.boardNumber}">
                    <div class="commentAi">
                      <div class="profil">
                          <img src="../img/corgi-g5894d3ae3_1920.jpg" height="50px" width="50px">
                          <div class="Commento"><p>${comment.boardTitle}</p></div>
<!--                          <div class="dropdown2">-->
<!--                              <button class="dropbtn2"> -->
<!--                                <span class="dropbtn_icon2"> <svg data-v-bd9f2bcc="" data-v-3035bc76="" width="24" height="24" fill="black" xmlns="http://www.w3.org/2000/svg" class="c-Applicatio c-icon" style="fill: rgb(148, 155, 160);"><circle data-v-bd9f2bcc="" cx="12" cy="5.5" r="1.5"></circle><circle data-v-bd9f2bcc="" cx="12" cy="12" r="1.5"></circle><circle data-v-bd9f2bcc="" cx="12" cy="18.5" r="1.5"></circle></svg></span>-->
<!--                              </button>-->
<!--                              <div class="dropdown-content2">-->
<!--                                <a href="#">신고</a>-->
<!--                                <a href="#">수정</a>-->
<!--                                <a href="#">삭제</a>-->
<!--                              </div>-->
<!--                          </div>-->
                      </div>
                      <div class="description"><p>OpenAi</p></div>
<!--                      reply-box 하나가 기준, reply-box 테두리 만들기, description 삭제, 댓글추천 svg 추가, dropdown2 없애기, a태그 color black-->
                      <div class="Aicontent">${comment.commentContent}</div>
                      <div class="parent">
                          <div class="icon2">
                              <div class="date1">${comment.commentDate}</div>
                          </div>
                      </div>
                    </div>
                  </a>
        `;
  });
  $('.activity-content').append(text);
}

function showError(a, b, c) {
  console.log(c);
}