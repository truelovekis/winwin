/* 건드리지 마시오 */
$("#star").click(function () {
    var animation_end = "webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend";
    $(".star-svg").toggleClass("favourite");
    $(".spark")
        .toggleClass("explode")
        .one(animation_end, function () {
            $(".spark").removeClass("explode");
        });
    $(".svg-star")
        .toggleClass("pop")
        .one(animation_end, function () {
            $(".svg-star").removeClass("pop");
        });
});
/* 건드리지 마시오 */

$(".changeView").html(makePro());

$(".pro").on("click", function () {
    $(".changeView").html(makePro());
    $(".li-bottom").css("width", "0");
    $(this).find(".li-bottom").css("width", "100%");
    $(".li-btn").css("color", "#cbd5e1");
    $(this).find("button").css("color", "black");
});

$(".career").on("click", function () {
    $(".changeView").html(makeReview());
    $(".li-bottom").css("width", "0");
    $(this).find(".li-bottom").css("width", "100%");
    $(".li-btn").css("color", "#cbd5e1");
    $(this).find("button").css("color", "black");
});

$(".board").on("click", function () {
    $(".changeView").html(makeInfo());
    $(".li-bottom").css("width", "0");
    $(this).find(".li-bottom").css("width", "100%");
    $(".li-btn").css("color", "#cbd5e1");
    $(this).find("button").css("color", "black");
});

function makePro() {
    return `
  <div class="grid-flex">
  <div class="col-start">
    <div class="page-flex">
      <div class="skill-page" aria-label="스킬">
        <div class="skill-flex">
          <p class="font-bold">스킬</p>
        </div>
        <div class="board-flex">
          <div class="boarder">
            <h3 class="reader">리더십</h3>
          </div>

          <div class="boarder">
            <h3 class="reader">커뮤니케이션</h3>
          </div>
          <div class="boarder">
            <h3 class="reader">서비스 기획</h3>
          </div>
          <div class="boarder">
            <h3 class="reader">애자일 프로세스</h3>
          </div>
          <div class="boarder">
            <h3 class="reader">그래픽 디자인</h3>
          </div>
          <div class="boarder">
            <h3 class="reader">프로토 타이핑</h3>
          </div>
          <div class="boarder">
            <h3 class="reader">프로젝트 매니징</h3>
          </div>
        </div>
      </div>
      <hr color="#CBD5E1" />
      <div class="Career-page" aria-label="경력">
        <div class="Carrer-page">
          <p class="font-bold">경력 ・ 12년차</p>
        </div>
        <div class="BT-form">
          <div class="CR-flex">
            <div class="Career-img">
              <span>
                <img src="./img/./kakao.webp" alt="" style="width: 24px" />
              </span>
            </div>
            <div class="kakao-flex">
              <a href="" target="_blank" rel="noreferrer">
                <span style="color: black">
                  <span class="font-bold" style="color: black">카카오</span>
                  플랫폼 기획
                </span>
              </a>
              <p class="font-base">2019.08 ~ 현재</p>
            </div>
          </div>
          <div class="CR-flex">
            <div class="Career-img">
              <svg
                width="24"
                height="24"
                stroke-width="0"
                viewBox="0 0 24 24"
                fill="current"
                xmlns="http://www.w3.org/2000/svg"
                class="tw-flex-none tw-fill-color-slate-300"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M7 6V7H5C3.89543 7 3 7.89543 3 9V18C3 19.1046 3.89543 20 5 20H19C20.1046 20 21 19.1046 21 18V9C21 7.89543 20.1046 7 19 7H17V6C17 4.89543 16.1046 4 15 4H9C7.89543 4 7 4.89543 7 6ZM15 6H9V7H15V6ZM19 9V12H15C15 10.8954 14.1046 10 13 10H11C9.89543 10 9 10.8954 9 12H5V9H19ZM9 14H5V18H19V14H15V15C15 16.1046 14.1046 17 13 17H11C9.89543 17 9 16.1046 9 15V14ZM13 12H11V15H13V12Z"
                  fill="inherit"
                ></path>
              </svg>
            </div>
            <div class="kakao-flex">
              <a href="" target="_blank" rel="noreferrer">
                <span style="color: black">
                  <span class="font-bold" style="color: black">에이팀벤처스</span>
                  프로덕트매니저
                </span>
              </a>
              <p class="font-base">2018.08 ~ 2019.07</p>
            </div>
          </div>
          <div class="CR-flex">
            <div class="Career-img">
              <span>
                <img src="./img/kakaoentertainment.webp" style="width: 24px" />
              </span>
            </div>
            <div class="kakao-flex">
              <a href="" target="_blank" rel="noreferrer">
                <span style="color: black">
                  <span class="font-bold" style="color: black">카카오엔터테인먼트</span>
                  프로덕트매니저
                </span>
              </a>
              <p class="font-base">2016.10 ~ 2018.07</p>
            </div>
          </div>
          <div class="CR-flex">
            <div class="Career-img">
              <svg
                width="24"
                height="24"
                stroke-width="0"
                viewBox="0 0 24 24"
                fill="current"
                xmlns="http://www.w3.org/2000/svg"
                class="tw-flex-none tw-fill-color-slate-300"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M7 6V7H5C3.89543 7 3 7.89543 3 9V18C3 19.1046 3.89543 20 5 20H19C20.1046 20 21 19.1046 21 18V9C21 7.89543 20.1046 7 19 7H17V6C17 4.89543 16.1046 4 15 4H9C7.89543 4 7 4.89543 7 6ZM15 6H9V7H15V6ZM19 9V12H15C15 10.8954 14.1046 10 13 10H11C9.89543 10 9 10.8954 9 12H5V9H19ZM9 14H5V18H19V14H15V15C15 16.1046 14.1046 17 13 17H11C9.89543 17 9 16.1046 9 15V14ZM13 12H11V15H13V12Z"
                  fill="inherit"
                ></path>
              </svg>
            </div>
            <div class="kakao-flex">
              <a href="" target="_blank" rel="noreferrer">
                <span style="color: black">
                  <span class="font-bold" style="color: black">메쉬코리아</span>
                  디자인 팀장
                </span>
              </a>
              <p class="font-base">2015.05 ~ 2016.09</p>
            </div>
          </div>
          <div class="CR-flex">
            <div class="Career-img">
              <span>
                <img src="./img/./kakaoentertainment.webp" alt="" style="width: 24px" />
              </span>
            </div>
            <div class="kakao-flex">
              <a href="" target="_blank" rel="noreferrer">
                <span style="color: black">
                  <span class="font-bold" style="color: black">카카오엔터테인먼트 </span>
                  프로덕트매니저
                </span>
              </a>
              <p class="font-base">2013.03 ~ 2014.10</p>
            </div>
          </div>
          <div class="CR-flex">
            <div class="Career-img">
              <svg
                width="24"
                height="24"
                stroke-width="0"
                viewBox="0 0 24 24"
                fill="current"
                xmlns="http://www.w3.org/2000/svg"
                class="tw-flex-none tw-fill-color-slate-300"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M7 6V7H5C3.89543 7 3 7.89543 3 9V18C3 19.1046 3.89543 20 5 20H19C20.1046 20 21 19.1046 21 18V9C21 7.89543 20.1046 7 19 7H17V6C17 4.89543 16.1046 4 15 4H9C7.89543 4 7 4.89543 7 6ZM15 6H9V7H15V6ZM19 9V12H15C15 10.8954 14.1046 10 13 10H11C9.89543 10 9 10.8954 9 12H5V9H19ZM9 14H5V18H19V14H15V15C15 16.1046 14.1046 17 13 17H11C9.89543 17 9 16.1046 9 15V14ZM13 12H11V15H13V12Z"
                  fill="inherit"
                ></path>
              </svg>
            </div>
            <div class="kakao-flex">
              <a href="" target="_blank" rel="noreferrer">
                <span style="color: black">
                  <span class="font-bold" style="color: black">씀 이퍼블리케이션</span>
                  CEO
                </span>
              </a>
              <p class="font-base">2011.02 ~ 2013.02</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  `;
}

function makeInfo() {
    return `
  <main class="main2"> 
  <!-- 첫번째 줄 시작-->
<section class="card-wrap">
    <!-- 1 -->
  <div class="card-box">
    <div class="inner-card-box">
      <div class="title">
        <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
        <br/>
      </div>
        <div class="msg">
          병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
        </div>
        <div class="profile-like-wrap">
          <div class="profile">
            <div class="pf">
                <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
            </div>
            <div class="info-text-box" >
              <span class="info-user-name">가나다라마</span>
              <br/>
              <span class="user-bottom">간호사 대학병원 · 4년차</span>
              <div class="info-content">
                <div class="sec1">
                  <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                  <div class="number1">0</div>
                </div>
                <div class="sec2">
                  <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                  </svg></div>
                    <div class="number2">0</div>
                  </div>
            </div>
            </div>
          </div>

        </div>
    </div>
  </div>
    <!-- 1 -->
    <div class="card-box">
      <div class="inner-card-box">
        <div class="title">
          <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
          <br/>
        </div>
          <div class="msg">
            병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
          </div>
          <div class="profile-like-wrap">
            <div class="profile">
              <div class="pf">
                  <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
              </div>
              <div class="info-text-box" >
                <span class="info-user-name">가나다라마</span>
                <br/>
                <span class="user-bottom">간호사 대학병원 · 4년차</span>
                <div class="info-content">
                  <div class="sec1">
                    <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                    <div class="number1">0</div>
                  </div>
                  <div class="sec2">
                    <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                      <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                      <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                    </svg></div>
                      <div class="number2">0</div>
                    </div>
              </div>
              </div>
              
            </div>

          </div>
      </div>
    </div>
      <!-- 1 -->
  <div class="card-box">
    <div class="inner-card-box">
      <div class="title">
        <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
        <br/>
      </div>
        <div class="msg">
          병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
        </div>
        <div class="profile-like-wrap">
          <div class="profile">
            <div class="pf">
                <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
            </div>
            <div class="info-text-box" >
              <span class="info-user-name">가나다라마</span>
              <br/>
              <span class="user-bottom">간호사 대학병원 · 4년차</span>
              <div class="info-content">
                <div class="sec1">
                  <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                  <div class="number1">0</div>
                </div>
                <div class="sec2">
                  <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                  </svg></div>
                    <div class="number2">0</div>
                  </div>
            </div>
            </div>
          </div>
      
        </div>
    </div>
  </div>
</section>
      <!-- 두번째 줄 시작-->
  <!-- 첫번째 줄 시작-->
  <section class="card-wrap">
    <!-- 1 -->
  <div class="card-box">
    <div class="inner-card-box">
      <div class="title">
        <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
        <br/>
      </div>
        <div class="msg">
          병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
        </div>
        <div class="profile-like-wrap">
          <div class="profile">
            <div class="pf">
                <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
            </div>
            <div class="info-text-box" >
              <span class="info-user-name">가나다라마</span>
              <br/>
              <span class="user-bottom">간호사 대학병원 · 4년차</span>
              <div class="info-content">
                <div class="sec1">
                  <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                  <div class="number1">0</div>
                </div>
                <div class="sec2">
                  <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                  </svg></div>
                    <div class="number2">0</div>
                  </div>
            </div>
            </div>
          </div>
 
        </div>
    </div>
  </div>
    <!-- 1 -->
    <div class="card-box">
      <div class="inner-card-box">
        <div class="title">
          <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
          <br/>
        </div>
          <div class="msg">
            병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
          </div>
          <div class="profile-like-wrap">
            <div class="profile">
              <div class="pf">
                  <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
              </div>
              <div class="info-text-box" >
                <span class="info-user-name">가나다라마</span>
                <br/>
                <span class="user-bottom">간호사 대학병원 · 4년차</span>
                <div class="info-content">
                  <div class="sec1">
                    <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                    <div class="number1">0</div>
                  </div>
                  <div class="sec2">
                    <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                      <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                      <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                    </svg></div>
                      <div class="number2">0</div>
                    </div>
              </div>
            </div>
 
            </div>
          </div>
      </div>
    </div>
      <!-- 1 -->
  <div class="card-box">
    <div class="inner-card-box">
      <div class="title">
        <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
        <br/>
      </div>
        <div class="msg">
          병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
        </div>
        <div class="profile-like-wrap">
          <div class="profile">
            <div class="pf">
                <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
            </div>
            <div class="info-text-box" >
              <span class="info-user-name">가나다라마</span>
              <br/>
              <span class="user-bottom">간호사 대학병원 · 4년차</span>
              <div class="info-content">
                <div class="sec1">
                  <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                  <div class="number1">0</div>
                </div>
                <div class="sec2">
                  <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                  </svg></div>
                    <div class="number2">0</div>
                  </div>
            </div>
            </div>
          </div>
          
        </div>
    </div>
  </div>
</section>  
      <!-- 세번째 줄 시작-->
  <!-- 첫번째 줄 시작-->
  <section class="card-wrap">
    <!-- 1 -->
  <div class="card-box">
    <div class="inner-card-box">
      <div class="title">
        <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
        <br/>
      </div>
        <div class="msg">
          병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
        </div>
        <div class="profile-like-wrap">
          <div class="profile">
            <div class="pf">
                <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
            </div>
            <div class="info-text-box" >
              <span class="info-user-name">가나다라마</span>
              <br/>
              <span class="user-bottom">간호사 대학병원 · 4년차</span>
              <div class="info-content">
                <div class="sec1">
                  <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                  <div class="number1">0</div>
                </div>
                <div class="sec2">
                  <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                  </svg></div>
                    <div class="number2">0</div>
                  </div>
            </div>
            </div>
          </div>
          
        </div>
    </div>
  </div>
    <!-- 1 -->
    <div class="card-box">
      <div class="inner-card-box">
        <div class="title">
          <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
          <br/>
        </div>
          <div class="msg">
            병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
          </div>
          <div class="profile-like-wrap">
            <div class="profile">
              <div class="pf">
                  <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
              </div>
              <div class="info-text-box" >
                <span class="info-user-name">가나다라마</span>
                <br/>
                <span class="user-bottom">간호사 대학병원 · 4년차</span>
                <div class="info-content">
                  <div class="sec1">
                    <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                    <div class="number1">0</div>
                  </div>
                  <div class="sec2">
                    <div><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                      <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                      <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                    </svg></div>
                      <div class="number2">0</div>
                    </div>
              </div>
              </div>
            </div>
           
          </div>
      </div>
    </div>
      <!-- 1 -->
  <div class="card-box">
    <div class="inner-card-box">
      <div class="info-title">
        <h3> 간호사가 알려주는<br> 희망부서 선택법!</h3>
        <br/>
      </div>
        <div class="msg">
          병원에 처음 입사하게 되면 희망 부서를 정해야 한다는 거, 간호학과라면 다들 알고 계시죠? 소문만 무성한 응급실부터...
        </div>
        <div class="profile-like-wrap">
          <div class="profile">
            <div class="pf">
                <img class="info-img class="tw-aspect-square tw-object-cover tw-rounded-full tw-w-12 tw-h-12 tw-rounded-full tw-bg-white tw-border tw-border-solid tw-border-slate-200 tw-object-cover tw-flex-none src="https://publy.imgix.net/user-uploaded/383030/2022.08/17d42cb41014db84702e0d738abfd9b59f0e987a3f1ebe8e0aaa7dadd7d9aaa1.jpeg?w=200&amp;h=200&amp;auto=format&amp;fm=jpeg" alt="성원님의 프로필 사진" title="성원님의 프로필 사진"></lmg></img>
            </div>
            <div class="info-text-box" >
              <span class="info-user-name">가나다라마</span>
              <br/>
              <span class="user-bottom">간호사 대학병원 · 4년차</span>
              <div class="info-content">
                <div class="sec1">
                  <div><svg aria-label="좋아요" class="x1lliihq x1n2onr6" color="rgb(142, 142, 142)" fill="rgb(142, 142, 142)" height="24" role="img" viewBox="0 0 24 24" width="24"><path d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"></path></svg></div>
                  <div class="number1">0</div>
                </div>
                <div class="sec2">
                  <div>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                      <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                      <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                    </svg>
                </div>
                    <div class="number2">0</div>
                  </div>
            </div>
            </div>
          </div>
         
        </div>
    </div>
  </div>
</section>
</main>
  `;
}

function makeReview() {
    return `
  <div class="reply-flex">
  <input type="text" class="reply" placeholder="후기를 등록 해보세요!!"/>
  <button type="button" class="reply-btn">등록</button>
</div>
<div class="review-flex">
  <div class="star-rating">
    <input type="radio" id="5-stars" name="rating" value="5" />
    <label for="5-stars" class="star">&#9733;</label>
    <input type="radio" id="4-stars" name="rating" value="4" />
    <label for="4-stars" class="star">&#9733;</label>
    <input type="radio" id="3-stars" name="rating" value="3" />
    <label for="3-stars" class="star">&#9733;</label>
    <input type="radio" id="2-stars" name="rating" value="2" />
    <label for="2-stars" class="star">&#9733;</label>
    <input type="radio" id="1-star" name="rating" value="1" />
    <label for="1-star" class="star">&#9733;</label>
  </div>
  <div class="review-writer">
    <td class="review-review">
      <p class="btn-view"><strong>이준 멘토님 너무 잘 알려주세요.</strong></p>
    </td>
    <div class="name-can">
      <td>백두산</td>
    </div>
  </div>
</div>
  `;
}
