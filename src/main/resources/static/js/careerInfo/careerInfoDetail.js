$(".like-btn").on("click", function () {
    $(this).find(".bi-heart").toggleClass("none");
    $(this).find(".bi-heart-fill").toggleClass("none");

    $(".hate-btn").find(".bi-heart").removeClass("none");
    $('.hate-btn').find(".bi-heart-fill").addClass("none");
});

$(".hate-btn").on("click", function () {
    $(this).find(".bi-heart").toggleClass("none");
    $(this).find(".bi-heart-fill").toggleClass("none");

    $(".like-btn").find(".bi-heart").removeClass("none");
    $(".like-btn").find(".bi-heart-fill").addClass("none");
});