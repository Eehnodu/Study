
$(document).ready(function() {
	$('#reservationDate').datepicker({
		clearBtn: true,
		format: "yyyy-mm-dd",
		orientation: 'auto' // 달력을 자동으로 최적의 위치에 표시
	});

	// #reservationDate 요소의 변경 이벤트를 처리하여 선택한 날짜를 업데이트
	$('#reservationDate').on('change', function() {
		var pickedDate = $(this).val(); // $(this)를 사용하여 현재 요소의 값을 가져옴
		$('#pickedDate').text(pickedDate); // .html 대신 .text를 사용하여 텍스트를 업데이트
	});
});




// index calendar js
