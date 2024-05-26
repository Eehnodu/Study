// 처음실행 했을 때 자동완성 실행
$(function() {
	myAjaxAutoComplete();
})

// 검색 탭이 변할때마다 실행
$("#sel1").on("change", myAjaxAutoComplete)

// 비동기통신을 사용하여 작성자 리스트를 전부 조회
// 요청 경로 : /autocomplete
function myAjaxAutoComplete() {
	$.ajax({
		url: `${cpath}/autocomplete`,
		data: { type: $("#sel1").val() },
		dataType: "json",
		success: function(res) {
			var resultlist = [];
			for (var i = 0; i < res.length; i++) {
				if (res[i].writer != null) {
					resultlist.push(res[i].writer);
				}
				else {
					resultlist.push(res[i].title);
				}
			}
			myAuto(resultlist);
		},
		error: function(e) {
			console.log("실패")
		}
	});
}

function myAuto(resultlist) {
	// jquery-ui를 사용해서 input 태그 아래 쪽에 글자 자동완성 기능
	$("#auto_complete").autocomplete({
		// 1. 자동완성하고 싶은 목록
		source: resultlist,
		// 2. 최소글자
		minlength: 1,
		// 3. 딜레이 시간
		delay: 0.1,
		// 4. 해당 요소에 forcusing 되었을 때 작동할 함수
		focus: function(e, ui) {
			// e --> event
			// ui --> 화면구성
			return false;
		}
	})
}

$("#searchbtn").on("click", function() {
			var data = $("#searchform").serialize();
			console.log(data);
			$.ajax({
				url : `${cpath}/search`,
				data : data,
				dataType : 'json',
				success : (res) => {
					$("#myTable tr:first-child~tr").empty();
					
					$("#myTable tr:not(:first-child)").remove();
					$.each(res, function(i, board){
						var tr = `<tr>
							<td>${board.idx}</td>
							<td><a href="${cpath}/boardContent/${board.idx}">${board.title}</a></td>
							<td>${board.writer}</td>
							<td>${board.content}</td>
							<td>${board.indate}</td>
						</tr>`;
					$("#myTable").append(tr);	
					})
					
				},
				error : (e) => {
				}
			})
		})