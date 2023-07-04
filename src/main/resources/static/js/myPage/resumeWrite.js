// 학력사항 추가삭제
$('.bi1p').on('click', function(){
    if( $('.bi1').find('.bi1-box').length < 2 ){
        $('.bi1').append(`
            <div class="bi1-box">
              <div class="school-input-box">
                <input name="resumeSchool2" type="text" class="school" placeholder="학교를 입력하세요." />
                <select name="graduation2" id="graduation">
                  <option value="1">졸업</option>
                  <option value="2">재학</option>
                </select>
              </div>
              <div class="school-date-box">
                <input name="schoolStartDate2" type="date" class="school-date" />
                <input name="schoolEndDate2" type="date" class="school-date last-input" />
              </div>
            </div>`)
    }
});

$('.bi1m').on('click', function(){
    if( $('.bi1').find('.bi1-box').length > 1 ) {
        $('.bi1').find('.bi1-box').last().remove();
    }
});

//경력사항 추가삭제
$('.bi2p').on('click', function(){
    let cnt = $('.bi2').find('.bi2-box').length;
    if( cnt < 3 ){
        $('.bi2').append(`
            <div class="bi2-box">
              <div class="school-input-box">
                <input name="resumeCareer${cnt+1}" type="text" class="school" placeholder="직장명을 입력하세요." />
              </div>
              <div class="school-date-box">
                <input name="careerStartDate${cnt+1}" type="date" class="school-date" />
                <input name="careerEndDate${cnt+1}" type="date" class="school-date last-input" />
              </div>
            </div>`)
    }
});

$('.bi2m').on('click', function(){
    if( $('.bi2').find('.bi2-box').length > 1 ) {
        $('.bi2').find('.bi2-box').last().remove();
    }
});

//자격사항 추가삭제
$('.bi3p').on('click', function(){
    let cnt = $('.bi3').find('.bi3-box').length;
    if( cnt < 5 ){
        $('.bi3').append(`
            <div class="bi3-box">
              <div class="certificate">
                <input name="resumeCertiName${cnt+1}" type="text" class="certificate-input" placeholder="자격증 이름을 입력하세요." />
                <input name="resumeCertiGrade${cnt+1}" type="text" class="certificate-input" placeholder="자격증 등급을 입력하세요." />
              </div>
              <input name="resumeCertiNoto${cnt+1}" type="text" placeholder="증빙 기관을 입력하세요." />
            </div>`)
    }
});

$('.bi3m').on('click', function(){
    if( $('.bi3').find('.bi3-box').length > 1 ) {
        $('.bi3').find('.bi3-box').last().remove();
    }
});

// 프로필 사진 미리보기
$('#img-upload').on('change', function(){
    let files = this.files;

    let src = URL.createObjectURL(files[0]);

    $('.preview').css('background-image', `url(${src})`).css('background-size', 'cover').data('name', `${files[0].name}`);
})