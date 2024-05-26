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
<!-- plugins:css -->
<link rel="stylesheet"
	href="assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<!-- End Plugin css for this page -->
<!-- inject:css -->
<!-- endinject -->
<!-- Layout styles -->
<link rel="stylesheet" href="assets/css/demo_1/style.css" />
<link rel="stylesheet" href="assets/css/demo_1/join/chartjs.css" />
<!-- End layout styles -->
<style>

.card-img{
width: 100%;
}

</style>



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
							</div>
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
			<!-- ** Main Area Start ** -->

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<!--  1행 시작 -->
					<div class="row">
							<!--  1행 시작 -->
					<div class="row">
						<!-- 1행 1열 -->
                  <div class="col-lg-8 grid-margin stretch-card">
                     <div class="card">
                        <div class="card-body">
                           <div class="row">
                              <!-- 왼쪽에 차트 배치 -->
                              <div class="col-md-7">
                                 <h4 class="card-title"><strong class="chaname">표준데이터 비교</strong></h4>
                                 <canvas id="barChart"></canvas>
                              </div>
                              <!-- 오른쪽에 표 배치 -->
                              <div class="col-md-4 d-flex flex-column">
                                 <table class="table">
                                    <thead>
                                       <tr>
                                          <th scope="col"><strong class="chaname">개인 데이터</strong></th>
                                          <th scope="col"><strong class="chaname">표준 데이터</strong></th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                       <tr>
                                          <td id="mem_height"></td>
                                          <td id="std_height"></td>
                                       </tr>
                                       <tr>
                                          <td id="mem_weight"></td>
                                          <td id="std_weight"></td>
                                       </tr>
                                       <tr>
                                          <td id="mem_bmi"></td>
                                          <td id="std_bmi"></td>
                                       </tr>
                                       <tr>
                                          <td id="mem_muscle"></td>
                                          <td id="std_muscle"></td>
                                       </tr>
                                       <tr>
                                          <td id="mem_fat_per"></td>
                                          <td id="std_fat_per"></td>
                                       </tr>
                                    </tbody>
                                 </table>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
						<!-- 1행 2열 -->
						<div class="col-lg-4 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title"><strong class="chaname">radar 차트로 비교</strong></h4>
										<canvas id="radarChart">
									</canvas>
								</div>
							</div>
						</div>
					</div>
					<!--  1행 끝 -->
					
					
					<!-- 사용자 다이어트,뉴스,루틴 추천 -->
					 <!-- 2행 1열 -->
               <div class="row">
                  <div class="col-lg-4 grid-margin stretch-card">
                     <div class="card">
                        <div class="card-body" id="diet" style="width: 100%; height:100%; object-fit: cover;">
                           <h2>Diet</h2>
                           <a href="#" id="dietLink">
                              <h4 class="card-title " id="dietTitle">Title</h4> 
                              <img src="" alt="Diet Image" id="dietImage" class="charimg" class="charimg img-fluid" style="max-width: 100%; height: auto;">
                </a>
                           </a>
                           <canvas id="barChart" style="height: 250px;"></canvas>
                        </div>
                     </div>
                  </div>

						<!-- 2행  2열 -->
						<div class="col-lg-4 grid-margin stretch-card">
							<div class="card">
								<div class="card-body" id="news" style="width: 100%; height:100%; object-fit: cover;">
									<h2>News</h2>
									<a href="#" id="newsLink">
										<h4 class="card-title " id="newsTitle">Title</h4> <img src=""
										alt="News Image" id="newsImage" class="charimg img-fluid" style="max-width: 100%; height: auto;">
                </a>
									</a>
									<canvas id="barChart" style="height: 250px;"></canvas>
								</div>
							</div>
						</div>

						<!-- 2행 3열 -->
						<div class="col-lg-4 grid-margin stretch-card">
							<div class="card">
								<div class="card-body " id="routine" style="width: 100%; height:100%; object-fit: cover;">
									<h2>Routine</h2>
									<a href="#" id="routineLink">
										<h4 class="card-title" id="routineTitle">Title</h4> 
										<img
										src="" alt="Routine Image" id="routineImage"  class="charimg img-fluid" style="max-width: 100%; height: auto;">
									</a>
									<canvas id="barChart" style="height: 250px;"></canvas>
								</div>
							</div>
						</div>
					</div>
					<!-- 사용자 다이어트,뉴스,루틴 추천 끝-->

				</div>
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
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>












	<!-- ** All AREA END ** -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->






	<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ** JS AREA START ** -->

	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script src="assets/vendors/chart.js/Chart.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="assets/js/off-canvas.js"></script>
	<script src="assets/js/hoverable-collapse.js"></script>
	<script src="assets/js/misc.js"></script>
	<script src="assets/js/settings.js"></script>
	<script src="assets/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/chart.js"></script>
	<!-- End custom js for this page -->

	<!-- ** JS AREA START ** -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- flask에서 url받아오기-->
	<script type="text/javascript">
      // diet 정보 요청
      fetch('http://127.0.0.1:5000/diet')
        .then(response => response.json())
        .then(data => {
          console.log(data)
          document.getElementById('dietLink').href = data.url;
          document.getElementById('dietImage').src = data.thumb_url;
          document.getElementById('dietTitle').textContent = data.title;
        });

      // news 정보 요청
      fetch('http://127.0.0.1:5000/news')
        .then(response => response.json())
        .then(data => {
          console.log(data)
          document.getElementById('newsLink').href = data.url;
          document.getElementById('newsImage').src = data.thumb_url;
          document.getElementById('newsTitle').textContent = data.title;
        });

      // routine 정보 요청
      fetch('http://127.0.0.1:5000/routine')
        .then(response => response.json())
        .then(data => {
          console.log(data)
          document.getElementById('routineLink').href = data.url;
          document.getElementById('routineImage').src = data.thumb_url;
          document.getElementById('routineTitle').textContent = data.title;
        });
      
      
    </script>






</body>
</html>