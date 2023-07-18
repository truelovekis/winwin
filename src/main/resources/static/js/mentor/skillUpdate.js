let $skillBtn = $(".tw-boarder");

$skillBtn.on("click", function () {
    let $targetBox = $(".tw-flexr2");
    let selectBtn = "";
    let text = $(this).find("h3").text();
    console.log("이거다!!!!")
    selectBtn = `
  <button type="button" class="tw-boarder2">
  <h3 class="tw-font-bold2">${text}</h3>
  <input type="hidden" value="${text}" name="skillName"/>
  <div class="presentation">
    <svg
      width="16"
      height="16"
      stroke-width="0"
      viewBox="0 0 24 24"
      fill="current"
      xmlns="http://www.w3.org/2000/svg"
      type="solid"
      class="icn-white"
    >
      <path
        fill-rule="evenodd"
        clip-rule="evenodd"
        d="M5.29289 5.29289C5.68342 4.90237 6.31658 4.90237 6.70711 5.29289L12 10.5858L17.2929 5.29289C17.6834 4.90237 18.3166 4.90237 18.7071 5.29289C19.0976 5.68342 19.0976 6.31658 18.7071 6.70711L13.4142 12L18.7071 17.2929C19.0976 17.6834 19.0976 18.3166 18.7071 18.7071C18.3166 19.0976 17.6834 19.0976 17.2929 18.7071L12 13.4142L6.70711 18.7071C6.31658 19.0976 5.68342 19.0976 5.29289 18.7071C4.90237 18.3166 4.90237 17.6834 5.29289 17.2929L10.5858 12L5.29289 6.70711C4.90237 6.31658 4.90237 5.68342 5.29289 5.29289Z"
        fill="inherit"
      ></path>
    </svg>
  </div>
</button>
  `;

    $targetBox.append(selectBtn);
});

$(".tw-flexr2").on("click", ".icn-white", function () {
    $(this).closest(".tw-boarder2").detach();
});



$(".ins-btn").on("click", function () {
    let $targetBox = $(".tw-flexr2");
    let value = $(".form-control").val();
    $(".form-control").val("");

    let selectBtn = `
  <button type="button" class="tw-boarder2">
  <h3 class="tw-font-bold2">${value}</h3>
  <input type="hidden" value="${value}" name="skillName"/>
  <div class="presentation">
    <svg
      width="16"
      height="16"
      stroke-width="0"
      viewBox="0 0 24 24"
      fill="current"
      xmlns="http://www.w3.org/2000/svg"
      type="solid"
      class="icn-white"
    >
      <path
        fill-rule="evenodd"
        clip-rule="evenodd"
        d="M5.29289 5.29289C5.68342 4.90237 6.31658 4.90237 6.70711 5.29289L12 10.5858L17.2929 5.29289C17.6834 4.90237 18.3166 4.90237 18.7071 5.29289C19.0976 5.68342 19.0976 6.31658 18.7071 6.70711L13.4142 12L18.7071 17.2929C19.0976 17.6834 19.0976 18.3166 18.7071 18.7071C18.3166 19.0976 17.6834 19.0976 17.2929 18.7071L12 13.4142L6.70711 18.7071C6.31658 19.0976 5.68342 19.0976 5.29289 18.7071C4.90237 18.3166 4.90237 17.6834 5.29289 17.2929L10.5858 12L5.29289 6.70711C4.90237 6.31658 4.90237 5.68342 5.29289 5.29289Z"
        fill="inherit"
      ></path>
    </svg>
  </div>
</button>
  `;

    $targetBox.append(selectBtn);
});

let $back = $('.back-button');

$back.on('click', function (){
    window.location.href = '/mentor/apply';
});
