<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- form 태그의 method 기본값은 get 방식이다. -->
	<form action="Ex01_login" method="post">
		ID : <input type="text" name="id"> <br>
		PW : <input type="password" name="pwd"> <br>
		<input type="submit" value="login">
	</form>
</body>
</html>