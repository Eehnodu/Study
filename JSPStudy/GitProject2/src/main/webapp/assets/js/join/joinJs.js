document.addEventListener('DOMContentLoaded', function () {
    let $inputMemberId = document.querySelector("#mem_id");
    $inputMemberId.addEventListener("input", validateMemberIdInput);

    let $buttonMemberIdCheckPro = document.querySelector("#button-memberIdCheckPro");
    $buttonMemberIdCheckPro.addEventListener("click", checkMemberId);

    let $inputMemberPw = document.querySelector("#mem_pw");
    $inputMemberPw.addEventListener("input", validateMemberPwInput);

    let $inputMemberNick = document.querySelector("#mem_nick");
    $inputMemberNick.addEventListener("input", validateMemberNickInput);

    let $inputMemberName = document.querySelector("#name");
    $inputMemberName.addEventListener("input", validateMemberNameInput);

    let $inputMemberEmail = document.querySelector("#email");
    $inputMemberEmail.addEventListener("input", validateMemberEmailInput);

    let $buttonMemberEmailCheckPro = document.querySelector("#button-memberEmailCheckPro");
    $buttonMemberEmailCheckPro.addEventListener("click", checkMemberEmail);

    let $inputMemberPhone = document.querySelector("#input-memberPhone");
    $inputMemberPhone.addEventListener("input", validateMemberPhoneInput);

    let $buttonMemberJoinPro = document.querySelector("#button-memberJoinPro");
    $buttonMemberJoinPro.addEventListener("click", validateMemberJoin);
    
    /* 네이버 로그인 버튼클릭시 이동 */
	function goNaver() {
	location.href = apiURL;
	}

    /* 아이디 유효성 검사 */
    function validateMemberIdInput() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }

    /* 아이디 중복검사 */
    function checkMemberId() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }

    /* 비밀번호 유효성 검사 */
    function validateMemberPwInput() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }

    /* 닉네임 유효성 검사 */
    function validateMemberNickInput() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }

    /* 이름 유효성 검사 */
    function validateMemberNameInput() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }

    /* 이메일 유효성 검사 */
    function validateMemberEmailInput() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }

    /* 이메일 중복검사 */
    function checkMemberEmail() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }

    /* 휴대폰 유효성 검사 */
    function validateMemberPhoneInput() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }

    /* 회원가입 유효성 검사 */
    function validateMemberJoin() {
        // 이 부분은 주어진 코드와 동일하게 유지
    }
});













// 자동재생 stop

document.addEventListener('DOMContentLoaded', function () {
    // Get the carousel element
    var myCarousel = document.getElementById('header-carousel');

    // Initialize the carousel
    var carousel = new bootstrap.Carousel(myCarousel, {
        interval: false // Stop auto-playing
    });
});

// 재생시간 조정

document.addEventListener("DOMContentLoaded", function () {
    var carousel = document.querySelector('#header-carousel');
    var carouselInstance = new bootstrap.Carousel(carousel, {
        interval: false // Disable automatic cycling
    });
    
    var prevBtn = document.querySelector('.carousel-control-prev');
    var nextBtn = document.querySelector('.carousel-control-next');

    prevBtn.addEventListener('click', function () {
        carouselInstance.prev();
    });

    nextBtn.addEventListener('click', function () {
        carouselInstance.next();
    });
});
