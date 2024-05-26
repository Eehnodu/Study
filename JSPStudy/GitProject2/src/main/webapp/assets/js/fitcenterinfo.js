$(".owl-carousel-info-wrap.item").on("click", function() {
    let trn_name = $(this).find('h4').text().trim();
    $("#get_trn").text(trn_name);

    let trnData = {
        "trn_name": trn_name
    };

    // 클릭한 트레이너의 이름을 서버에 전송하여 트레이너가 속한 센터 정보 가져오기
    $.ajax({
        type: 'POST',
        url: 'FitCenterInfo.do', // 서버의 URL을 지정해야 합니다.
        data: trnData,
        dataType: "JSON",
        success: function(response) {
            // 성공적으로 응답을 받았을 때 센터 정보를 화면에 표시
            console.log(response);
            $("#center_name").text("센터 이름 : "+response.center_name);
            $("#modal").append(response.center_name+" 이용권");            
            $("#center_addr").text("센터 번호 : "+response.center_tel);
            $("#center_tel").text("센터 주소 : "+response.center_addr);
        },
        error: function() {
            console.log('AJAX 요청 실패');
        }
    });
});
