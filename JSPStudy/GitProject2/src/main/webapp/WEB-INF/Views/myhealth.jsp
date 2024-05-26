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
<!-- End layout styles -->
<link rel="shortcut icon" href="assets/images/favicon.png" />

<!-- ** 달력CSS START-->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="assets/css/demo_1/calendar.css" />
<!-- ** 달력CSS END-->

<body>


		<div class="container-scroller">
		<!-- partial:partials/_sidebar.html -->
		<nav class="sidebar sidebar-offcanvas" id="sidebar">
			<ul class="nav">
				<li class="nav-item nav-profile border-bottom">
					<a href="#" class="nav-link flex-column">
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
						<div class="small font-weight-light pt-1">
						fitness responsive web design
						</div>
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
<!-- ** Main Area START ** -->




  <!-- partial 복사시작 복사시작 -->
      <div class="main-panel">
        <div class="content-wrapper pb-0">



          <!-- *********** my health form ******************* -->
          <div class="content-wrapper">
            <div class="row">
              <div class="col-md-6 grid-margin stretch-card">
                <div class="card card-exinput">
                  <div class="card-body">
                    <form action="InputEx.do" class="forms-sample" method="post" onsubmit="return validateForm();">

                      <div class="login-form">
                        <label for="exampleInputDate">운동일자</label>
                        <input type="text" name = "ex_date" class="form-control" id="exampleInputDate" placeholder="YYYY-MM-DD" />
                      </div>
                      <!-- ì´ëì í-->
                      <div class="login-form">
                        <label for="exampleFormControlSelect1">운동선택</label>
                        <select name ="ex_name" class="form-control form-control-lg" id="exampleFormControlSelect1">
                          <option>운동을 선택하세요.</option>
                          <option>아령운동</option>
                          <option>짐볼운동</option>
                          <option>바스키아운동전스트레칭</option>
                          <option>바스키아운동후스트레칭</option>
                          <option>스쿼트</option>
                          <option>턱걸이</option>
                          <option>런지</option>
                          <option>백익스텐션</option>
                          <option>사이드 싯업</option>
                          <option>크런치</option>
                          <option>힙업</option>
                          <option>바벨백익스텐션</option>
                          <option>벤드오버</option>
                          <option>이두덤벨컬</option>
                          <option>이두바벨컬</option>
                          <option>데드리프트</option>
                          <option>라잉레그컬</option>
                          <option>라잉힙업</option>
                          <option>레그레이즈</option>
                          <option>레그프레스</option>
                          <option>사이드밴드</option>
                          <option>양반크런치</option>
                          <option>체스트플라이</option>
                          <option>카프레이즈</option>
                          <option>트라이셉스킥백</option>
                          <option>레그익스텐션</option>
                          <option>바벨벤치프레스</option>
                          <option>사이드크런치</option>
                          <option>삼두바벨익스텐션</option>
                          <option>스텐딩힙업</option>
                          <option>컨센트레이션컬</option>
                          <option>바벨숄더프레스</option>
                          <option>삼두덤벨익스텐션</option>
                          <option>수잔파우터육체와의전쟁</option>
                          <option>디클라인벤치프레스</option>
                          <option>라잉사이드힙업</option>
                          <option>바벨프런트프레스</option>
                          <option>사이드레그레이즈</option>
                          <option>싯레그레이즈교차</option>
                          <option>인클라인벤치프레스</option>
                          <option>스텐딩사이드힙업</option>
                          <option>푸쉬업</option>
                          <option>바벨벤트오버로우모션</option>
                          <option>원핸드벤트오버로우모션</option>
                          <option>바벨트라이셉스익스텐션</option>
                        </select>
                      </div>
                      <div class="login-form">
                        <label for="exampleInputConfirmPassword1">운동완료여부</label>
                        <div class="login-form row">
                          <div class="col-sm-circle">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="ex_done"
                                  id="membershipRadios1" value="Y" checked />운동완료</label>
                            </div>
                          </div>
                          <div class="col-sm-circle">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="ex_done"
                                  id="membershipRadios2" value="N" />오늘은 쉴래요.</label>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="login-form">
                        <label for="exampleInputConfirmPassword1">반복횟수</label>
                        <input type="text" name="ex_reps" class="form-control" id="exampleInputConfirmPassword2"
                          placeholder="반복횟수" />
                      </div>
                      <div class="login-form">
                        <label for="exampleInputConfirmPassword1">운동시간</label>
                        <input type="text" name="ex_time" class="form-control" id="exampleInputConfirmPassword2"
                          placeholder="운동시간"/>
                      </div>
                      <div class="comp">
                      <button type="submit" class="btn btn-primary me-2">운동완료</button>
                      <button type="reset" class="btn btn-light">취소</button>
                    </div>
                    </form>
                  </div>
                </div>
              </div>
              <!-- delete -->
              <!-- delete end -->
            </div>
          </div>
          <!-- content-wrapper ends -->

          <!-- my health form end -->

        </div>















<!-- ** Main Area END ** -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
				
				
	
<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ** Footer Area START ** -->			
				
				
				
				<!-- partial:partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2024 <a
                target="_blank">Fitneeds</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Fitneeds team & smhrd <i
                class="mdi mdi-heart text-danger"></i></span>
          </div>
        </footer>
				<!-- partial -->
				
				
	
<!-- ** Footer Area END ** -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
				
				
				
				
				
				
				
				
			</div> <!-- main-panel ends --> 
		</div><!-- page-body-wrapper ends -->
	</div><!-- container-scroller -->
	
	
	
	
	
	
	
	
	
	
	
	
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
	<script src="assets/js/check_ex.js"></script>
	<!-- End custom js for this page -->
	
		<!-- 달력 스크립트 START -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<script>
		$(function() {
			$("#exampleInputDate").datepicker({
				dateFormat : "yy-mm-dd"
			});
		});
	</script>
	<!-- 달력 스크립트 END -->
	
	
<!-- ** JS AREA START ** -->	
<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->	
</body>
</html>