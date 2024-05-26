function validateForm() {
	// Get specific input elements by their IDs
	var memId = document.getElementById('mem_id').value;
	var memPw = document.getElementById('mem_pw').value;
	var memNick = document.getElementById('mem_nick').value;
	var memName = document.getElementById('mem_name').value;
	var memBirthday = document.getElementById('mem_birthday').value;
	var memAddr = document.getElementById('mem_addr').value;
	var memPhone = document.getElementById('mem_phone').value;
	var memEmail = document.getElementById('mem_email').value;

	// Check if any of the fields are empty
	if (memId === '') {
		alert('아이디를 입력해주세요.');
		return false;
	}
	if (memPw === '') {
		alert('비밀번호를 입력해주세요.');
		return false;
	}
	if (memNick === '') {
		alert('닉네임을 입력해주세요.');
		return false;
	}
	if (memName === '') {
		alert('이름을 입력해주세요.');
		return false;
	}
	if (memBirthday === '') {
		alert('생년월일을 입력해주세요.');
		return false;
	}
	if (memAddr === '') {
		alert('주소를 입력해주세요.');
		return false;
	}
	if (memPhone === '') {
		alert('핸드폰번호를 입력해주세요.');
		return false;
	}
	if (memEmail === '') {
		alert('이메일을 입력해주세요.');
		return false;
	}

	return true;
}
