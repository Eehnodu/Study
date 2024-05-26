<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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



<!-- ******************** CSS 작업가능 영역 START *************************-->

<!-- *******************************  CSS Link 작업영역 START *******************************  -->


<!-- CSS 수정영역 -->
<link rel="stylesheet"
	href="1assets/css/demo_1/reserv/bootstrap.min.css">

<link rel="stylesheet"
	href="assets/css/demo_1/reserv/bootstrap-icons.css">

<link rel="stylesheet"
	href="assets/css/demo_1/reserv/owl.carousel.min.css">

<link rel="stylesheet"
	href="assets/css/demo_1/reserv/owl.theme.default.min.css">

<link href="assets/css/demo_1/reserv/templatemo-pod-talk.css"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap"
	rel="stylesheet">



<!-- *******************************  CSS Link 작업영역 END  ******************************* -->












<!-- ********************  CSS 작업가능 영역 END *************************-->
<style>
#my_modal {
	position: relative; /* 모달 내부의 상대적인 위치 설정 */
	display: none;
	width: 650px;
	height: 900px;
	padding: 20px 60px;
	background-color: #fefefe;
	border: 3px solid #333333;
	border-radius: 10px;
}

#my_modal .modal_close_btn {
	position: absolute;
	top: 10px;
	right: 10px;
	color: #333333;
}

.scrollable-section {
	overflow: auto;
	max-height: 300px;
}

#reservation_section {
	border: 3px solid #333333;
	padding: 10px;
	border-radius: 5px;
}

#vc_border {
	border: 3px solid #333333;
	padding: 10px;
	border-radius: 5px;
}

#vc_price_modal, #rsv_date {
	border: 3px solid #333333; /* 테두리 추가 */
	padding: 10px; /* 내부 여백 설정 */
	border-radius: 5px; /* 테두리 모서리를 둥글게 만듭니다. */
}

.custom-block {
	border: 2px solid #333333
}

#buy {
	margin-left: 410px;
	background-color: #D6D6D6;
}

#reserve_button {
	margin-left: 410px;
}
</style>
















</head>

<body>

	<div id="my_modal">

		<div id="vc_border">
			<h2 id="modal"></h2>
			<br>
			<p id="vc_price_modal"></p>
			<br> <br> <span id="total_price">
		</div>
		</span><span id="buy"></span> <br> <br>
		<div id="reservation_section" class="scrollable-section">
			<h2>PT 예약</h2>
			<br>
			<p id='rsv_date'></p>
			<p id='rsv_date_commit'></p>
			<input type='hidden' id="pt_commit" name='pt_commit'> <input
				type='hidden' id="pt_status"> <a class="modal_close_btn">X</a>
		</div>

		<button id="reserve_button" name='pt_commit' class="custom-btn btn-16">예약하기</button>

	</div>
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ** SIDE BAR SECTION ** -->

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
				<li class="pt-2 pb-1"><span class="nav-item-head">MENU
						</MENU>
				</span></li>



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



			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper pb-0">



					<div class="content-wrapper">
						<div class="row">

							<div class="card1 ">
								<div class="">

									<section class="hero-section">
										<div class="container">
											<div class="row">

												<div class="col-lg-12 col-12">

													<div class="owl-carousel owl-theme">


														<c:forEach var="trainer" items="${trainer_info}">
															<c:if test="${trainer.trn_name != null}">

																<div class="owl-carousel-info-wrap item"
																	id="selectTrainer">
																	<img src="${trainer.trn_img}"
																		class="owl-carousel-image img-fluid" alt="">
																	<div class="owl-carousel-info">
																		<h4>${trainer.trn_name}</h4>
																		<span class="btn btn-outline-primary btn-fw">
																			#헬스 </span> <span class="btn btn-outline-danger btn-fw">
																			${trainer.trn_info} </span>
																	</div>
																</div>
															</c:if>
														</c:forEach>







													</div>
												</div>
											</div>
										</div>
									</section>
								</div>
							</div>

							<!-- Slide end -->

							<div id="placeholder_div" class="container text-center mt-5">
								<div class="border p-4">
									<h4 class="mb-4">트레이너를 선택해주세요</h4>
									<h5>트레이너 정보, 예약 섹션입니다.</h5>
								</div>
							</div>


							<!-- 예약권 START -->

							<section class="latest-podcast-section section-padding pb-0"
								id="section_2">
								<div class="container">
									<div class="row justify-content-center">

										<div class="col-lg-12 col-12">
											<div class="section-title-wrap mb-5">
												<h4 class="section-title">트레이너 상세정보</h4>
											</div>
										</div>

										<div class="col-lg-6 col-12 mb-4 mb-lg-0">
											<div class="custom-block d-flex">
												<div>
													<div class="custom-block-icon-wrap">
														<div class="section-overlay"></div>



													</div>
												</div>

												<div class="custom-block-info">
													<h5 class="mb-2"></h5>

													<div class="profile-block d-flex">




														<div>

															<p id="get_trn" class="rev_font"></p>
															<p id="trn_phone" class="rev_font"></p>
															<p id="trn_info" class="rev_font"></p>
															<p id="trn_career" class="rev_font"></p>
															<input type='hidden' id="trn_idx">
														</div>
													</div>


												</div>
											</div>
										</div>


										<div class="col-lg-6 col-12 mb-4 mb-lg-0">
											<div class="custom-block d-flex">
												<div>
													<div class="custom-block-icon-wrap">
														<div class="section-overlay"></div>



													</div>
												</div>

												<div class="custom-block-info">
													<h5 class="mb-2"></h5>

													<div class="profile-block d-flex">




														<div>

															<p id="center_name" class="rev_font"></p>
															<p id="center_tel" class="rev_font"></p>
															<p id="center_addr" class="rev_font"></p>
															<p id="vc_price" class="rev_font"></p>
															<button id="popup_open_btn">이용권 구매하기</button>

														</div>
													</div>


												</div>
											</div>
										</div>
									</div>
								</div>





							</section>




							<!-- 예약권 END -->






							<!-- ******************** HTML 작업가능 영역 END *************************-->
							<!-- ******************** HTML 작업가능 영역 END *************************-->




						</div>
					</div>

					<input type="hidden" name="get_vc_idx" id="get_vc_idx">

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
					<!-- partial -->
				</div>
				<!-- main-panel ends -->
			</div>
			<!-- page-body-wrapper ends -->
		</div>
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
		<!-- End custom js for this page -->


		<!-- ******************** JS 작업가능 영역 START *************************-->
		<!--  *******************************  JS작업영역 START *******************************  -->
		<script src="assets/js/reserv/jquery.min.js"></script>
		<script src="assets/js/reserv/owl.carousel.min.js"></script>
		<script src="assets/js/reserv/custom.js"></script>
		<script src="assets/js/rsv.js"></script>
		<script src="assets/js/fitcenterinfo.js"></script>
		<script src="assets/js/voucher.js"></script>
		<script>
			function modal(id) {
				var zIndex = 9999;
				var modal = document.getElementById(id);

				// 모달 div 뒤에 희끄무레한 레이어
				var bg = document.createElement('div');
				bg.setStyle({
					position : 'fixed',
					zIndex : zIndex,
					left : '0px',
					top : '0px',
					width : '100%',
					height : '100%',
					overflow : 'auto',
					// 레이어 색갈은 여기서 바꾸면 됨
					backgroundColor : 'rgba(0,0,0,0.4)'
				});
				document.body.append(bg);

				// 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
				modal.querySelector('.modal_close_btn').addEventListener(
						'click', function() {
							bg.remove();
							modal.style.display = 'none';
						});

				modal.setStyle({
					position : 'fixed',
					display : 'block',
					boxShadow : '0 2px 3px 0 rgba(34,36,38,0.15)',

					// 시꺼먼 레이어 보다 한칸 위에 보이기
					zIndex : zIndex + 1,

					// div center 정렬
					top : '50%',
					left : '50%',
					transform : 'translate(-50%, -50%)',
					msTransform : 'translate(-50%, -50%)',
					webkitTransform : 'translate(-50%, -50%)'
				});
			}

			// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
			Element.prototype.setStyle = function(styles) {
				for ( var k in styles)
					this.style[k] = styles[k];
				return this;
			};

			document.getElementById('popup_open_btn').addEventListener('click',
					function() {
						// 모달창 띄우기
						modal('my_modal');
					});
		</script>
		<script>
			// 클릭 시 트레이너 섹션을 보여주는 함수
			function showTrainerSection() {
				var section = document.getElementById('section_2');
				var placeholderDiv = document.getElementById('placeholder_div');
				section.style.display = 'block';
				placeholderDiv.style.display = 'none';
			}

			// 트레이너를 선택하는 요소 클릭 시 트레이너 섹션을 보여주고 기본 문구를 숨김
			var trainerElements = document
					.querySelectorAll('.owl-carousel-info-wrap.item');
			trainerElements.forEach(function(element) {
				element.addEventListener('click', function() {
					showTrainerSection();
					var placeholderDiv = document
							.getElementById('placeholder_div');
					placeholderDiv.style.display = 'none';
				});
			});

			// 페이지 로드 시 기본적으로 트레이너를 선택해주세요 문구를 보여줌
			document.addEventListener('DOMContentLoaded',
					function() {
						var section = document.getElementById('section_2');
						var placeholderDiv = document
								.getElementById('placeholder_div');
						section.style.display = 'none';
						placeholderDiv.style.display = 'block';
					});
		</script>



		<!--  *******************************  JS작업영역 END *******************************  -->
		<!-- ******************** JS 작업가능 영역 END *************************-->
</body>

</html>