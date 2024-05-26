$(function() {

	var doughnutChart;
	var lineChart;
	var lineChartCalories;
	var pieChart;
	var barChart;
	// 나의 데이터 및 표준 데이터 초기화
	loadChartData();
	fetchCompareChart();

	// 현재날짜와 일주일전 날짜 계산
	function formatDate(date) {
		let year = date.getFullYear();
		let month = (date.getMonth() + 1).toString().padStart(2, '0');
		let day = date.getDate().toString().padStart(2, '0');
		return `${year}-${month}-${day}`;
	}

	// 일주일 전 데이터 출력
	function loadChartData() {
		let today = new Date();
		let oneWeekAgo = new Date(today);
		oneWeekAgo.setDate(oneWeekAgo.getDate() - 7);

		let todayFormatted = formatDate(today);
		let oneWeekAgoFormatted = formatDate(oneWeekAgo);

		$("#exampleInputDate").val(oneWeekAgoFormatted);
		$("#exampleInputDate1").val(todayFormatted);

		fetchStartExChart(oneWeekAgoFormatted, todayFormatted);
		fetchStartChChart(oneWeekAgoFormatted, todayFormatted);
		countDate();
	}

	// 출석률 출력
	function countDate() {
		$.ajax({
			url: "CountDate.do",
			type: 'POST',
			dataType: 'json',
			success: (res) => {
				var nocount_date = res.nocount_date;
				var count_date = res.count_date;

				// 배열로 변환
				var exCounts = [count_date, nocount_date];
				// 소수점 이하를 반올림하여 정수로 변환
				var attendanceRate = Math.round((count_date / (nocount_date + count_date)) * 100);

				// 출석률 데이터 셋
				var countDateData = {
					datasets: [{
						data: exCounts,
						backgroundColor: [
							'rgba(255, 99, 132, 0.5)',
							'rgba(54, 162, 235, 0.5)',
							'rgba(255, 206, 86, 0.5)',
							'rgba(75, 192, 192, 0.5)',
							'rgba(153, 102, 255, 0.5)',
							'rgba(255, 159, 64, 0.5)'
						],
						borderColor: [
							'rgba(255,99,132,1)',
							'rgba(54, 162, 235, 1)',
							'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)',
							'rgba(153, 102, 255, 1)',
							'rgba(255, 159, 64, 1)'
						],
					}],
					labels: ['출석횟수', '미출석횟수']

				};

				var countDateOptions = {
					responsive: true,
					animation: {
						animateScale: true,
						animateRotate: true
					},

					// 도넛형 차트를 반으로 자르기 위한 조건
					rotation: 1 * Math.PI,
					circumference: 1 * Math.PI
				};

				// countDateChart 그리기
				if ($("#countDateChart").length) {
					var pieChartCanvas = $("#countDateChart").get(0).getContext("2d");
					countDateChart = new Chart(pieChartCanvas, {
						type: 'doughnut',
						data: countDateData,
						options: countDateOptions
					});

					// 캔버스 요소에 동적으로 크기를 지정하여 반응형으로 만듭니다.
					$("#countDateChart").css({
						'max-width': '100%',
						'height': 'auto'
					});
				}
				$("#attendanceRate").text(attendanceRate + "%");
			},
			error: () => {
				console.log("실패")
			}
		})
	}

	// 운동 종류 데이터 차트 출력
	function fetchStartExChart(start_date, end_date) {
		$.ajax({
			url: "AccEx.do",
			data: { "start_date": start_date, "end_date": end_date },
			type: 'POST',
			dataType: 'json',
			success: (res) => {
				// ex_category를 추출하여 labels 배열에 할당
				let labels = res.map(item => item.ex_category);
				// ex_count 값을 추출하여 data 배열에 할당
				let exCounts = res.map(item => item.ex_count);

				// 유산소, 상체, 하체 운동 횟수를 저장할 변수 초기화
				let aerobicCount = 0;
				let upperBodyCount = 0;
				let lowerBodyCount = 0;

				// 각 운동 유형에 따라 횟수 누적
				res.forEach(item => {
					switch (item.ex_category) {
						case "유산소":
							aerobicCount += item.ex_count;
							break;
						case "상체":
							upperBodyCount += item.ex_count;
							break;
						case "하체":
							lowerBodyCount += item.ex_count;
							break;
						default:
							break;
					}
				});

				// 운동의 종류 데이터 셋
				doughnutPieData = {
					datasets: [{
						data: exCounts,
						backgroundColor: [
							'rgba(255, 99, 132, 0.5)',
							'rgba(54, 162, 235, 0.5)',
							'rgba(255, 206, 86, 0.5)',
							'rgba(75, 192, 192, 0.5)',
							'rgba(153, 102, 255, 0.5)',
							'rgba(255, 159, 64, 0.5)'
						],
						borderColor: [
							'rgba(255,99,132,1)',
							'rgba(54, 162, 235, 1)',
							'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)',
							'rgba(153, 102, 255, 1)',
							'rgba(255, 159, 64, 1)'
						],
					}],

					labels: labels
				};

				// pieChart 그리기
				if ($("#pieChart").length) {
					var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
					pieChart = new Chart(pieChartCanvas, {
						type: 'pie',
						data: doughnutPieData,
						options: doughnutPieOptions
					});
				}
				var doughnutPieOptions = {
					responsive: true,
					animation: {
						animateScale: true,
						animateRotate: true
					}
				};
				// 각 운동 유형별 횟수를 텍스트로 출력
				$("#aerobicCount").text("유산소 운동 횟수 : " + aerobicCount);
				$("#upperBodyCount").text("상체 운동 횟수 : " + upperBodyCount);
				$("#lowerBodyCount").text("하체 운동 횟수 : " + lowerBodyCount);
			},
			error: () => {
				console.log("실패")
			}
		});
	};

	// 신체 변화량 데이터 차트 출력
	function fetchStartChChart(start_date, end_date) {
		$.ajax({
			url: "AccCh.do",
			data: { "start_date": start_date, "end_date": end_date },
			type: 'POST',
			dataType: 'json',
			success: (res) => {
				let labels = res.map(item => item.ch_date);
				let chCalories = res.map(item => item.ex_calories);
				let chbmi = res.map(item => item.bmi);
				let chmuscle = res.map(item => item.muscle);
				let chfat_per = res.map(item => item.fat_per);

				// 평균 소모 칼로리 계산
				let totalCalories = 0;
				for (let i = 0; i < chCalories.length; i++) {
					totalCalories += chCalories[i];
				}
				let averageCalories = totalCalories / chCalories.length;
				// 최고 소모 칼로리 계산
				let maxCalories = chCalories[0];
				for (let i = 1; i < chCalories.length; i++) {
					if (chCalories[i] > maxCalories) {
						maxCalories = chCalories[i];
					}
				}
				// 평균 BMI 계산
				let totalBMI = 0;
				for (let i = 0; i < chbmi.length; i++) {
					totalBMI += chbmi[i];
				}
				let averageBMI = totalBMI / chbmi.length;
				// 평균 근육량 계산
				let totalMuscle = 0;
				for (let i = 0; i < chmuscle.length; i++) {
					totalMuscle += chmuscle[i];
				}
				let averageMuscle = totalMuscle / chmuscle.length;
				// 평균 체지방률 계산
				let totalFatPercentage = 0;
				for (let i = 0; i < chfat_per.length; i++) {
					totalFatPercentage += chfat_per[i];
				}
				let averageFatPercentage = totalFatPercentage / chfat_per.length;

				// 칼로리 데이터 셋
				var dataCalorie = {
					datasets: [{
						label: '칼로리',
						data: chCalories,
						backgroundColor: [
							'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 206, 86, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 159, 64, 0.2)'
						],
						borderColor: 'rgba(255, 0, 0, 1)',
						borderWidth: 1,
						fill: false
					}],
					labels: labels
				}

				// 칼로리를 제외한 나머지 데이터 셋
				var data = {
					datasets: [{
						label: 'BMI',
						data: chbmi,
						backgroundColor: [
							'rgba(255, 205, 86, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 159, 64, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 99, 132, 0.2)'
						],
						borderColor: 'rgba(255, 205, 86, 1)',
						borderWidth: 1,
						fill: false
					},
					{
						label: '근육량',
						data: chmuscle,
						backgroundColor: [
							'rgba(75, 192, 192, 0.2)',
							'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 159, 64, 0.2)',
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 205, 86, 0.2)'
						],
						borderColor: 'rgba(75, 192, 192, 1)',
						borderWidth: 1,
						fill: false
					},
					{
						label: '체지방률',
						data: chfat_per,
						backgroundColor: [
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 205, 86, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 159, 64, 0.2)'
						],
						borderColor: 'rgba(153, 102, 255, 1)',
						borderWidth: 1,
						fill: false
					}],
					labels: labels
				};

				// 칼로리르 제외한 변화량 차트 그리기
				if ($("#lineChart").length) {
					var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
					lineChart = new Chart(lineChartCanvas, {
						type: 'line',
						data: data,
						options: options
					});
				}

				// 칼로리 변화량 차트 그리기
				if ($("#lineChartCalories").length) {
					var lineChartCaloriesCanvas = $("#lineChartCalories").get(0).getContext("2d");
					lineChartCalories = new Chart(lineChartCaloriesCanvas, {
						type: 'line',
						data: dataCalorie,
						options: options
					});
				}
				var options = {
					scales: {
						yAxes: [{
							ticks: {
								beginAtZero: true
							}
						}]
					},
					legend: {
						display: false
					},
					elements: {
						point: {
							radius: 0
						}
					}

				};
				$("#maxCalories").text("최고 소모 칼로리 : " + maxCalories.toFixed(2) + "kcal");
				$("#averageCalories").text("평균 소모 칼로리 : " + averageCalories.toFixed(2) + "kcal");
				$("#averageBMI").text("평균 bmi : " + averageBMI.toFixed(2));
				$("#averageMuscle").text("평균 근육량 : " + averageMuscle.toFixed(2));
				$("#averageFatPercentage").text("평균 체지방률 : " + averageFatPercentage.toFixed(2) + "%");

			},
			error: () => {
			}
		});
	};

	// 차트 업데이트
	$("#date_check").on("click", function() {
		let start_date = $("#exampleInputDate").val();
		let end_date = $("#exampleInputDate1").val();

		// 기존 차트 데이터 삭제
		if (doughnutChart != undefined) {
			doughnutChart.destroy();
		}
		if (lineChart != undefined) {
			lineChart.destroy();
		}

		if (lineChartCalories != undefined) {
			lineChartCalories.destroy();
		}

		if (pieChart != undefined) {
			pieChart.destroy();
		}

		fetchStartExChart(start_date, end_date);
		fetchStartChChart(start_date, end_date);

	});

	// barChart, radarChart 그리는 함수
	function drawCompareChart() {

		// barChart 데이터 셋 
		var barcomparedata = {
			labels: ['키', '체중', 'BMI', '근육량', '체지방률'],
			datasets: [{
				label: '나의데이터',
				backgroundColor: 'rgba(255, 99, 132, 0.6)',
				data: [mem_height, mem_weight, mem_bmi, mem_muscle, mem_fat_per]
			}, {
				label: '표준데이터',
				backgroundColor: 'rgba(54, 162, 235, 0.6)',
				data: [std_height, std_weight, std_bmi, std_muscle, std_fat_per]
			}]
		};

		// radarChart 데이터 셋
		var radarcomparedata = {
			labels: ['키', '체중', 'BMI', '근육량', '체지방률'],
			datasets: [{
				label: '나의데이터',
				backgroundColor: 'rgba(255, 99, 132, 0.5)',
				data: [mem_height, mem_weight, mem_bmi, mem_muscle, mem_fat_per]
			}, {
				label: '표준데이터',
				backgroundColor: 'rgba(54, 162, 235, 0.5)',
				data: [std_height, std_weight, std_bmi, std_muscle, std_fat_per]
			}]
		};

		// bar차트 그리기
		if ($("#barChart").length) {
			var barChartCanvas = $("#barChart").get(0).getContext("2d");
			barChart = new Chart(barChartCanvas, {
				type: 'bar',
				data: barcomparedata,
				options: options
			});
		}

		// radar차트 그리기
		if ($("#radarChart").length) {
			var radarChartCanvas = $("#radarChart").get(0).getContext("2d");
			radarChart = new Chart(radarChartCanvas, {
				type: 'radar',
				data: radarcomparedata,
				options: options
			});
		}

		// 옵션 설정
		var options = {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero: true
					}
				}]
			},
			legend: {
				display: false
			},
			elements: {
				point: {
					radius: 0
				}
			}
		};
	}

	// 개인 및 표준 데이터 비교 차트 그리기
	function fetchCompareChart() {

		// 개인 데이터 가져오기
		$.ajax({
			url: "MyData.do",
			type: 'POST',
			dataType: 'json',
			success: (res) => {
				mem_height = res.height;
				mem_weight = res.weight;
				mem_bmi = res.bmi;
				mem_muscle = res.muscle;
				mem_fat_per = res.fat_per;

				// success안에서만 값이 유지되기 때문에
				// 중첩 ajax를 이용하여 차트를 그림
				// 표준데이터 가져오기
				$.ajax({
					url: "StdData.do",
					type: 'POST',
					dataType: 'json',
					success: (res) => {
						std_height = res.height;
						std_weight = res.weight;
						std_bmi = res.bmi;
						std_muscle = res.muscle;
						std_fat_per = res.fat_per;

						// barChart와 radarChart 그리기
						drawCompareChart();
						$("#mem_height").text("나의 키 : " + mem_height.toFixed(2) + "cm");
						$("#mem_weight").text("나의 체중 : " + mem_weight.toFixed(2) + "kg");
						$("#mem_bmi").text("나의 BMI : " + mem_bmi.toFixed(2));
						$("#mem_muscle").text("나의 근육량: " + mem_muscle.toFixed(2));
						$("#mem_fat_per").text("나의 체지방률 : " + mem_fat_per.toFixed(2) + "%");
						$("#std_height").text("표준 키 : " + std_height.toFixed(2) + "cm");
						$("#std_weight").text("표준 체중 : " + std_weight.toFixed(2) + "kg");
						$("#std_bmi").text("표준 BMI : " + std_bmi.toFixed(2));
						$("#std_muscle").text("표준 근육량 : " + std_muscle.toFixed(2));
						$("#std_fat_per").text("표준 체지방률 : " + std_fat_per.toFixed(2) + "%");


					},
					error: () => {
						console.log("실패");
					}
				});
			},
			error: () => {
			}
		});
	};

	'use strict';

	var dataDark = {
		labels: ["2013", "2014", "2014", "2015", "2016", "2017"],
		datasets: [{
			label: '# of Votes',
			data: [10, 19, 3, 5, 2, 3],
			backgroundColor: [
				'rgba(255, 99, 132, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(255, 206, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(153, 102, 255, 0.2)',
				'rgba(255, 159, 64, 0.2)'
			],
			borderColor: [
				'rgba(255,99,132,1)',
				'rgba(54, 162, 235, 1)',
				'rgba(255, 206, 86, 1)',
				'rgba(75, 192, 192, 1)',
				'rgba(153, 102, 255, 1)',
				'rgba(255, 159, 64, 1)'
			],
			borderWidth: 1,
			fill: false
		}]
	};
	var multiLineData = {
		labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
		datasets: [{
			label: 'Dataset 1',
			data: [12, 19, 3, 5, 2, 3],
			borderColor: [
				'#587ce4'
			],
			borderWidth: 2,
			fill: false
		},
		{
			label: 'Dataset 2',
			data: [5, 23, 7, 12, 42, 23],
			borderColor: [
				'#ede190'
			],
			borderWidth: 2,
			fill: false
		},
		{
			label: 'Dataset 3',
			data: [15, 10, 21, 32, 12, 33],
			borderColor: [
				'#f44252'
			],
			borderWidth: 2,
			fill: false
		}
		]
	};

	var optionsDark = {
		scales: {
			yAxes: [{
				ticks: {
					beginAtZero: true
				},
				gridLines: {
					color: '#322f2f',
					zeroLineColor: '#322f2f'
				}
			}],
			xAxes: [{
				ticks: {
					beginAtZero: true
				},
				gridLines: {
					color: '#322f2f',
				}
			}],
		},
		legend: {
			display: false
		},
		elements: {
			point: {
				radius: 0
			}
		}

	};

	var areaData = {
		labels: ["2013", "2014", "2015", "2016", "2017"],
		datasets: [{
			label: '# of Votes',
			data: [12, 19, 3, 5, 2, 3],
			backgroundColor: [
				'rgba(255, 99, 132, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(255, 206, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(153, 102, 255, 0.2)',
				'rgba(255, 159, 64, 0.2)'
			],
			borderColor: [
				'rgba(255,99,132,1)',
				'rgba(54, 162, 235, 1)',
				'rgba(255, 206, 86, 1)',
				'rgba(75, 192, 192, 1)',
				'rgba(153, 102, 255, 1)',
				'rgba(255, 159, 64, 1)'
			],
			borderWidth: 1,
			fill: true, // 3: no fill
		}]
	};

	var areaDataDark = {
		labels: ["2013", "2014", "2015", "2016", "2017"],
		datasets: [{
			label: '# of Votes',
			data: [12, 19, 3, 5, 2, 3],
			backgroundColor: [
				'rgba(255, 99, 132, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(255, 206, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(153, 102, 255, 0.2)',
				'rgba(255, 159, 64, 0.2)'
			],
			borderColor: [
				'rgba(255,99,132,1)',
				'rgba(54, 162, 235, 1)',
				'rgba(255, 206, 86, 1)',
				'rgba(75, 192, 192, 1)',
				'rgba(153, 102, 255, 1)',
				'rgba(255, 159, 64, 1)'
			],
			borderWidth: 1,
			fill: true, // 3: no fill
		}]
	};

	var areaOptions = {
		plugins: {
			filler: {
				propagate: true
			}
		}
	}

	var areaOptionsDark = {
		scales: {
			yAxes: [{
				ticks: {
					beginAtZero: true
				},
				gridLines: {
					color: '#322f2f',
					zeroLineColor: '#322f2f'
				}
			}],
			xAxes: [{
				ticks: {
					beginAtZero: true
				},
				gridLines: {
					color: '#322f2f',
				}
			}],
		},
		plugins: {
			filler: {
				propagate: true
			}
		}
	}

	var multiAreaData = {
		labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
		datasets: [{
			label: 'Facebook',
			data: [8, 11, 13, 15, 12, 13, 16, 15, 13, 19, 11, 14],
			borderColor: ['rgba(255, 99, 132, 0.5)'],
			backgroundColor: ['rgba(255, 99, 132, 0.5)'],
			borderWidth: 1,
			fill: true
		},
		{
			label: 'Twitter',
			data: [7, 17, 12, 16, 14, 18, 16, 12, 15, 11, 13, 9],
			borderColor: ['rgba(54, 162, 235, 0.5)'],
			backgroundColor: ['rgba(54, 162, 235, 0.5)'],
			borderWidth: 1,
			fill: true
		},
		{
			label: 'Linkedin',
			data: [6, 14, 16, 20, 12, 18, 15, 12, 17, 19, 15, 11],
			borderColor: ['rgba(255, 206, 86, 0.5)'],
			backgroundColor: ['rgba(255, 206, 86, 0.5)'],
			borderWidth: 1,
			fill: true
		}
		]
	};

	var multiAreaOptions = {
		plugins: {
			filler: {
				propagate: true
			}
		},
		elements: {
			point: {
				radius: 0
			}
		},
		scales: {
			xAxes: [{
				gridLines: {
					display: false
				}
			}],
			yAxes: [{
				gridLines: {
					display: false
				}
			}]
		}
	}

	var scatterChartData = {
		datasets: [{
			label: 'First Dataset',
			data: [{
				x: -10,
				y: 0
			},
			{
				x: 0,
				y: 3
			},
			{
				x: -25,
				y: 5
			},
			{
				x: 40,
				y: 5
			}
			],
			backgroundColor: [
				'rgba(255, 99, 132, 0.2)'
			],
			borderColor: [
				'rgba(255,99,132,1)'
			],
			borderWidth: 1
		},
		{
			label: 'Second Dataset',
			data: [{
				x: 10,
				y: 5
			},
			{
				x: 20,
				y: -30
			},
			{
				x: -25,
				y: 15
			},
			{
				x: -10,
				y: 5
			}
			],
			backgroundColor: [
				'rgba(54, 162, 235, 0.2)',
			],
			borderColor: [
				'rgba(54, 162, 235, 1)',
			],
			borderWidth: 1
		}
		]
	}

	var scatterChartDataDark = {
		datasets: [{
			label: 'First Dataset',
			data: [{
				x: -10,
				y: 0
			},
			{
				x: 0,
				y: 3
			},
			{
				x: -25,
				y: 5
			},
			{
				x: 40,
				y: 5
			}
			],
			backgroundColor: [
				'rgba(255, 99, 132, 0.2)'
			],
			borderColor: [
				'rgba(255,99,132,1)'
			],
			borderWidth: 1
		},
		{
			label: 'Second Dataset',
			data: [{
				x: 10,
				y: 5
			},
			{
				x: 20,
				y: -30
			},
			{
				x: -25,
				y: 15
			},
			{
				x: -10,
				y: 5
			}
			],
			backgroundColor: [
				'rgba(54, 162, 235, 0.2)',
			],
			borderColor: [
				'rgba(54, 162, 235, 1)',
			],
			borderWidth: 1
		}
		]
	}

	var scatterChartOptions = {
		scales: {
			xAxes: [{
				type: 'linear',
				position: 'bottom'
			}]
		}
	}

	var scatterChartOptionsDark = {
		scales: {
			xAxes: [{
				type: 'linear',
				position: 'bottom',
				gridLines: {
					color: '#322f2f',
					zeroLineColor: '#322f2f'
				}
			}],
			yAxes: [{
				gridLines: {
					color: '#322f2f',
					zeroLineColor: '#322f2f'
				}
			}]
		}
	}
	// Get context with jQuery - using jQuery's .get() method.


	if ($("#barChartDark").length) {
		var barChartCanvasDark = $("#barChartDark").get(0).getContext("2d");
		// This will get the first returned node in the jQuery collection.
		var barChartDark = new Chart(barChartCanvasDark, {
			type: 'bar',
			data: dataDark,
			options: optionsDark
		});
	}



	if ($("#lineChartDark").length) {
		var lineChartCanvasDark = $("#lineChartDark").get(0).getContext("2d");
		var lineChartDark = new Chart(lineChartCanvasDark, {
			type: 'line',
			data: dataDark,
			options: optionsDark
		});
	}

	if ($("#linechart-multi").length) {
		var multiLineCanvas = $("#linechart-multi").get(0).getContext("2d");
		var lineChart = new Chart(multiLineCanvas, {
			type: 'line',
			data: multiLineData,
			options: options
		});
	}

	if ($("#areachart-multi").length) {
		var multiAreaCanvas = $("#areachart-multi").get(0).getContext("2d");
		var multiAreaChart = new Chart(multiAreaCanvas, {
			type: 'line',
			data: multiAreaData,
			options: multiAreaOptions
		});
	}

	if ($("#areaChart").length) {
		var areaChartCanvas = $("#areaChart").get(0).getContext("2d");
		var areaChart = new Chart(areaChartCanvas, {
			type: 'line',
			data: areaData,
			options: areaOptions
		});
	}

	if ($("#areaChartDark").length) {
		var areaChartCanvas = $("#areaChartDark").get(0).getContext("2d");
		var areaChart = new Chart(areaChartCanvas, {
			type: 'line',
			data: areaDataDark,
			options: areaOptionsDark
		});
	}

	if ($("#scatterChart").length) {
		var scatterChartCanvas = $("#scatterChart").get(0).getContext("2d");
		var scatterChart = new Chart(scatterChartCanvas, {
			type: 'scatter',
			data: scatterChartData,
			options: scatterChartOptions
		});
	}

	if ($("#scatterChartDark").length) {
		var scatterChartCanvas = $("#scatterChartDark").get(0).getContext("2d");
		var scatterChart = new Chart(scatterChartCanvas, {
			type: 'scatter',
			data: scatterChartDataDark,
			options: scatterChartOptionsDark
		});
	}

	if ($("#browserTrafficChart").length) {
		var doughnutChartCanvas = $("#browserTrafficChart").get(0).getContext("2d");
		var doughnutChart = new Chart(doughnutChartCanvas, {
			type: 'doughnut',
			data: browserTrafficData,
			options: doughnutPieOptions
		});
	}
});