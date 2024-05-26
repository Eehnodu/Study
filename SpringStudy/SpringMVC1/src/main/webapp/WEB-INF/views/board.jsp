<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
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
</head>
<body>
	<div class="jumbotron">
		<h1>게시판</h1>
		<p>게시판입니다.</p>
	</div>

	<div class="container">
		<div class="card">
			<div class="card-header">게시판 연습</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>내용</td>
						<td>작성일</td>
					</tr>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.idx}</td>
							<!-- 1. QueryString으로 데이터 보내기
								 2. 경로상에 그냥 바로 데이터 포함해서 보내기
							-->
							<td><a href="${cpath}/boardContent/${item.idx}">${item.title}</a></td>
							<td>${item.writer}</td>
							<td>${item.content}</td>
							<td>${item.indate}</td>
						</tr>
					</c:forEach>
				</table>
				<button class="btn btn-primary btn-sm" onclick="location.href='${cpath}/register'">글쓰기</button>
			</div>
		</div>
	</div>
</body>
</html>