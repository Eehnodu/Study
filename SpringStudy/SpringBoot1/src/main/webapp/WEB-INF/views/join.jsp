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
	<form action="${cpath}/join-process" method="post">
		ID : <input type="text" name="id">
		<br>
		PW : <input type="text" name="pw">
		<br>
		NAME : <input type="text" name="name">
		<br>
		TEL : <input type="text" name="tel">
		<br>
		<input type="submit" value="Join">
	</form>
	
</body>
</html>