<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>로그인 성공 페이지</h1>
	<fieldset>
		<legend>로그인 성공</legend>
		<%
		// get 방식의 Query String 문법 사용시 데이터 꺼내오기!
		//request.setCharacterEncoding("utf-8");
		//String id = request.getParameter("id");
		
		// forward 방식으로 넘어온 데이터 꺼내오기!
		// getAttribute()의 반환 타입은 Object 이므로 변수에 저장할때에는 형변환이 필요하다!
		String id = (String) request.getAttribute("id");

		out.print("<b>" + id + "님 환영합니다." + "</b>");
		%>
		<br> <a href="Ex04_Login.html">로그아웃</a>
	</fieldset>
</body>
</html>