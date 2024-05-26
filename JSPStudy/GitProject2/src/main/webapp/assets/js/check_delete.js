// 탈퇴하기 버튼 클릭 이벤트
    document.getElementById("confirmUnregister").addEventListener("click", function() {
        // 확인 창 띄우기
        if (confirm("정말로 탈퇴하시겠습니까?")) {
            // 확인을 누른 경우 폼 제출
            document.getElementById("unregisterForm").submit();
        } else {
            // 취소를 누른 경우 아무 동작 없음
        }
    });