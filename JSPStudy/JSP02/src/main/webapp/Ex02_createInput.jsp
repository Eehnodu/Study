<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<fieldset>
		<legend>랜덤 당첨 작성</legend>
		<form action="Ex02_randomWinner.jsp">
			주제 : <input type="text" name="title"><br>
			<%
			int num = Integer.parseInt(request.getParameter("data"));

			for (int i = 1; i <= num; i++) {
				out.print("아이템" + i + ": " + "<input type='text' name='item'>" + "<br>");
			}
			%>
			<a href="Ex02_randomWinner.jsp"><input type="submit" value="시작"></a>
		</form>
	</fieldset>
</body>
</html>