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
    <title>로그인</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <form action="${cpath}/login-process" class="form-signin" method="post">
        <p class="text-center">
            <img src="${cpath}/images/me.jpg" class="img-thumbnail" style="width: 400px; height: 300px" alt="글이 보인다면 시큐리티 설정 잘못한거임!">
        </p>
        <h2 class="form-signin-heading text-center mb-5">💚빅데이터반💚</h2>

        <p>
            <label for="username" class="sr-only">아이디</label>
            <input name="userid" type="text" id="username"class="form-control" placeholder="아이디">
        </p>
        <p>
            <label for="password" class="sr-only">비밀번호</label>
            <input name="pw" type="password" id="password" class="form-control" placeholder="비밀번호" >
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="loginbtn">로그인</button>
    </form>

    <form action="${cpath}/join" class="form-signin" method="get">
        <button class="btn btn-lg btn-warning btn-block" type="submit">회원가입하기</button>
    </form>

</div>
</body>
</html>