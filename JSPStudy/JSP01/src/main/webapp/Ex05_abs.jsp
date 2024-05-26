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
	int num1 = 5;
	int num2 = -5;
	int result1 = abs(num1);
	int result2 = abs(num2);
	%>

	<%=num1%>의 절댓값 :
	<%=result1%><br>
	<%=num2%>의 절댓값 :
	<%=result2%>

	<%!private int abs(int num) {
		return num > 0 ? num : num * (-1);
	}%>
</body>
</html>