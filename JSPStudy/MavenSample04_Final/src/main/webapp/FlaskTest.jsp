<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="name">
	<button>검색</button>
	<div>
		<!-- 크롤링한 이미지 결과 1장만 띄우기 -->
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript">
		$("button").on("click", function(){
			let sendData = {"name" : $("#name").val()};
			
			$.ajax({
				// 보내줄 url
				url : "http://127.0.0.1:9000/",
				// 보내줄 data
				data : sendData,
				success : (res) => {
					console.log("데이터 전송 성공!");
					console.log(res)
					$("div").empty();
					$("div").append(`<img src = '\${res}'>`);
				},
				error : () => {
					console.log("데이터 전송 실패!");
				}
			})
		})
	</script>
</body>
</html>