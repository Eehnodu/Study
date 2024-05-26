<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	request.setCharacterEncoding("UTF-8");
	%>
	<div align="center">
		<h1>선호도 조사 결과</h1>
		<hr>
		<table border="1">
			<tr>
				<td align="center">이름</td>
				<td align="center">박병관</td>
			</tr>
			<tr>
				<td>좋아하는 과일</td>
				<td><c:forEach var="fruit" items="${paramValues.fruit}">
                        ${fruit} 
                    </c:forEach></td>
			</tr>
		</table>
	</div>
</body>
</html>