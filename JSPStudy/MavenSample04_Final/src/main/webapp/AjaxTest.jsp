<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="data">
	<button class="btn">데이터전송</button>
	<!-- 1. 라이브러리 불러오기 -->
	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript">
		// js코드르 작성할 수 있는 공간
		
		$(".btn").on("click", function(){
			let sendData = {"sendData" : $("#data").val()};
			console.log(sendData);
			
			$.ajax({
				// 보내줄 url
				url : "Ajax", // ex)Ajax?sendData=안녕
				// 보내줄 data
				data : sendData,
				// 전송방식 지정
				type : 'get',
				// 결과값 자료형 지정
				dataType : 'json',
				// 성공했을 때 실행할 함수 지정
				success : (res) => {
					console.log("데이터 전송 성공!");
					console.log(res);
					console.log(res.email);
				},
				// 실패했을 때 실행할 함수 지정
				error : (e) => {
					console.log("데이터 전송 실패!");
				}
				
				
			})
		})
	</script>
</body>
</html>