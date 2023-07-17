
export function careerJobList(callback){
    $.ajax({
        url: "/status/cateJob",
        type: "get",
        dataType: 'json',
        success: function (result) {
            callback(result);
        },
        error: function (a, b, c) {
            console.error(c);
        }
    });
}


export function careerDepList(callback){
    $.ajax({
        url: "/status/cateDep",
        type: "get",
        dataType: 'json',
        success: function (result) {
            callback(result);
        },
        error: function (a, b, c) {
            console.error(c);
        }
    });
}

