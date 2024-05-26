<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

html {
	width: 100%;
	height: 100vh;
}

<!--
body {
	background: #333;
	width: 100%;
	text-align: center;
	font-family: -apple-system, BlinkMacSystemFont, helvetica,
		"Apple SD Gothic Neo", sans-serif;
	font-weight: 600;
	letter-spacing: 1px;
	background-size: cover;
}

-->
body {
	align-items: center;
	background-image: url("./join.jpg");
	opacity: 95%;
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: 100% 100%;
	display: grid;
	height: 100vh;
	place-items: center;
}

.panel {
	width: 450px;
	max-width: 90%;
	height: 700px;
	background-repeat: no-repeat;
	background-position: top center;
	background-size: 100% 200px;
	background-color: #f8f9fb;
	margin: 5% auto 0px;
	background: #333;
}

.shadow1 {
	-webkit-box-shadow: 0 20px 15px -15px rgba(119, 119, 119, 0.85);
	-moz-box-shadow: 0 20px 15px -15px rgba(119, 119, 119, 0.85);
	box-shadow: 0 40px 30px -30px rgba(119, 119, 119, 0.85);
}

form {
	height: 700px;
	padding: 50px;
}

.panel-switch {
	text-align: center;
	margin-top: 30px;
}

.panel-switch button {
	display: inline-block;
	width: 100px;
	height: 40px;
	background: #f03699;
	margin: 0px 10px 50px;
	border: none;
	color: #fff;
	text-transform: uppercase;
	font-weight: 600;
	letter-spacing: 2px;
	font-size: 0.8em;
	transition: background-color 0.2s, color:0.2s, opacity:0.2s;
}

.panel-switch button:active {
	background: #b52773;
	color: #c9c9c9;
}

.active-button {
	opacity: 0.5;
}

button, .button, a {
	cursor: pointer;
}

form h1 {
	color: #898787;
	font-family: 'Open Sans', sans-serif;
	text-transform: uppercase;
	font-weight: 600;
	letter-spacing: 4px;
	margin: 30px 0;
	font-size: 1.7em;
}

fieldset {
	border: none;
}

.animate1, .animate2, .animate3, .animate4 {
	-webkit-animation-duration: 2s;
	-moz-animation-duration: 2s;
}

.animate1 {
	-webkit-animation-delay: 0.2s;
	-moz-animation-delay: 0.2s;
}

.animate2 {
	-webkit-animation-delay: 0.7s;
	-moz-animation-delay: 0.7s;
}

.animate3 {
	-webkit-animation-delay: 1.1s;
	-moz-animation-delay: 1.1s;
}

.animate4 {
	-webkit-animation-delay: 1.5s;
	-moz-animation-delay: 1.5s;
}

.animate5 {
	-webkit-animation-delay: 2.2s;
	-moz-animation-delay: 2.2s;
}

@
-webkit-keyframes fadeInUp {from { opacity:0;
	-webkit-transform: translate3d(0, 100%, 0);
	transform: translate3d(0, 100%, 0);
}

to {
	opacity: 1;
	-webkit-transform: translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0);
}

}
@
keyframes fadeInUp {from { opacity:0;
	-webkit-transform: translate3d(0, 100%, 0);
	transform: translate3d(0, 100%, 0);
}

to {
	opacity: 1;
	-webkit-transform: translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0);
}

}
fieldset input {
	background: rgba(255, 255, 255, 0.2);
	border: none;
	border-radius: 5em;
	height: 20px;
	width: 80%;
	margin: 10px 0;
	padding: 5px;
	text-indent: 10px;
	color: #fff;
	font-weight: 600;
}

fieldset input::placeholder {
	color: #c7c6c6;
}

fieldset input:focus {
	outline:;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 5em;
	margin: 9px 0;
}

.login_form {
	position: relative;
	bottom: 0;
	width: 70%;
	height: 4em;
	margin-top: 150px;
	border: none;
	border-radius: 10em;
	background: #f03699;
	color: #fff;
	font-family: 'Open Sans', sans-serif;
	text-transform: uppercase;
	font-weight: 600;
	letter-spacing: 2px;
	z-index: 1;
	transition: background-color 0.2s, color:0.2s;
}

#login-form-submit:active {
	background: #b52773;
	color: #c9c9c9;
}

p, a {
	margin: 0;
	padding: 0;
}

a {
	color: #898787;
	font-size: 0.7em;
	text-decoration: none;
}

.hidden {
	display: none;
}

/*MEDIA QUERIES     */
@media all and (max-width:767px) {
	.header {
		height: 81px;
	}
}

@media all and(min-width:768px) and (max-width:1199px) {
	.header {
		height: 81px;
	}
}

@media all and (min-width:1200px) {
}

form {
	padding: 50px;
}

.panel-switch {
	margin-top: 30px;
}

.panel-switch button {
	display: inline-block;
	width: 80px;
	margin: 0px 10px 50px;
	font-weight: 600;
}
</style>



</head>
<body>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Font online-->
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">

<!--        Animate.css-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">


<link rel="stylesheet" href="main.css">

<!-- Google JQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="form.js"></script>

</head>
<body>
	<div>
		<div class="panel shadow1">
			<form class="login-form" action = "LoginService">
				<div class="panel-switch animated fadeIn">
					<button type="button" id="sign_up" class="active-button">Sign
						Up</button>
					<button type="button" id="log_in" class="" disabled>Log in</button>
				</div>
				<h1 class="animated fadeInUp animate1" id="title-login">FITNEEDS
					로그인</h1>
				<h1 class="animated fadeInUp animate1 hidden" id="title-signup">FITNEEDS
					로그인</h1>
				<fieldset id="login-fieldset">
					<input class="login animated fadeInUp animate2" class="loginfont"
						name="id" type="text" required placeholder="아이디" value="">
					<input class="login animated fadeInUp animate3" class="loginfont"
						name="pw" type="password" required placeholder="비밀번호"
						value="">
					<div class="login_find">
						<a>아이디찾기</a> <a>|</a> <a>비밀번호찾기</a> <a>|</a> <a>회원가입</a>


					</div>
				</fieldset>
				<fieldset id="signup-fieldset" class="hidden">
					<input class="login animated fadeInUp animate2" name="username"
						type="text" required placeholder="Username" value=""> <input
						class="login animated fadeInUp animate3" name="password"
						type="password" placeholder="Choose password" required value="">
				</fieldset>
				<input type="submit" id="login-form-submit"
					class="login_form button animated fadeInUp animate4" value="Log in">
				<input type="submit" id="signup-form-submit"
					class="login_form button animated fadeInUp animate4 hidden"
					value="Sign up">

			</form>
		</div>
	</div>

	<script src="join.js"></script>
</body>
</html>
</body>
</html>