$(document).ready(function() {
	$.ajax({
		url: "GetSentence.do",
		type: "POST", // GET 방식으로 요청
		dataType: "json", // 응답 데이터의 타입이 JSON임을 명시
		success: function(res) {
			// 가져온 데이터를 #change_sentence 요소의 텍스트로 설정
			$("#change_sentence").text(res.content);
		},
		error: function() {
			console.log("실패");
		}
	});
});