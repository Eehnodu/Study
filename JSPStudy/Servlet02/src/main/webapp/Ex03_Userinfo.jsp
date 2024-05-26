<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Ex03_Userinfo" method="post">
		<b>직업</b> <br><br> <select name = "job">
			<option value ="student">학생</option>
			<option  value ="teacher">선생님</option>
			<option  value ="developer">개발자</option>
		</select>
		<br><br>
		<b>성별</b> <br><br>
		<input type="radio" name="gender" value ="man"> 남자
		<input type="radio" name="gender" value ="woman"> 여자
		<br><br>
		<b>취미</b> <br><br>
		<input type='checkbox' name='hobby'  value ="soccer"> 축구
		<input type='checkbox' name='hobby'  value ="baseball"> 야구
		<input type='checkbox' name='hobby'  value ="basketball"> 농구
		<br><br>
		<input type="submit" value="제출">

	</form>
</body>
</html>