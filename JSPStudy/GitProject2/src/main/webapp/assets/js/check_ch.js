function validateForm() {
        var chDate = document.getElementById("exampleInputDate").value;
        var weight = document.getElementById("exampleInputConfirmPassword2").value;

        if (chDate === "" || weight === "") {
            alert("날짜와 체중을 입력해주세요.");
            return false;
        }

        // 성공적으로 완료되었다는 알림 표시
        alert("성공적으로 완료되었습니다.");
        return true;
    }