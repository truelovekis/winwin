let $fileInput = $('#file');
let $fileList = $('.file-list');
let $fileCnt = $('.file-cnt');

//============
// 파일 미리보기
//============
$fileInput.on('change', function(){
  let files = this.files;

  $fileList.html('');
  console.log($fileList);

  if(files.length>3) {
    let dt = new DataTransfer();
    files = dt.files;

    alert("파일 첨부는 최대 3개 까지만 가능합니다.");
    $fileCnt.text(files.length);
    return;
  }

  console.log($fileList);

  for(let i=0 ; i<files.length; i++){
    let src = URL.createObjectURL(files[i]);

    $fileList.append(
      `
      <div class="img-box">
          <div class="img-box-cancle" data-name='${files[i].name}'>
              X
          </div>
        <img src=${src}>
      </div>
      `
    );
    $fileCnt.text(files.length);
  }

//===========
// 이미지 삭제
// ==========
   $('.img-box-cancle').on('click', function(){
    $(this).parent().remove();

    let fileName = $(this).data('name');

    let dt = new DataTransfer();

    for(let i=0; i<files.length; i++){
      if(files[i].name !== fileName){
        dt.items.add(files[i]);
      }
    }

    files = dt.files;

    $fileCnt.text(files.length);

  });

});

//==========
// 글자수제한
//==========
$('#communityContent').on('keyup', function(e) {
    let $content = $(this).val();
    $('.cnt').html(""+$content.length+"");

    if($content.length > 500){
        alert("최대 500자까지 입력 가능합니다.");
        $(this).val($content.substring(0,500));
        $('.text-cnt').html("글자수 : 500/500");
    }
});