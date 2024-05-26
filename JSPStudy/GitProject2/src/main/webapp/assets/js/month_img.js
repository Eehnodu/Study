$(document).ready(function() {
    $.ajax({
        url: "MonthImg.do",
        type: "post",
        dataType: "json",
        success: function(response) {
            // 서버로부터 받은 데이터를 처리
            console.log(response);
            $(".card-stat").css("background-image", "url('" + response.img_src + "')"); // 배경 이미지 경로 설정
            $("#month_img_content").text(response.img_content); // 문장 설정
        },
        error: function(xhr, status, error) {
            console.error("AJAX 오류 발생");
        }
    });
});
