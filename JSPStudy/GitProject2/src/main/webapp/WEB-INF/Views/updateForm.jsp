<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Plus Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet"
	href="assets/vendors/jquery-bar-rating/css-stars.css" />
<link rel="stylesheet"
	href="assets/vendors/font-awesome/css/font-awesome.min.css" />
<!-- End plugin css for this page -->
<!-- inject:css -->
<!-- endinject -->
<!-- Layout styles -->
<link rel="stylesheet" href="assets/css/demo_1/style.css" />
<!-- End layout styles -->
<link rel="shortcut icon" href="assets/images/favicon.png" />
<!-- my health style -->
<link rel="stylesheet" href="assets/css/demo_1/myhealth.css" />


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">



<style>
.content-wrapper .row {
	margin-bottom: 10px;
}

.comp {
	margin-top: 20px;
	justify-content: center;
	display: flex;
}

.image-col {
	display: flex;
}

.mem_img_size {
	width: 100px;
	height: auto;
}

.image-container {
	display: flex;
	flex-wrap: wrap;
}

.image-item {
	margin-right: 10px; /* 이미지 간 간격 조정 */
	margin-bottom: 20px; /* 이미지 아래 여백 조정 */
}

.image-item img {
	display: block;
	max-width: 100%;
	height: auto;
}
</style>




</head>

<body>
	<div class="container-scroller">


		<!-- partial:partials/_sidebar.html -->
		<nav class="sidebar sidebar-offcanvas" id="sidebar">
			<ul class="nav">
				<li class="nav-item nav-profile border-bottom"><a href="#"
					class="nav-link flex-column">
						<div class="nav-profile-image">
							<img src="${member.mem_img}" alt="profile" />
							<!--change to offline or busy as needed-->
						</div>
						<div class="nav-profile-text d-flex ms-0 mb-3 flex-column">
							<span class="font-weight-semibold mb-1 mt-2 text-center">${member.mem_name}</span>
							<span class="text-secondary icon-sm text-center">${member.mem_nick}</span>
						</div>
				</a></li>
				<li class="nav-item pt-3"><a class="nav-link d-block"
					href="MainPage.do"> <img class="sidebar-brand-logo"
						src="assets/images/logo.png" alt="" /> <img
						class="sidebar-brand-logomini" src="assets/images/logo-mini.png"
						alt="" />
						<div class="small font-weight-light pt-1">fitness responsive
							web design</div>
				</a>
					<form class="d-flex align-items-center" action="#"></form></li>



				<li class="pt-2 pb-1"><span class="nav-item-head">MENU</span></li>



				<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
				<!--*** side nar > nav >  사용자 Menu start ***-->
				<li class="nav-item"><a class="nav-link" href="MainPage.do">
						<i class="mdi mdi-compass-outline menu-icon"></i> <span
						class="menu-title">나의운동정보</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="ComparePage.do">
						<i class="mdi mdi-chart-bar menu-icon"></i> <span
						class="menu-title">나의운동비교</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="InputPage.do">
						<i class="mdi mdi-check-circle menu-icon"></i> <span
						class="menu-title">나의운동입력</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="ReservePage.do">
						<i class="mdi mdi-comment-account-outline menu-icon"></i> <span
						class="menu-title">나의운동예약</span>
				</a></li>
				<!--*** 사용자 Menu end ***-->
				<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->

			</ul>
		</nav>


		<!-- ** SIDE BAR SECTION END ** -->
		<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->


		<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		<!-- ** TOP BAR SECTION ** -->

		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<div id="settings-trigger">
				<i class="mdi mdi-settings"></i>
			</div>
			<div id="theme-settings" class="settings-panel">
				<i class="settings-close mdi mdi-close"></i>
				<p class="settings-heading">SIDEBAR SKINS</p>
				<div class="sidebar-bg-options selected" id="sidebar-default-theme">
					<div class="img-ss rounded-circle bg-light border me-3"></div>
					Default
				</div>
				<div class="sidebar-bg-options" id="sidebar-dark-theme">
					<div class="img-ss rounded-circle bg-dark border me-3"></div>
					Dark
				</div>
				<p class="settings-heading mt-2">HEADER SKINS</p>
				<div class="color-tiles mx-0 px-4">
					<div class="tiles default primary"></div>
					<div class="tiles success"></div>
					<div class="tiles warning"></div>
					<div class="tiles danger"></div>
					<div class="tiles info"></div>
					<div class="tiles dark"></div>
					<div class="tiles light"></div>
				</div>
			</div>
			<!-- partial -->
			<!-- partial:partials/_navbar.html -->
			<nav
				class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
				<div class="navbar-menu-wrapper d-flex align-items-stretch">
					<button class="navbar-toggler navbar-toggler align-self-center"
						type="button" data-toggle="minimize">
						<span class="mdi mdi-chevron-double-left"></span>
					</button>
					<div
						class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
						<a class="navbar-brand brand-logo-mini" href="MainPage.do"><img
							src="assets/images/logo-mini.png" alt="logo" /></a>
					</div>

					<ul class="navbar-nav navbar-nav-right">

						<li class="nav-item nav-profile dropdown d-none d-md-block">
							<a class="nav-link dropdown-toggle" id="profileDropdown" href="#"
							data-bs-toggle="dropdown" aria-expanded="false">
								<div class="nav-profile-text">MYPAGE</div>
						</a>
							<div class="dropdown-menu center navbar-dropdown"
								aria-labelledby="profileDropdown">
								<a class="dropdown-item" href="UpdatePage.do"> <i
									class="mdi mdi-account-circle me-3"></i> 회원정보수정
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="InputPage.do"> <i
									class="mdi mdi-check-circle me-3"></i> 나의운동입력
								</a>
								<!-- 변경부분 -->
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="WeightPage.do"> <i
									class="mdi mdi-poll-box me-3"></i> 나의체중입력
								</a>
								<!-- 변경부분 -->
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="Logout.do"> <i
									class="mdi mdi-logout-variant me-3"></i> 로그아웃
								</a>
								<div class="dropdown-divider"></div>
						</li>
						<li class="nav-item nav-logout d-none d-lg-block"><a
							class="nav-link" href="MainPage.do"> <i
								class="mdi mdi-home-circle"></i>
						</a></li>
					</ul>
					<button
						class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
						type="button" data-toggle="offcanvas">
						<span class="mdi mdi-menu"></span>
					</button>
				</div>
			</nav>

			<!-- ** TOP BAR SECTION END ** -->
			<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->





			<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ** Main Area START ** -->


			<!-- main-panel partial  복사시작 복사시작 -->
			<div class="main-panel">
				<div class="content-wrapper ">
					<div class="page-header">
						<h2 class="page-title">개인정보 수정</h2>
						<nav aria-label="breadcrumb">
							<!--
              <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="#">Forms</a></li>
              <li class="breadcrumb-item active" aria-current="page"> Form elements </li>
            </ol>
          -->
						</nav>
					</div>
					<div class="row">
						<!--프로필 수정에 대한 정보-->
						<form class="forms-sample" action="Update.do" method="post"
							name="profileForm" onsubmit="return validateForm()">
							<!--개인정보 수정에 대한 정보-->
							<div class="col-md-12 grid-margin stretch-card">
								<div class="card">
									<div class="card-body">


										<div class="form-group row">
											<label for="exampleNikname" class="col-sm-3 col-form-label">프로필사진</label>
											<div class="col-sm-9 image-col">
												<div class="image-item">
													<img class="mem_img_size" alt=""
														src="assets/images/mem_img/img1.jpg"> <input
														type="radio" name="mem_img"
														value="assets/images/mem_img/img1.jpg" id="img1">
													<label for="img1">기본</label>
												</div>
												<div class="image-item">
													<img class="mem_img_size" alt=""
														src="assets/images/mem_img/img2.jpg"> <input
														type="radio" name="mem_img"
														value="assets/images/mem_img/img2.jpg" id="img2">
													<label for="img2">냥인간</label>
												</div>
												<div class="image-item">
													<img class="mem_img_size" alt=""
														src="assets/images/mem_img/img3.jpg"> <input
														type="radio" name="mem_img"
														value="assets/images/mem_img/img3.jpg" id="img3">
													<label for="img3">수컷</label>
												</div>
												<div class="image-item">
													<img class="mem_img_size" alt=""
														src="assets/images/mem_img/img4.jpg"> <input
														type="radio" name="mem_img"
														value="assets/images/mem_img/img4.jpg" id="img4">
													<label for="img4">암컷</label>
												</div>
												<div class="image-item">
													<img class="mem_img_size" alt=""
														src="assets/images/mem_img/img5.jpg"> <input
														type="radio" name="mem_img"
														value="assets/images/mem_img/img5.jpg" id="img5">
													<label for="img5">몸짱</label>
												</div>
												<div class="image-item">
													<img class="mem_img_size" alt=""
														src="assets/images/mem_img/img6.jpg"> <input
														type="radio" name="mem_img"
														value="assets/images/mem_img/img6.jpg" id="img6">
													<label for="img6">기본몸짱</label>
												</div>
											</div>
										</div>

										<!-- 닉네임 변경 -->

										<div class="form-group row">
											<label for="exampleNikname" class="col-sm-3 col-form-label">별명</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="exampleInputPassword2" placeholder="변경할 별명을 입력해 주세요."
													name="mem_nick" />
											</div>
										</div>

										<!-- 비밀번호-->
										<div class="form-group row">
											<label for="exampleInputPassword2"
												class="col-sm-3 col-form-label">비밀번호</label>
											<div class="col-sm-9">
												<input type="password" class="form-control"
													id="exampleInputPassword2" placeholder="현재 비밀번호를 입력해 주세요."
													name="mem_pw" />
											</div>
										</div>
										<!--================================비밀번호===========================-->

										<!-- 비밀번호 재설정-->
										<div class="form-group row">
											<label for="exampleInputConfirmPassword2"
												class="col-sm-3 col-form-label">비밀번호 변경</label>
											<div class="col-sm-9">
												<input type="password" class="form-control" name="mem_newpw"
													id="exampleInputConfirmPassword2"
													placeholder="변경할 비밀번호를 입력해 주세요." />
											</div>
										</div>
										<!--=============================비밀번호 재설정=======================-->
										<!--주소 변경-->
										<div class="form-group row">
											<label for="exampleChangeAddress"
												class="col-sm-3 col-form-label">주소 변경</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="mem_addr"
													id="exampleChangeAddress" placeholder="변경할 주소를 입력해 주세요." />
											</div>
										</div>
										<!-- ===========================주소변경=========================-->

										<!--이메일 변경-->
										<div class="form-group row">
											<label for="exampleChangeEmail"
												class="col-sm-3 col-form-label">이메일 변경</label>
											<div class="col-sm-9">
												<input type="email" class="form-control" name="mem_email"
													id="exampleChangeEmail" placeholder="변경할 이메일을 입력해 주세요." />
											</div>
										</div>
										<!-- ===========================이메일 변경=========================-->


										<div class="comp">
											<button type="submit" class="btn btn-primary me-2">수정</button>
											<button type="reset" class="btn btn-light">취소</button>
										</div>
									</div>
								</div>
							</div>
						</form>


						<!-- 회원탈퇴 영역-->
						<form id="unregisterForm" action="Unregister.do" method="post">
							<div class="col-12 grid-margin stretch-card">
								<div class="card">
									<div class="card-body bye-body">
										<div
											class="d-flex justify-content-between align-items-center w-100">
											<h4 class="card-title bye-card">회원탈퇴</h4>
											<button id="confirmUnregister" type="button"
												class="btn btn-primary bye-btn">탈퇴하기</button>
										</div>
									</div>
								</div>
							</div>
						</form>


					</div>
				</div>
				<!-- content-wrapper ends -->





				<!-- ** Main Area END ** -->
				<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->



				<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
				<!-- ** Footer Area START ** -->



				<!-- partial:partials/_footer.html -->
				<footer class="footer">
					<div
						class="d-sm-flex justify-content-center justify-content-sm-between">
						<span
							class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright
							© 2024 <a target="_blank">Fitneeds</a>. All rights reserved.
						</span> <span
							class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">
							Fitneeds team & smhrd <i class="mdi mdi-heart text-danger"></i>
						</span>
					</div>
				</footer>
				<!-- partial -->



				<!-- ** Footer Area END ** -->
				<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->



			</div>
			<!-- 작업영역 : main-panel ends 복사끝복사끝 -->
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
		<!-- container-scroller -->



		<!-- plugins:js -->
		<script src="assets/vendors/js/vendor.bundle.base.js"></script>
		<!-- endinject -->
		<!-- Plugin js for this page -->
		<script src="assets/vendors/jquery-bar-rating/jquery.barrating.min.js"></script>
		<script src="assets/vendors/chart.js/Chart.min.js"></script>
		<script src="assets/vendors/flot/jquery.flot.js"></script>
		<script src="assets/vendors/flot/jquery.flot.resize.js"></script>
		<script src="assets/vendors/flot/jquery.flot.categories.js"></script>
		<script src="assets/vendors/flot/jquery.flot.fillbetween.js"></script>
		<script src="assets/vendors/flot/jquery.flot.stack.js"></script>
		<script src="assets/js/jquery.cookie.js" type="text/javascript"></script>
		<!-- End plugin js for this page -->
		<!-- inject:js -->
		<script src="assets/js/off-canvas.js"></script>
		<script src="assets/js/hoverable-collapse.js"></script>
		<script src="assets/js/misc.js"></script>
		<script src="assets/js/settings.js"></script>
		<script src="assets/js/todolist.js"></script>
		<!-- endinject -->
		<!-- Custom js for this page -->
		<script src="assets/js/dashboard.js"></script>
		<script src="assets/js/check_update.js"></script>
		<script src="assets/js/check_delete.js"></script>
		<!-- End custom js for this page -->
</body>
</html>