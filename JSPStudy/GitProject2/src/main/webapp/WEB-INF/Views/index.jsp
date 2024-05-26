<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- fullcalendar CDN -->
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/locales-all.min.js'></script>
<!-- fullcalendar axios라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<title>Plus Admin</title>
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!--*** BASIC CSS START ***-->
<link rel="stylesheet"
	href="assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" href="assets/css/demo_1/style.css" />
<link rel="stylesheet" href="assets/css/demo_1/indexplus.css" />
<!--*** BASIC CSS END ***-->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ** 달력CSS START-->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="assets/css/demo_1/calendar.css" />
<!-- ** 달력CSS END-->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<style>
  .fc-myCustomButton-button {
    width: 80px;
    height: 40px;
    font-size : 0.5em;
  }
  .fc-myPlusButton-button {
    /* 버튼의 크기 조절 */
    width: 80px;
    height: 40px;
    font-size : 0.5em;
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

			<!-- partial 여기부터-->
			<!-- partial 여기부터-->
			<div class="main-panel">
				<div class="content-wrapper">


					<div class="data-input">
						<input type="text" class="btn btn-outline-dark bg-white"
							name="start_date" id="exampleInputDate" placeholder="조회시작일" /> <input
							type="text" class="btn btn-outline-dark bg-white" name="end_date"
							id="exampleInputDate1" placeholder="조회종료일" />



						<button type="submit" id="date_check"
							class="btn btn-dark me-2 btn-bg">적용</button>
					</div>


					<div class="row">

						<div class="row">
							<div class="col-xl-8 grid-margin stretch-card">
								<div class="card card-calender"
									style="background-image: url('assets/images/intro/flower.gif'); background-size: cover;">
									<div class="card-body">
										<div class="row pt-4">
											<div class="col-sm-6 text-sm-right pt-3 pt-sm-0">
												<h3 class="text-white">Clear Sky</h3>
												<h1 class="text-white m-0">${member.mem_nick}님</h1>
												<h1 class="text-white m-0" id="change_sentence"></h1>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xl-4 grid-margin stretch-card">
								<div class="card">
									<div class="card-body">
										<div class="d-flex justify-content-between align-items-start">
											<div class="card-body">
												<p class="m-0 survey-head"><strong class="chaname">출석률</strong></p>
												<canvas id="countDateChart"></canvas>
												<p id="attendanceRate" class ="indexDC"></p>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6 grid-margin stretch-card">
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">신체 데이터 변화량</h4>
										<canvas id="lineChart"></canvas>
										<p id="averageBMI" class="indexfont"></p>
										<p id="averageMuscle" class="indexfont"></p>
										<p id="averageFatPercentage" class="indexfont"></p>
									</div>
								</div>
							</div>
							<div class="col-lg-6 grid-margin stretch-card">
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">소모 칼로리 변화량</h4>
										<canvas id="lineChartCalories"></canvas>
										<p id="maxCalories" class="indexfont"></p>
										<p id="averageCalories" class="indexfont"></p>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xl-6 grid-margin stretch-card">
								<div class="card">
									<div class="card-body">
										<div id='calendar-container'>
											<div id='calendar'></div>
										</div>
										<!-- 수정 모달 -->
										<div class="modal fade" id="editModal" tabindex="-1"
											aria-labelledby="editModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="editModalLabel">일정 수정하기</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">
														<div class="mb-3">
															<label for="editTitle" class="form-label">일정이름</label> <input
																type="text" class="form-control" id="editTitle">
														</div>
														<div class="mb-3">
															<label for="editStart" class="form-label">시작시간</label> <input
																type="datetime-local" class="form-control"
																id="editStart">
														</div>
														<div class="mb-3">
															<label for="editEnd" class="form-label">종료시간</label> <input
																type="datetime-local" class="form-control" id="editEnd">
														</div>
														<div class="mb-3">
															<label for="editColor" class="form-label">배경색상</label> <select
																class="form-select" id="editColor">
																<option value="red">빨강색</option>
																<option value="orange">주황색</option>
																<option value="yellow">노랑색</option>
																<option value="green">초록색</option>
																<option value="blue">파랑색</option>
																<option value="indigo">남색</option>
																<option value="purple">보라색</option>
															</select>
														</div>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-danger"
															id="deleteEvent">삭제</button>
														<button type="button" class="btn btn-primary"
															id="saveEditChanges">저장</button>
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">취소</button>
													</div>
												</div>
											</div>
										</div>

										<!-- 추가 모달 -->
										<div class="modal fade" id="exampleModal" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">일정
															추가하기</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">
														<div class="mb-3">
															<label for="title" class="form-label">일정이름</label> <input
																type="text" class="form-control" id="title">
														</div>
														<div class="mb-3">
															<label for="start" class="form-label">시작시간</label> <input
																type="datetime-local" class="form-control" id="start">
														</div>
														<div class="mb-3">
															<label for="end" class="form-label">종료시간</label> <input
																type="datetime-local" class="form-control" id="end">
														</div>
														<div class="mb-3">
															<label for="color" class="form-label">배경색상</label> <select
																class="form-select" id="color">
																<option value="red">빨강색</option>
																<option value="orange">주황색</option>
																<option value="yellow">노랑색</option>
																<option value="green">초록색</option>
																<option value="blue">파랑색</option>
																<option value="indigo">남색</option>
																<option value="purple">보라색</option>
															</select>
														</div>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">취소</button>
														<button type="button" class="btn btn-primary"
															id="saveChanges">추가</button>
													</div>
												</div>
											</div>
										</div>


									</div>
								</div>
							</div>
							<div class="col-xl-6 grid-margin stretch-card">
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">운동비율</h4>
										<canvas id="pieChart"></canvas>
										<div>
										<p id="aerobicCount" class="indexfont"></p>
										<p id="upperBodyCount" class="indexfont"></p>
										<p id="lowerBodyCount" class="indexfont"></p>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
					<!-- END -->
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
			<!-- 여기까지~~~~~~ -->
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

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ** calendar JS START ** -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<script src="assets/js/change_sentence.js"></script>
	<!-- ** calendar JS START ** -->

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- 달력 자바 스크립트 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<script>
		$(function() {
			$("#exampleInputDate").datepicker({
				dateFormat : "yy-mm-dd"
			});
		});

		$(function() {
			$("#exampleInputDate1").datepicker({
				dateFormat : "yy-mm-dd"
			});
		});
	</script>
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<script>
		var calendar;
		var clickedEvent; // 클릭한 이벤트 정보를 저장하기 위한 전역 변수
		(function() {
			$(function() {
				// calendar element 취득
				var calendarEl = $('#calendar')[0];
				// full-calendar 생성하기
				var calendar = new FullCalendar.Calendar(
						calendarEl,
						{
							height : '700px', // calendar 높이 설정
							expandRows : true, // 화면에 맞게 높이 재설정
							slotMinTime : '08:00', // Day 캘린더에서 시작 시간
							slotMaxTime : '20:00', // Day 캘린더에서 종료 시간
							customButtons : {
								myCustomButton : {
									text : "운동기록",
									click : function() {
										window.location.href = "http://localhost:8080/GitProject/fitmyhealth.do";
									}
								},

								myPlusButton : {
									text : "일정추가",
									click : function() {
										//부트스트랩 모달 열기
										$("#exampleModal").modal("show");
									}
								}
							},
							// 해더에 표시할 툴바
							headerToolbar : {
								left : 'prev,today,myPlusButton,myCustomButton',
								center : 'title',
								right : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek,next'
							},
							initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
							// initialDate: '2024-04-02', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
							navLinks : true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
							editable : true, // 수정 가능?
							selectable : true, // 달력 일자 드래그 설정가능
							nowIndicator : true, // 현재 시간 마크
							dayMaxEvents : true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
							locale : 'ko', // 한국어 설정
							eventAdd : function(obj) { // 이벤트가 추가되면 발생하는 이벤트
							},
							eventChange : function(obj) { // 이벤트가 수정되면 발생하는 이벤트
							},
							eventRemove : function(obj) { // 이벤트가 삭제되면 발생하는 이벤트
							},
							// 이벤트클릭을 이용한 데이터 수정
							eventClick : function(info) {
								// 클릭한 이벤트의 정보 가져오기
								clickedEvent = info.event;
								// 모달 폼에 이벤트 정보 채우기
								$("#editTitle").val(clickedEvent.title);
								$("#editStart").val(clickedEvent.startStr);
								$("#editEnd").val(clickedEvent.endStr);
								$("#editColor").val(
										clickedEvent.backgroundColor);
								// 수정 모달 열기
								$("#editModal").modal("show");
							},
							select : function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
								var title = prompt('Event Title:');
								if (title) {
									calendar.addEvent({
										title : title,
										start : arg.start,
										end : arg.end,
										allDay : arg.allDay
									})
								}
								calendar.unselect()
							},

						});
				// 캘린더 랜더링
				calendar.render();

				// 문서가 로드될 때 자동으로 이벤트 불러오기
				fetchAndAddEvents();

				// DB에 저장된 일정 가져오기
				function fetchAndAddEvents() {
					$.ajax({
						url : 'FetchCalendarEvent.do',
						method : 'POST',
						success : function(res) {
							// 받아온 이벤트들을 events 배열에 추가
							res.forEach(function(event) {
								calendar.addEvent(event);
							});
						},
						error : function() {
							console.log("이벤트 불러오기 실패");
						}
					});
				}

				// 모달창 이벤트 // 일정 추가해서 화면에 띄워주기
				$("#saveChanges").on(
						"click",
						function() {
							var eventData = {
								title : $("#title").val(),
								start : $("#start").val(),
								end : $("#end").val(),
								color : $("#color").val(),
							};
							//빈값입력시 오류
							if (eventData.title == "" || eventData.start == ""
									|| eventData.end == "") {
								alert("입력하지 않은 값이 있습니다.");

								//끝나는 날짜가 시작하는 날짜보다 값이 크면 안됨
							} else if ($("#start").val() > $("#end").val()) {
								alert("시간을 잘못입력 하셨습니다.");
							} else {
								// 이벤트 추가
								$("#exampleModal").modal("hide");
								$("#title").val("");
								$("#start").val("");
								$("#end").val("");
								$("#color").val("");
								// db에 저장
								$.ajax({
									url : 'CalendarSave.do',
									method : 'POST',
									data : eventData,
									success : function(response) {
										console.log("성공");
										calendar.addEvent(eventData);
									},
									error : function(xhr, status, error) {
									}
								});

							}
						});

				// 수정 모달 저장 버튼 클릭 시 수정된 정보 전송
				$("#saveEditChanges").on(
						"click",
						function() {
							var eventData = {
								title : $("#editTitle").val(),
								start : $("#editStart").val(),
								end : $("#editEnd").val(),
								color : $("#editColor").val(),
								cal_idx : clickedEvent.id, // clickedEvent 변수 사용
							};

							$.ajax({
								url : "CalendarUpdate.do",
								method : 'POST',
								data : eventData,
								success : function(response) {
									clickedEvent.setProp('title',
											eventData.title);
									clickedEvent.setStart(eventData.start);
									clickedEvent.setEnd(eventData.end);
									clickedEvent.setProp('backgroundColor',
											eventData.color);
									calendar.refetchEvents();
									$("#editModal").modal("hide");
								},
								error : function(xhr, status, error) {
									console.error("이벤트 업데이트 실패:", error);
								}
							});
						});

				// 삭제 기능
				$("#deleteEvent").on("click", function() {
					// 선택한 이벤트의 시작 날짜와 종료 날짜 가져오기
					var eventData = {
						cal_idx : clickedEvent.id
					};

					$.ajax({
						url : "CalendarDelete.do",
						method : 'POST',
						data : eventData,
						success : function(response) {
							clickedEvent.remove();
							$("#editModal").modal("hide");
						},
						error : function(xhr, status, error) {
							console.error("이벤트 삭제 실패:", error);
						}
					});
				});
				// 스타일 적용
		        // myCustomButton 버튼의 스타일을 변경
		        $(".fc-myCustomButton-button").css("font-size", "0.9em");
		        // myPlusButton 버튼의 스타일을 변경
		        $(".fc-myPlusButton-button").css("font-size", "0.9em");
			});
		})();
	</script>
</body>
</html>