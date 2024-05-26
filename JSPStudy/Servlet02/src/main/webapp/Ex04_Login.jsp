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
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	if (id.equals("smart") & pwd.equals("123")) {
		// get방식에서 사용할 수 있는 Query String 문법!
		// response.sendRedirect("Ex04_LoginSuccess.jsp?id=" + id);
		
		// foward 방식 : 요청에 대한 내용을 공유하며 새로운 요청을 할 수 있는 기법!
		RequestDispatcher rd = request.getRequestDispatcher("Ex04_LoginSuccess.jsp");
		request.setAttribute("id", id);
		rd.forward(request, response);
		
	} else {
		response.sendRedirect("Ex04_LoginFail.jsp");
	}
	%>
</body>
</html>