<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.math.BigInteger"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr/dist/l10n/ko.js"></script>


<title>ChariTeam - Free Nonprofit Website Template</title>
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&family=Saira:wght@500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">


<!-- Libraries Stylesheet -->
<link href="assets/lib/join/animate.min.css" rel="stylesheet">


<!-- Customized Bootstrap Stylesheet -->
<link href="assets/css/demo_1/join/bootstrap.min.css" rel="stylesheet">


<!-- Template Stylesheet -->
<link href="assets/css/demo_1/join/style.css" rel="stylesheet">

<!-- ** 달력CSS START-->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="assets/css/demo_1/calendar.css" />
<!-- ** 달력CSS END-->


<!-- background #fff 변경 -->
<link href="assets/css/demo_1/signup/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/demo_1/signup/style.css" rel="stylesheet">
<link href="assets/css/demo_1/signup/animate.min.css" rel="stylesheet">





</head>

<body>
	<%
	String clientId = "gbLrG9lQfNuwCCfz4nge";//애플리케이션 클라이언트 아이디값";
	String redirectURI = URLEncoder.encode("http://localhost:8080/GitProject/fitcallback.do", "UTF-8");
	SecureRandom random = new SecureRandom();
	String state = new BigInteger(130, random).toString();
	String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code" + "&client_id=" + clientId
			+ "&redirect_uri=" + redirectURI + "&state=" + state;
	session.setAttribute("state", state);
	
	%>
	<!-- Carousel Start -->
	<div class="container-fluid p-0 mb-5">
		<div id="header-carousel" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">



				<!-- 로그인 START -->
				<div class="carousel-item active" id="carousel-login">
					<img class="w-100" src="assets/images/join/carousel-bg.jpg"
						alt="Image">
					<div class="carousel-caption">
						<div class="container">
							<form class="join-form" action="Login.do" method="post">
								<div class="row justify-content-center">
									<div class="col-lg-7 pt-5">
										<h1 class="display-4 text-white mb-3 animated slideInDown">Login</h1>
										<p class="fs-5 text-white-50 mb-5 animated slideInDown">Fitneeds
											로그인을 해볼까요 :)</p>

										<!-- 로그인 START -->
										<div class="row g-3">
											<div class="col-12">
												<div class="form-floating">
													<input type="text" class="form-control bg-light border-0"
														id="mem_id" name="mem_id" placeholder="Your Name">
													<label>아이디</label>

												</div>
											</div>
											<div class="col-12">
												<div class="form-floating">
													<input type="password" class="form-control bg-light border-0"
														id="mem_pw" name="mem_pw" placeholder="Your Email">
													<label>비밀번호</label>
												</div>
											</div>
										</div>

										<!-- 로그인input END -->

									
											<!-- naverButton -->
											<a href="<%=apiURL%>"	class="btn animated slideInDown">
											<img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>




										<button type="submit" id="login-form-submit"
											class="btn btn-primary py-2 px-3 animated slideInDown"
											href="#">
											로그인
											<div
												class="d-inline-flex btn-sm-square bg-white text-primary rounded-circle ms-2">
												<i class="fa fa-check"></i>
											</div>
										</button>
							</form>
							<a
								class="btn btn-primary py-2 px-3 animated slideInDown carousel-control-next"
								type="button" data-bs-target="#header-carousel"
								data-bs-slide="next" disabled> 회원가입
								<div
									class="d-inline-flex btn-sm-square bg-white text-primary rounded-circle ms-2">
									<i class="fa fa-arrow-right"></i>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>






		<!-- ////////////////////////////////////////////////////// page1 start ////////////////////////////////////////////////////////////////////  -->

		<div class="carousel-item second" id="carousel-first">
			<img class="w-100" src="assets/images/join/carousel-bg.jpg"
				alt="Image">
			<div class="carousel-caption active">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7 pt-5">
							<h1 class="display-4 text-white mb-3 animated slideInDown">Sign
								up</h1>
							<p class="fs-5 text-white-50 mb-5 animated slideInDown">Fitneeds
								회원가입을 도와드릴게요 :)</p>
							<div>
								<div class="row g-3">
									<div class="col-12">
										<form class="join-form" action="Join.do" method="post" onsubmit="showSuccessAlert()">
											<div class="form-floating">
												<input type="text" class="form-control bg-light border-0" id="mem_id"
													name="mem_id" placeholder="아이디를 입력해 주세요."> <label>아이디</label>

											</div>
									</div>
									<div class="col-12">
										<div class="form-floating">
											<input type="text" class="form-control bg-light border-0"
												id="mem_pw" name="mem_pw" placeholder="Your Email">
											<label for="email">비밀번호</label>
										</div>
									</div>

									<div class="col-12">
										<div class="form-floating">
											<input type="text" class="form-control bg-light border-0"
												id="mem_nick" name="mem_nick" placeholder="Your Email">
											<label for="email">닉네임</label>
										</div>
									</div>
								</div>
							</div>
							<a
								class="btn btn-primary py-2 px-3 animated slideInDown carousel-control-prev"
								type="button" data-bs-target="#header-carousel"
								data-bs-slide="prev">
								<div
									class="d-inline-flex btn-sm-square bg-white text-primary rounded-circle ms-2">
									<i class="fa fa-arrow-left"></i>
								</div> 로그인
							</a> <a
								class="btn btn-primary py-2 px-3 animated slideInDown carousel-control-next"
								type="button" data-bs-target="#header-carousel" id="1st-next"
								data-bs-slide="next" disabled> Next Step
								<div
									class="d-inline-flex btn-sm-square bg-white text-primary rounded-circle ms-2">
									<i class="fa fa-arrow-right"></i>
								</div>
							</a>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ////////////////////////////////////////////////////// page1 end ////////////////////////////////////////////////////////////////////  -->

		<!-- page2 start -->
		<div class="carousel-item second">
			<img class="w-100" src="assets/images/join/carousel-bg.jpg"
				alt="Image">
			<div class="carousel-caption active">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7 pt-5">
							<h1 class="display-4 text-white mb-3 animated slideInDown">총
								3단계로 구성되어 있어요!</h1>
							<p class="fs-5 text-white-50 mb-5 animated slideInDown">회원가입에
								필요한 기본정보입력 해주세요.</p>
							<div>

								<div class="row g-3">
									<div class="col-12">
										<div class="form-floating">
											<input type="text" class="form-control bg-light border-0"
												id="mem_name" placeholder="" name="mem_name" required value="${name}"> <label
												for="name" >이름</label>
										</div>
									</div>
							<div class="col-12">
										<div class="form-floating" id="divBirthday">
											<input type="text"
												class="input form-control bg-light border-0"
												id="exampleInputDate" placeholder="생년월일"
												 maxlength="10"
												name="mem_birthdate"  value="${birthyear}-${birthday}"> <label for="text">생년월일</label>
										</div>
									</div>

									<div class="col-12">
										<div class="form-floating">
											<input type="text" class="form-control bg-light border-0" id="mem_addr"
												placeholder="주소를 입력해 주세요" name="mem_addr" required>
											<label>주소</label>
										</div>
									</div>


									<div class="col-12">
										<div class="form-floating" >
											<input type="text" class="form-control bg-light border-0" id="mem_phone"
											 placeholder="핸드폰번호" name="mem_phone" value="${mobile}"> 
											 <label for="text">핸드폰번호</label>
										</div>
									</div>

									<div class="col-12">
										<div class="form-floating">
											<input type="text" class="form-control bg-light border-0" id="mem_email"
												placeholder="이메일" name="mem_email" value="${email}">
											<label>이메일</label>
										</div>
									</div>
								</div>
							</div>
							<a
								class="btn btn-primary py-2 px-3 animated slideInDown carousel-control-prev"
								type="button" data-bs-target="#header-carousel"
								data-bs-slide="prev">
								<div
									class="d-inline-flex btn-sm-square bg-white text-primary rounded-circle ms-2">
									<i class="fa fa-arrow-left"></i>
								</div> Prev Step
							</a> <a
								class="btn btn-primary py-2 px-3 animated slideInDown carousel-control-next"
								type="button" data-bs-target="#header-carousel" id="2nd-next"
								data-bs-slide="next"> Next Step
								<div
									class="d-inline-flex btn-sm-square bg-white text-primary rounded-circle ms-2">
									<i class="fa fa-arrow-right"></i>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- page2 end -->

		<!-- ///////////////////////////////3page start ////////////////////////////////////////////////////////////////////////////-->
		<div class="carousel-item third">
			<img class="w-100" src="assets/images/join/carousel-bg.jpg"
				alt="Image">
			<div class="carousel-caption">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7 pt-5">
							<h1 class="display-4 text-white mb-3 animated slideInDown">마지막단계에요
								:)</h1>
							<p class="fs-5 text-white-50 mb-5 animated slideInDown">내 정보를
								입력하시면 비교데이터를 볼 수 있어요!</p>
							<div>
								<div class="row g-3">
									<div class="col-12">
										<div class="form-floating">
											<input type="text" class="form-control bg-light border-0" id="height"
												name="height" placeholder="Your Name"> <label>키</label>
										</div>
									</div>
									<div class="col-12">
										<div class="form-floating">
											<input type="text" class="form-control bg-light border-0" id="weight"
												placeholder="몸무게" name="weight"> <label>몸무게</label>
										</div>
									</div>
									<div class="col-12">
										<div class="btn-group d-flex justify-content-around">
											<input type="radio" class="btn-check" id="btnradio1"
												value="M" name="mem_gender" checked> <label
												class="btn btn-outline-dark py-3" for="btnradio1">남성</label> <input
												type="radio" class="btn-check" id="btnradio2" value="F"
												name="mem_gender"> <label class="btn btn-outline-dark py-3"
												for="btnradio2">여성</label>
										</div>
									</div>

								</div>
							</div>
							<a
								class="btn btn-primary py-2 px-3 animated slideInDown carousel-control-prev"
								type="button" data-bs-target="#header-carousel"
								data-bs-slide="prev">
								<div
									class="d-inline-flex btn-sm-square bg-white text-primary rounded-circle ms-2">
									<i class="fa fa-arrow-left"></i>
								</div> Prev Step
							</a>



							<button type="submit" id="login-form-submit"
								class="btn btn-primary py-2 px-3 animated slideInDown" href="#">
								가입완료
								<div
									class="d-inline-flex btn-sm-square bg-white text-primary rounded-circle ms-2">
									<i class="fa fa-check"></i>

								</div>
							</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- page3 end -->
	</div>
	</div>
	</div>
	<!-- Carousel End -->
	<!-- JavaScript Libraries -->
	<script src="assets/js/join/joinJs.js"></script>
	<script src="assets/js/join/bootstrap.bundle.js"></script>
	<script src="assets/js/join_success.js"></script>
	<script src="assets/js/check_login.js"></script>
	
		    <!-- calendar JS START  -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>


    <!-- html 달력-->
    <script src="assets/js/join/datepick.js"></script>

    <script>

    $(function() {
        $("#exampleInputDate").datepicker({
            dateFormat: "yy-mm-dd",
            regional: "ko", // 한글로 지역화
            yearRange: "-100:+0",
           	changeYear: true 
        });
    });
    </script>
</body>

</html>