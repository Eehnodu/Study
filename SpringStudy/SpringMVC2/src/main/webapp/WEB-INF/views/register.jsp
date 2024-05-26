<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
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
			<div class="card-header">게시글 등록</div>
			<div class="card-body">
				<form action="${cpath}/regester" method="post">
					<div class="form-group">
						<label for="title">제목 :</label>
						<input type="text" name="title" class="form-control" placeholder="제목 입력" id="title" value="${item.title}">
					</div>
					<div class="form-group">
						<label for="writer">작성자 :</label>
						<input type="text" name="writer" class="form-control" placeholder="작성자 입력" id="writer" value="${item.writer}">
					</div>
					<div class="form-group">
						<label for="content">내용 :</label>
						<textarea class="form-control" name="content" rows="10px" cols="135px" id="content" placeholder="내용 입력"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">작성하기</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>