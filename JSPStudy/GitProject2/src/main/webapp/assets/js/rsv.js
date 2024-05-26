$(".owl-carousel-info-wrap.item").on("click", function() {
	let trn_name = $(this).find('h4').text().trim();
	$("#get_trn").text(trn_name);

	let trnData = {
		"trn_name": trn_name
	};

	$.ajax({
		type: 'POST',
		url: 'RsvInfo.do',
		data: trnData,
		dataType: "JSON",
		success: function(res) {
			console.log("요청")
			$('#trn_phone').html("연락처 : " + res.trn_phone);
			$('#trn_info').text("트레이너 정보 : " + res.trn_info);
			$('#trn_career').text("트레이너 경력 : " + res.trn_career);

			// 히든 필드에 트레이너의 idx 값을 설정
			$('#hidden_trn_idx').val(res.trn_idx);

			// 두 번째 AJAX 요청
			let get_trn_idx = {
				"trn_idx": res.trn_idx
			};
			$.ajax({
				type: 'POST',
				url: 'Rsv_Date.do',
				data: get_trn_idx,
				success: function(res) {
					console.log('Rsv_Date 요청 성공:', res);
					$('#rsv_date').empty(); // 예약 가능 날짜와 시간을 추가하기 전에 이전 내용 삭제
					res.forEach(function(item) {
						// pt_status를 데이터 속성으로 추가하되 화면에는 보이지 않도록 설정
						$('#rsv_date').append("<p><input type='checkbox' name='pt_date' data-pt-st-dt='" + item.pt_st_dt + "'data-pt-ed-dt='" + item.pt_ed_dt + "' data-pt-date='" + item.pt_date + "' data-pt-idx='" + item.pt_idx + "' data-pt-status='" + item.pt_status + "' value='" + "예약날짜" + item.pt_date + "'>" + "&nbsp" + item.pt_date + " 시작시간 : " + item.pt_st_dt.substring(0, 5) + " 종료시간 : " + item.pt_ed_dt.substring(0, 5) + "</p>");

					});
					$('.reservation-item').css({
						border: '1px solid #333333', // 테두리 추가
						padding: '10px', // 내부 여백 설정
						borderRadius: '5px', // 테두리 모서리를 둥글게 만듭니다.
						marginBottom: '10px' // 아래쪽 여백 추가
					});
				},
				error: function() {
					console.log('Rsv_Date 요청 실패');
				}
			});
		},
		error: function() {
			console.log('실패');
		}
	});
});

$('#reserve_button').on('click', function() {
	// 선택된 예약 시작 시간, 인덱스, 상태 가져오기
	var selectedReservations = [];
	$('input[name="pt_date"]:checked').each(function() {
		var startTime = $(this).data('pt-st-dt'); // 시작 시간
		var endTime = $(this).data('pt-ed-dt'); // 시작 시간
		var date = $(this).data('pt-date'); // 날짜
		var ptIdx = $(this).data('pt-idx');
		var ptStatus = $(this).data('pt-status');

		// 날짜와 시작 시간을 결합하여 완전한 날짜 및 시간 생성
		var fullDateTime = date + ' ' + startTime;
		var endDateTime = date + ' ' + endTime;

		console.log(endTime);
		console.log(endDateTime);

		selectedReservations.push({ created_at: fullDateTime, pt_idx: ptIdx, res_status: ptStatus, endTime: endDateTime });
	});

	// 선택된 예약 정보가 없는 경우
	if (selectedReservations.length === 0) {
		alert('예약할 날짜를 선택해주세요.');
		return;
	} else {
		alert('예약을 완료했습니다.');
	}

	// JSON.stringify() 함수를 사용하여 JSON 문자열로 변환
	var jsonData = JSON.stringify(selectedReservations);
	console.log(jsonData); // 전송할 JSON 데이터를 로그에 출력

	$.ajax({
		type: 'POST',
		url: 'RsvCommit.do', // 예약 처리를 담당하는 서블릿 URL
		contentType: 'application/json',
		data: jsonData, // JSON 형식의 데이터 전송
		success: function(res) {
			// 예약이 성공적으로 처리되면 예약 완료 메시지를 표시
			console.log(res);
		},
		error: function() {
			console.log('예약 처리 요청 실패');
		}
	});
});

