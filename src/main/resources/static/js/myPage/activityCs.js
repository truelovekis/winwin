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
        url: `/myPages/myCs/${pageInfo.page}`,
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

    map.activeBoardVoList.forEach(board => {
        text += `
          <a class="cs-click" href="/cs/read?csNumber=${board.boardNumber}">
          <div class="cs-container">
            <div class="cs-box">
              <div class="cs-title-box">
                <span class="cs-title">${board.boardTitle}</span>
              </div>
              <span class="cs-content">${board.boardContent}</span>
              <div class="cs-bottom">
                <div class="cs-icon">
                </div>
                <span class="cs-date">${board.boardDate}</span>
              </div>
            </div>
          </div>
        </a>
        `;
    });
    $('.my-mentor-content').append(text);
}

function showError(a, b, c) {
    console.log(c);
}