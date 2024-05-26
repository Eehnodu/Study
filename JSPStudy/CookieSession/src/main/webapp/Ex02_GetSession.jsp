<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. session안에 있는 데이터 꺼내오기
		ArrayList<String> list = (ArrayList) session.getAttribute("testsession");
		// ** session안에 저장되어 있는 데이터를 꺼내올때는
		//	  반드시 다운캐스팅을 해줘야 원하는 자료를 가져올 수 있따.
		// 다운캐스팅이란?
		// >> 업캐스팅된 객체를 다시 본래의 자료형으로 강제로 형변환하는 것

		// 2. 출력하기
		out.print(list.get(0));
	%>
</body>
</html>