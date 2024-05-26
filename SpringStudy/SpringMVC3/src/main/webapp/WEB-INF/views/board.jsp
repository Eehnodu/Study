<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!-- == controller -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- 자동완성 기능을 위해 가져온 jquery-ui library -->
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.1/themes/smoothness/jquery-ui.css">

<!-- Chart를 그리기 위해 가져오는 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@2"></script>


</head>
<body>
	<div class="jumbotron">
		<h1>게시판</h1>
		<p>게시판입니다.</p>
	</div>

	<div class="container">
		<div class="card">
			<div class="card-header">게시판 연습</div>
			<div class="card-body">
				<div class="dropdown">
					<form id="searchform" onsubmit="return false;" class="form-inline">
						<div align="right" class="form-group">
							<select name="type" class="form-control btn-warning" id="sel1">
								<option class="btn-light" value="writer">작성자</option>
								<option class="btn-light" value="title">제목</option>
							</select>
						</div>
						<input id="auto_complete" name="text" type="text"
							class="form-control"> <input id="searchbtn" type="submit"
							class="btn btn-warning" value="검색">
					</form>
					<br>
				</div>
				<table id="myTable" class="table table-bordered table-hover">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>내용</td>
						<td>작성일</td>
					</tr>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.idx}</td>
							<!-- 1. QueryString으로 데이터 보내기
								 2. 경로상에 그냥 바로 데이터 포함해서 보내기
							-->
							<td><a href="${cpath}/boardContent/${item.idx}">${item.title}</a></td>
							<td>${item.writer}</td>
							<td>${item.content}</td>
							<td>${item.indate}</td>
						</tr>
					</c:forEach>
				</table>
				<button class="btn btn-primary btn-sm"
					onclick="location.href='${cpath}/register'">글쓰기</button>
				<button class="btn btn-success btn-sm chartBtn">차트보기</button>
			</div>
			<div class="card-footer myChartArea">
				<h1>아티스트 키워드 빈도수</h1>
				<div>
					<canvas width=500 height = 500 id="myChart"></canvas>
				</div>



			</div>
		</div>
	</div>

	<script type="text/javascript">
		var cpath = "${cpath}";
	</script>
	<script>
		var pieChart;
		
		// 1. 첫 실행시,  myChartArea 영역을 숨기기
		$(".myChartArea").hide();
		// 2. 차트보기 버튼을 클릭하면,  myChartArea 영역을 보여주기
		$(".chartBtn").on("click", function(){
			// myChartArea 영역이 숨겨져 있다면, 영역을 보여주기
			if($(".myChartArea").css("display") == "none"){
				$(".myChartArea").slideDown();
				// 비동기통신을 사용해서 /artist url로 데이터 요청
				// --> 언급된 빈도수가 가장 높은 상위 5명에 대한
				//     아티스트명과, 빈도수 데이터를 결과값으로 받아오기
				$.ajax({
				url : `${cpath}/getdata`,
				dataType : 'json',
				success : (res) => {
					var labels = res.map(item => item.artist);
					var datas = res.map(item => item.keywordCnt);
					drawChart(labels, datas); 
				},
				error : (e) => {
				}
			})
				
			}
			// 그렇지 않은 경우, 영역을 숨겨주기
			else{
				$(".myChartArea").slideUp();
				if (pieChart != undefined) {
					pieChart.destroy();
				}
				
			}
		})
		
		function drawChart(labels, datas){
			// 1. 차트를 그릴 canvas 태그를 선택
			var ctx = $("#myChart");
			// data 설정
			const data = {
					  // DB에서 조회한 아티스트 명으로 변경
					  labels: labels,
					  datasets: [{
					    label: 'Artist keyword_cnt',
						// DB에서 조회한 키;워드 빈도수로 변경
					    data: datas,
					    backgroundColor: [
					    	'rgb(2, 43, 58)',
					    	'rgb(31, 122, 140)',
					    	'rgb(191, 219, 247)',
					    	'rgb(225, 229, 242)',
					    	'rgb(255, 255, 255)'
					    ],
					    hoverOffset: 4
					  }]
					};
			// 옵션 설정
			const options = {
				responsive : false,
				// 따로 설치한 플러그인 사용하기
				plugins : {
					datalabels : {
						color : [
							"white",
							"white",
							"white",
							"black",
							"black"
						],
						formatter : function(v, c){
							console.log(v);
							console.log(c);
							return c.chart.data.labels[c.dataIndex]
						},
						font : {
							size : 20
						}
					
					}
				}
			};
			// config 설정
			const config = {
					plugins : [ChartDataLabels],
					type: 'pie',
					data: data,
					options: options
				};
			
			// 2. 차트 그리기
			pieChart = new Chart(ctx, config);
		}
	</script>
	<script src="resources/js/myfirst.js"></script>

</body>
</html>