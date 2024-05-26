function validateForm() {
  var exDate = document.getElementById("exampleInputDate").value;
  var exName = document.getElementById("exampleFormControlSelect1").value;
  var exReps = document.getElementById("exampleInputConfirmPassword2").value;
  var exTime = document.getElementById("exampleInputConfirmPassword2").value;

  if (exDate === "" || exName === "" || exReps === "" || exTime === "") {
    alert("모든 입력란을 채워주세요.");
    return false;
  }

  // 운동이 성공적으로 완료되었을 때 알림창 띄우기
  alert("운동이 성공적으로 완료되었습니다!");

  return true;
}
