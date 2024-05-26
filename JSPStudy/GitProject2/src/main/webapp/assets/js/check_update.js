function validateForm() {
    var password = document.forms["profileForm"]["mem_pw"].value;

    if (password === "") {
        alert("비밀번호를 입력해 주세요.");
        return false;
    }

    return true;
}
