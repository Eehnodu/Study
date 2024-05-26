<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 확인 페이지</h1>
	<%
	Cookie[] result = request.getCookies();

	for (int i = 0; i < result.length; i++) {
		out.print(result[i].getName() + " / " + result[i].getValue() + "<br>");

	}
	%>
	<br>
	<a href="Ex01_Removecookie.jsp">쿠키 삭제 페이지</a>
</body>
</html>