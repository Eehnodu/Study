document.addEventListener('DOMContentLoaded', function() {
	function chg_join() {
		document.getElementById("change_main").innerHTML = `
                    <div class="panel shadow1">
                        <link rel="stylesheet" href="assets/css/join.css" />
                        <form class="join-form" action="Join.do" method="post">
                            <div class="panel-switch animated fadeIn">
                                <button type="button" id="chg_login">Login</button>
                                <button type="button" id="chg_join">SignUp</button>
                            </div>
                            <h1 class="animated fadeInUp animate1" id="title-login">FITNEEDS 회원가입</h1>
                            <input type="submit" id="login-form-submit" class="login_form button animated fadeInUp animate4" value="회원가입">
                        </form>
                    </div>`;
		// chg_login 함수 연결
		document.getElementById("chg_login").addEventListener("click", chg_login);
		// chg_join 함수 삭제
		document.getElementById("chg_join").removeEventListener("click", chg_join);
	}

	function chg_login() {
		document.getElementById("change_main").innerHTML = `
                    <div class="panel shadow1">
                        <link rel="stylesheet" href="assets/css/login.css" />
                        <form class="login-form" action="login.do" method="post">
                            <div class="panel-switch animated fadeIn">
                                <button type="button" id="chg_login">Login</button>
                                <button type="button" id="chg_join">SignUp</button>
                            </div>
                            <h1 class="animated fadeInUp animate1" id="title-login">FITNEEDS 로그인</h1>
                            <input type="submit" id="login-form-submit" class="login_form button animated fadeInUp animate4" value="로그인">
                        </form>
                    </div>`;
		// chg_join 함수 연결
		document.getElementById("chg_join").addEventListener("click", chg_join);
		// chg_login 함수 삭제
		document.getElementById("chg_login").removeEventListener("click", chg_login);
	}

	// 회원가입 버튼 클릭 시
	document.getElementById("chg_join").addEventListener("click", chg_join);

	// 로그인 버튼 클릭 시
	document.getElementById("chg_login").addEventListener("click", chg_login);
});