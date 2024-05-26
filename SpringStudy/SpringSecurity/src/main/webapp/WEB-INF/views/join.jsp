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
    <title>회원가입</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <form action="${cpath}/join-process" class="form-signin" id='joinform' method="post">
        <h2 class="form-signin-heading text-center mb-5">💚회원가입💚</h2>

        <p>
            <label for="username" class="sr-only">아이디</label>
            <input name="userid" type="text" id="username" class="form-control" placeholder="아이디" >
        </p>
        <p>
            <label for="password" class="sr-only">비밀번호</label>
            <input name="pw" type="password" id="password" class="form-control" placeholder="비밀번호" >
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
    </form>

</div>
</body>
</html>