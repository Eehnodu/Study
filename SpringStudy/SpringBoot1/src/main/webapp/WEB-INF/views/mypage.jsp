<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 화면</h1>
	<table border=1>
		<tr>
			<td>Id</td>
			<td>${param.entity}</td>
		</tr>

		<%-- <tr>
			<td>Id</td>
			<td>${entity.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${entity.name}</td>
		</tr>
		<tr>
			<td>TEL</td>
			<td>${entity.tel}</td>
		</tr>
		 --%>
	</table>
</body>
</html>