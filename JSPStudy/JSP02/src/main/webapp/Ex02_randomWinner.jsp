<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<fieldset>
		<legend>랜덤 당첨 결과</legend>
		<%
		Random ran = new Random();

		request.setCharacterEncoding("utf-8");

		String title = request.getParameter("title");
		String[] item = request.getParameterValues("item");

		out.print(title + "<br>");
		out.print(item[ran.nextInt(item.length)]);
		%>
	</fieldset>
</body>
</html>
.
