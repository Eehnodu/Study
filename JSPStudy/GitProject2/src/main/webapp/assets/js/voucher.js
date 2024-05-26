$(".owl-carousel-info-wrap.item").on("click", function() {
	let trn_name = $(this).find('h4').text().trim();
	$("#get_trn").text(trn_name);

	let trnData = {
		"trn_name": trn_name
	};

	$.ajax({
		type: 'POST',
		url: 'Voucher.do',
		data: trnData,
		dataType: "JSON",
		success: function(res) {
			console.log(res);

			$('#vc_price').empty();
			$('#vc_price_modal').empty(); // 모달 내용 초기화

			// 총 가격을 저장할 변수 초기화
			let totalPrice = 0;

			for (let i = 0; i < res.length; i++) {
				res[i].vc_idx;
				$('#vc_price').append("<p>짐이용권 " + res[i].vc_name + " => " + res[i].vc_price + "원</p>");

				if (i == 0 || i == 1) {
					$('#vc_price_modal').append("<p><input type='radio' name='voucher' data-price='" + res[i].vc_price + "' data-vc-idx='" + res[i].vc_idx + "'>" + " 짐 이용권 " + res[i].vc_name + " => " + res[i].vc_price + "원</p>");
				} else {
					if (i == 2) {
						$('#vc_price_modal').append("<hr>");
					}
					$('#vc_price_modal').append("<p><input type='radio' name='PT' data-price='" + res[i].vc_price + "' data-vc-idx='" + res[i].vc_idx + "'>" + " PT 이용권 " + res[i].vc_name + " => " + res[i].vc_price + "원</p>");
				}
			}

			// 라디오 버튼 클릭 이벤트 리스너 추가
			$('input[name="voucher"], input[name="PT"]').click(function() {
				// 선택된 라디오 버튼들의 가격을 더함
				totalPrice = calculateTotalPrice();

				// 총 가격을 표시
				$('#total_price').text("총 가격: " + totalPrice.toLocaleString() + "원 입니다!");

				// 선택된 이용권의 vc_idx를 hidden input에 설정
				let resvc_idxs = []; // 선택된 모든 이용권의 vc_idx를 저장할 배열
				$('input[name="voucher"]:checked, input[name="PT"]:checked').each(function() {
					resvc_idxs.push($(this).data('vc-idx')); // 선택된 각 항목의 vc_idx를 배열에 추가
				});
				$('#get_vc_idx').val(resvc_idxs.join(',')); // hidden input에 선택된 이용권의 vc_idx 설정
			});

			// 총 가격을 계산하는 함수
			function calculateTotalPrice() {
				let price = 0;
				// 선택된 라디오 버튼들의 가격을 더함
				$('input[name="voucher"]:checked, input[name="PT"]:checked').each(function() {
					// 쉼표(,)를 제거하고 정수로 변환하여 가격에 더함
					let priceStr = $(this).data('price').replace(/,/g, '');
					price += parseInt(priceStr);
				});
				return price;
			}

			// 초기 총 가격 계산 및 표시
			totalPrice = calculateTotalPrice();
			$('#total_price').html("총 가격: " + totalPrice.toLocaleString() + "원 입니다!");
			$('#buy').html('<input type="submit" value="구매하기" class="custom-btn btn-16">'); // 버튼 텍스트 변경
		},
		error: function() {
			console.log('실패');
		}
	});
});

// "예약하기" 버튼 클릭 이벤트 리스너 추가
// "예약하기" 버튼 클릭 이벤트 리스너 추가
$('#buy').off('click').on('click', function() {
	// 선택된 이용권의 vc_idx 가져오기
	let resvc_idxs = $('#get_vc_idx').val(); // hidden input에 설정된 선택된 이용권의 vc_idx 값 가져오기

	// 이용권을 선택하지 않았을 때
	if (!resvc_idxs) {
		alert('이용권을 선택해주세요!');
		return;
	}

	// AJAX를 사용하여 Purchase 서블릿으로 데이터 전송
	$.ajax({
		type: 'POST',
		url: 'Purchase.do',
		data: { "get_vc_idx": resvc_idxs },
		success: function(response) {
			alert('이용권 구매 성공!'); // 이용권 구매 성공 시 알림창 표시
		},
		error: function() {
			alert('이용권을 다시 선택해주세요!'); // 실패 시 알림창 표시
		}
	});
});
