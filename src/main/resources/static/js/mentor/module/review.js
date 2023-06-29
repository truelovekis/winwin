export function register(review, callback, error){
    console.log("넘어왔다.")
    $.ajax({
        url: "/review/review",
        type : 'post',
        data : JSON.stringify(review),
        contentType : 'application/json; charset=utf-8',
        success : function (){
            if (callback){
                callback();
            }
        },
        error : error
    });
}

// export function getList(reviewNumber, callback, error){
//     $.ajax({
//         url : `/review/list/${reviewNumber}`,
//         type : 'get',
//         dataType : 'json',
//         success : function (result){
//             if (callback){
//                 callback(result);
//             }
//         },
//         error : error
//     });
// }