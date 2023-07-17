$(document).ready(function () {
    $("input.check").change(function () {
        var checkbox = $(this);
        var isChecked = checkbox.is(":checked");
        var row = checkbox.closest("tr");

        if (isChecked) {
            var selectElement = row.find(".user-report-select");
            var selectValue = selectElement.val();
            handleReportSelect(row, selectValue);
        } else {
            resetReportSelect(row);
        }
    });

    $(".user-report-select").change(function () {
        var selectElement = $(this);
        var row = selectElement.closest("tr");
        var isChecked = row.find("input.check").is(":checked");

        if (isChecked) {
            var selectValue = selectElement.val();
            handleReportSelect(row, selectValue);
        }
    });

    function handleReportSelect(row, selectValue) {
        var blindButton = row.find(".blind-button");
        var successButton = row.find(".success-button");

        if (selectValue === "2") {
            blindButton.text("신고회원").css({
                "background-color": "rgb(255 214 156 / 57%)",
            color: "rgb(254, 143, 0)",
            });
            successButton.text("신고회원").css({
                "background-color": "rgb(255 214 156 / 57%)",
                color: "rgb(254, 143, 0)",
            });
        // } else if (selectValue === "2") {
        //     blindButton.text("14일 정지").css({
        //         "background-color": "#eaf4ff",
        //         color: "#007aff",
        //     });
        //     successButton.text("14일 정지").css({
        //         "background-color": "#eaf4ff",
        //         color: "#007aff",
        //     });
        } else if (selectValue === "1") {
            blindButton.text("일반회원").css({
                "background-color": "#eaf4ff",
                color: "#007aff",
            });
            successButton.text("30일 정지").css({
                "background-color": "#eaf4ff",
                color: "#007aff",
            });
        } else if (selectValue === "3") {
            blindButton.text("영구 정지").css({
                "background-color": "rgb(255, 237, 237)",
                color: "red",
            });
            successButton.text("영구 정지").css({
                "background-color": "rgb(255, 237, 237)",
                color: "red",
            });
        }
    }

    function resetReportSelect(row) {
        // var blindButton = row.find(".blind-button");
        var successButton = row.find(".success-button");

        // blindButton.text("신고회원").css({
        //     "background-color": "#eaf4ff",
        //     color: "#007aff",
        // });
        successButton.text("영구 정지").css({
            "background-color": "rgb(220 255 226)",
            color: "#587c60",
        });
    }
});
