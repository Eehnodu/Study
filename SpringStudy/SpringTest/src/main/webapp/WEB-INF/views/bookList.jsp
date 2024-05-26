<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!-- == controller -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
table, tr, td{
	border: 1px solid black;
}
</style>
</head>
<body>
	<h2>보유 도서 현황</h2>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>내용</td>
			<td>isbn</td>
			<td>보유도서수</td>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.num}</td>
				<td>${item.title}</td>
				<td>${item.author}</td>
				<td>${item.company}</td>
				<td>${item.isbn}</td>
				<td>${item.count}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<h2>도서 입력</h2>
	<form action="${cpath}/bookInsert.do" method="post">
			제목 :
			<input type="text" name="title">
			<br> 작가 :
			<input type="text" name="author">
			<br> 출판사 :
			<input type="text" name="company">
			<br> ISBN :
			<input type="text" name="isbn">
			<br> 보유도서 수 :
			<input type="text" name="count">
			<br>
			<input type="submit" value="등록">
	</form>
</body>
</html>