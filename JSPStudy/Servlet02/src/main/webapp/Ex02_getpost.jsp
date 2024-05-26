<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Ex02_getpost" method="get">
		name : <input type="text" name="name"> <input type="submit"
			value="get">
	</form>
	<br>
	<form action="Ex02_getpost" method="post">
		name : <input type="text" name="name"> <input type="submit"
			value="post">
	</form>
</body>
</html>