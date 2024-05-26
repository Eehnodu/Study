<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>대시보드</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
	<style>
		.container{
			max-width : 434px;
		}
	</style>
</head>

<body>
<div class="container" align="center">
    <h3 class="form-signin-heading text-center mb-5">💚빅데이터반 대시보드💚</h3>

	<h4 class="overview-normalize">${mydata.userid}</h4>
	<p id='loginid'>
	</p>
	<hr/>
    <h4 class="overview-normalize">${mydata.role}</h4>
	<p id='pw'>
	</p>
    <hr/>
    <h4 class="overview-normalize">이동 권한 확인</h4>
    <p>
        <button onclick="location.href='${cpath}/admin'" class="btn btn-sm btn-success">관리자페이지(관리자만)</button>
        <button onclick="location.href='${cpath}/user'" class="btn btn-sm btn-info">유저페이지(유저만)</button>
    </p>
    <hr/>
    <form action="${cpath}/logout">
        <button class="btn btn-sm btn-danger btn-block" type="submit" id="logoutbtn">로그아웃</button>
    </form>

</div>
</body>
</html>