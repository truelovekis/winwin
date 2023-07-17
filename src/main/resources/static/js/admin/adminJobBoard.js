import * as admin from './module/adminModule.js';

// mainCategory 불러오기
// 1차 카테고리
let $category1 = $(".search-text2");
// 2차 카테고리
// let $jobBox = $(".second-job-box");
// // 3차 카테고리
// let $depBox = $(".third-job-box");

$(".maincode").on("change", function () {
    let $jobList = $(".job-list");
    let $depList = $('.dep-list');
    let value = $(this).val();

    $jobList.hide();
    $depList.hide();

    console.log(value);

    if(value == "1"){
        $jobList.show();
        $jobList.css('opacity', '1');
        admin.careerJobList(makeJobList);
    }else if(value == '2'){
        $depList.show();
        $depList.css('opacity', '1');
        admin.careerDepList(makeDepList);
    }
    // if($(this).val() == "2"){
    //     $.ajax({
    //         url: "/status/CateDep",
    //         type: "get",
    //         data: {mainCode: ss},
    //         dataType : 'json',
    //         success: function (result) {
    //             makeMiddleCate(result);
    //         },
    //     });
    // }
    // $('.job-list').html(text);
});

$('.list1').on('click', '.code-btn', function (){
    console.log($(this).data('code'));
    $('#main-code').val($(this).data('code'));
});

// 2, 3차 카테고리 선택 시 항목 띄어주는 함수

function makeDepList(result){
    let text = '';

    result.forEach(obj => {
        text += `
            <li class="dep-big-cateogry">
                <input type="checkbox" name="dep-checked01" class="dep-chk" id="dep-checked01"
                       style="font-family: NanumSquareAcr;">
                <label for="dep-checked01" style="cursor: pointer;" >
                    <span class="dep-name">
                      <span data-code="${obj.mainCode}" class="code-btn">${obj.mainName}</span>
                    </span> 
                </label>
            </li>
        `;
    })
    $('.dep-category').html(text);
    clickOption2();
}

function makeJobList(result){
    let text2 = '';

    result.forEach(r => {
        text2 += `
            <li class="job-big-cateogry">
            <input type="checkbox" name="job-checked01" class="job-chk" id="job-checked01" style="font-family: NanumSquareAcr;">
                <label for="job-checked01" style="cursor: pointer;" >
                    <span class="job-name">
                      <span data-code="${r.mainCode}" class="code-btn">${r.mainName}</span>
                    </span>
                </label>
            </li>
        `;
    });
    $('.job-category').html(text2);
    clickOption();

    return text2;
}

// 직무 or 학과 checkbox클릭시 발생되는 이벤트

// $("#job-dep").on("change", function () {
//     console.log($(this).val());
//     let val = $(this).val();
//     let $jobList = $(".job-list");
//     let $depList = $(".dep-list");
//
//     if (val == "") {
//         $jobList.hide();
//         $depList.hide();
//     } else if (val == "1") {
//         $jobList.show();
//         $depList.hide();
//     } else if (val == "2") {
//         $jobList.hide();
//         $depList.show();
//     }
// });


// 직무 or 학과 선택 시 check박스 background-color 변경
let $jobSelect = $(".job-big-cateogry");
let $depSelect = $(".dep-big-cateogry");
let $selectedCheckbox = null;

function clickOption() {
    let $jobSelect = $(".job-big-cateogry");
    $('.job-name').on("click", $('.code-btn') ,function () {
        if ($selectedCheckbox != null) {
            $selectedCheckbox.css("background-color", "");
            $selectedCheckbox.css("color", "");
            $selectedCheckbox.css("font-weight", "");
        }

        $selectedCheckbox = $(this); // 새로 선택한 체크박스 저장

        $selectedCheckbox.css("background-color", "#eaf4ff");
        $selectedCheckbox.css("padding" , "10px 5PX");
        $selectedCheckbox.css("border-radius", "5px");
        $selectedCheckbox.css("color", "#007aff");
        $selectedCheckbox.css("font-weight", "bold");
    });
}


function clickOption2 (){
    let $depSelect = $(".dep-big-cateogry");
    $('.dep-name').on("click", $('.dep-big-category'), function () {
        if ($selectedCheckbox != null) {
            $selectedCheckbox.css("background-color", "");
            $selectedCheckbox.css("color", "");
            $selectedCheckbox.css("font-weight", "");
        }

        $selectedCheckbox = $(this); // 새로 선택한 체크박스 저장
        // $selectedCheckbox.css("background-color", "#eaf4ff");
        $selectedCheckbox.css("background-color", "#eaf4ff");
        $selectedCheckbox.css("padding" , "10px 5PX");
        $selectedCheckbox.css("border-radius", "5px");
        $selectedCheckbox.css("color", "#007aff");
        $selectedCheckbox.css("font-weight", "bold");
    });
}

// $depSelect.on("click", function () {
//     if ($selectedCheckbox !== null) {
//         $selectedCheckbox.css("background-color", "");
//         $selectedCheckbox.css("color", "");
//         $selectedCheckbox.css("font-weight", "");
//     }
//
//     $selectedCheckbox = $(this); // 새로 선택한 체크박스 저장
//     $selectedCheckbox.css("background-color", "#eaf4ff");
//     $selectedCheckbox.css("color", "#007aff");
//     $selectedCheckbox.css("font-weight", "bold");
// });

// 체크박스 선택하고 공개 비공개 설정하기
$(document).ready(function () {
    $("input.check").change(function () {
        var checkboxes = $("input.check:checked");
        var checkboxIndexes = checkboxes
            .map(function () {
                return $(this).closest("tr").index();
            })
            .get();

        checkboxes.each(function () {
            var checkbox = $(this);
            var checkboxIndex = checkbox.closest("tr").index();
            var isChecked = checkbox.is(":checked");

            if (isChecked) {
                $(".user-table tbody tr:eq(" + checkboxIndex + ") .public-secret-select").change(function () {
                    var selectElement = $(this);
                    var selectValue = selectElement.val();
                    handlePublicSecret(checkboxIndexes, selectValue);
                });
            }
        });
    });
});

function handlePublicSecret(checkboxIndexes, selectValue) {
    checkboxIndexes.forEach(function (index) {
        var publicSecretButton = $(".user-table tbody tr:eq(" + index + ") .public-secret-button");

        if (selectValue === "1") {
            publicSecretButton.text("공개").css({
                "background-color": "#eaf4ff",
                color: "#007aff",
            });
        } else if (selectValue === "0") {
            publicSecretButton.text("비공개").css({
                "background-color": "rgb(255, 237, 237)",
                color: "red",
            });
        }
    });
}

// span에 디비 값 넣기


// 검색 눌렀을 때
// $('.search-btn').on('click', function (){
//     let codeNumber = $('.codeNumber').data('codenum');
//     let userNumber = $(this).closest('.admin-category').find('.board-category').data('code');
//     // console.log(userNumber);
//
//     let listNumber = $(this).closest('.list-name').find('.code-btn').val();
//     let listCode = $(this).find('.code-btn').val();
//     console.log(listCode);
//     console.log(listNumber);
//
//     let code = $(this).closest('.job-list').find('.code-btn').val();
//
//     // console.log(code);
//
//     $.ajax({
//         url : '/status/list',
//         data : {mainCode : code},
//         type : 'get',
//         success : function (result){
//             list(result);
//         },
//         error : function (){
//             console.log("실패했다 이녀석아")
//         }
//     });
//
// });
//
// function list(result){
//     let text = '';
//
//     result.forEach(r => {
//         text += `
//         <tr class="user-table-category">
//                         <td class="checkbox">
//                             <input type="checkbox" name="" class="check check-box" id="checking"
//                                    th:data-number="${r.careerInfoNumber}">
//                         </td>
//                         <input type="hidden" data-codenum="${r.mainCode}" class="codeNumber">
//                         <td class="board-category" data-value="${r.mainCode}" align="center">${r.mainName}</td>
//                         <td class="board-name" align="center">${r.careerInfoTitle}</td>
//                         <td class="board-writer" align="center">${r.userName}</td>
//                         <td class="board-writer-date" align="center">${r.careerInfoDate}</td>
//                         <td class="board-public-secret" align="center">
//                             <select name="public-secret-select" class="public-secret-select" style="font-family: NanumSquareAcr;">
//                                 <option value="">선택</option>
//                                 <option value="1">공개</option>
//                                 <option value="0">비공개</option>
//                             </select>
//                         </td>
//                         <td className="board-status" align="center">`;
//                         if(r.careerInfoStatus == 1){
//                             text += `
//                             <div class="public-button public-secret-button Y">공개</div>
//                             `;
//                         }
//
//                         if(r.careerInfoStatus == 0){
//                             text += `
//                             <div class="public-button public-secret-button N">비공개</div>
//                             `;
//                         }
//                     text += `
//                     </td>
//                     </tr>`;
//
//     });
//     $('tbody').html(text);
// }