
// const dislikeBtn = document.querySelector('.bi-hand-thumbs-up');
// const likeBtn = document.querySelector('.bi-hand-thumbs-up-fill');

// // 누를 시 꽉 찬 추천으로 변경
// dislikeBtn.onclick = function () {
// dislikeBtn.classList.add('hide');
// likeBtn.classList.remove('hide');
// }

// // 다시 누르면 빈 추천으로 돌아옴
// likeBtn.onclick = function(){
//     likeBtn.classList.add('hide');
//     dislikeBtn.classList.remove('hide');
// }

let $likeUp = $('.bi-hand-thumbs-up');
let $likeDown = $('.bi-hand-thumbs-up-fill');

$likeUp.on('click', function(){
    $(this).parents('.like-btn').find('.bi-hand-thumbs-up-fill').show();
    $(this).parents('.like-btn').find('.bi-hand-thumbs-up').hide();
});

$likeDown.on('click', function(){
    $(this).parents('.like-btn').find('.bi-hand-thumbs-up-fill').hide();
    $(this).parents('.like-btn').find('.bi-hand-thumbs-up').show();
});


let $empty = $('.bi-hand-thumbs-up');
let $full = $('.bi-hand-thumbs-up-fill');

$empty.on('click', function(){
    $(this).parents('.good').find('.bi-hand-thumbs-up-fill').show();
    $(this).parents('.good').find('.bi-hand-thumbs-up').hide();
});

$full.on('click', function(){
    $(this).parents('.good').find('.bi-hand-thumbs-up-fill').hide();
    $(this).parents('.good').find('.bi-hand-thumbs-up').show();
});



let $dislikeBtn = $('.bi-hand-thumbs-down');
let $fulllikeBtn = $('.bi-hand-thumbs-down-fill');

$dislikeBtn.on('click', function(){
    $(this).parents('.bad').find('.bi-hand-thumbs-down-fill').show();
    $(this).parents('.bad').find('.bi-hand-thumbs-down').hide();
});

$fulllikeBtn.on('click', function(){
    $(this).parents('.bad').find('.bi-hand-thumbs-down-fill').hide();
    $(this).parents('.bad').find('.bi-hand-thumbs-down').show();
});

displayAjax();

function displayAjax(){
    let communityNumber = $('.community-num').val();

    $.ajax({
        url : '/files/imgList',
        type : 'get',
        data : {communityNumber : communityNumber},
        success : function (files){
            let text = '';

            files.forEach(file => {
                let fileSystemName = file.fileUploadPath + '/' + file.fileUuid + '_' + file.fileSystemName;
                text += `
                    <a href="/files/download?fileSystemName=${fileSystemName}">
                        <img src="/files/display?fileSystemName=${fileSystemName}" width="200px" height="200px" data-number="${file.fileNumber}" data-name="${fileSystemName}"/>
                    </a>
                `;
            });

            $('.img-box').html(text);
        }


    });
}




// 수정&삭제 버튼

function fn_modify(communityNumber){
    if(confirm("정말 수정하시겠습니까?")){
        location.href = "/community/modify?communityNumber="+communityNumber;    
    }
}

function fn_remove(communityNumber){
    if(confirm("정말 삭제하시겠습니까?")){
        location.href = "/community/remove?communityNumber="+communityNumber;    
    }
    
}

// 리플 작성 완료 처리

const communityNumber = $('.community-num').val();

$('.commentBtn').on('click', function(){
    let content = $('.comment1').val().trim();
    console.log(content);
    if(content == ''){
        return;
    }

    let commentObj = {
        commentContent : content,
        communityNumber : communityNumber
    }

    register(commentObj, function(){
        getList(communityNumber, showComment, showError);
    }, showError);

    $('.comment1').val('');
});

function register(commentObj, callback, error){
    $.ajax({
        url : "/comment/comment",
        type : "post",
        data : JSON.stringify(commentObj),
        contentType : 'application/json; charset=utf-8',
        success : function (){
            if(callback){
                callback();
            }
        },
        error: error
    });
    console.log(commentObj);

}

function getList(communityNumber, callback, error){
    $.ajax({
        url : `/comment/list/${communityNumber}`,
        type : 'get',
        dataType : 'json',
        success : function (result){
            if (callback){
                callback(result);
            }
        },
        error : error
    });
}

function showComment() {
}

function showError() {
}



// function getView(commentNumber, callback, error){
//     $.ajax({
//         url : `/comment/${commentNumber}`,
//         type : 'get',
//         dataType : 'json',
//         success : function (result){
//             if(callback){
//                 callback(result);
//             }
//         },
//         error : error
//     });
// }



// // 리플 수정 버튼 처리
// $('.dropdown-content2').on('click', '.btn-modify', function () {
//     let $content = $(this).closest('.commentAi').find('.Aicontent');
//     $content.replaceWith(`
//   <div class='modify-box'>
//     <textarea class='modify-content'>${$content.text()}</textarea>
//     <button type='button' class='modify-content-btn'>수정 완료</button>
//   </div>
//   `);
//     $('.dropdown-content2').addClass('none');
// });


