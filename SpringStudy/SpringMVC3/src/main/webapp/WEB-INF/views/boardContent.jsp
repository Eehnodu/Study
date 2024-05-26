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
</head>
<body>
	<div class="jumbotron">
		<h1>게시판</h1>
		<p>게시판입니다.</p>
	</div>

	<div class="container">
		<div class="card">
			<div class="card-header">게시글 상세</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr>
						<td>제목</td>
						<td>${item.title}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>${item.content}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${item.writer}</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>${item.indate}</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button class="btn btn-primary btn-sm">수정</button>
							<button class="btn btn btn-success btn-sm" onclick="location.href='${cpath}/boardDelete/${item.idx}'">삭제</button>
							<button class="btn btn btn-danger btn-sm"
								onclick="location.href='${cpath}/'">리스트</button>
						</td>
					</tr>
				</table>
			</div>
			<div class="card-header">게시글</div>
		</div>
	</div>
</body>
</html>