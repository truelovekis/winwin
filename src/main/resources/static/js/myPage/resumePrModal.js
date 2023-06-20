// html2canvas 라이브러리로 특정요소를 img로 변환
// 변환한 이미지를 jsPDF라이브러리로 pdf파일로 저장
$(".save-btn").on("click", function () {
    html2canvas($(".modal-box")[0], {
        allowTaint: true,
    }).then(function (canvas) {
        let img = canvas.toDataURL("image/png");

        let margin = 0; //출력 페이지 margin (0이면 pdf파일 최상단에 딱 붙어서 출력됨)

        // 아래 크기는 A4를 기준으로 만든 식
        let imgWidth = 200; //  컨텐트 너비(mm)
        let pageHeight = imgWidth * 1.414; // 출력 페이지의 세로 길이
        let imgHeight = (canvas.height * imgWidth) / canvas.width; // 이미지 높이
        let heightLeft = imgHeight;
        let doc = new jsPDF("p", "mm", "a4");
        let position = margin;

        // 첫 페이지
        doc.addImage(img, "PNG", margin, position, imgWidth, imgHeight);
        heightLeft -= pageHeight;
        console.log(`imgHeight : ${imgHeight}`);
        console.log(`pageHeight : ${pageHeight}`);
        console.log(`heightLeft : ${heightLeft}`);
        // 내용이 많아 여러 페이지가 나오는 경우 반복처리
        while (heightLeft >= 20) {
            doc.addPage();
            position = heightLeft - imgHeight;
            doc.addImage(img, "PNG", margin, position, imgWidth, imgHeight);
            heightLeft -= pageHeight;
        }

        // 파일 저장

        setTimeout(function () {
            doc.save("sample.pdf");
        }, 1000);
    });
});
