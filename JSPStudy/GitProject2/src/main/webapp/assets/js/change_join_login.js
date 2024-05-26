document.addEventListener('DOMContentLoaded', function() {

	document.getElementById("chg_join").addEventListener("click", function() {
		document.getElementById("change_main").innerHTML = `
                    <div class="panel shadow1">
                        <link rel="stylesheet" href="assets/css/join.css" />
                        <form class="join-form" action="Join.do" method="post">
                            <div class="panel-switch animated fadeIn">
                                <button type="button" id="chg_login">Login</button>
                                <button type="button" id="chg_join">SignUp</button>
                            </div>
                            <h1 class="animated fadeInUp animate1" id="title-login">FITNEEDS 회원가입</h1>
                        <fieldset id="login-fieldset">
        					<input class="login animated fadeInUp animate2" class="loginfont"
        						name="mem_id" type="text" required placeholder="아이디" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_pw" type="password" required placeholder="비밀번호" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_name" type="text" required placeholder="이름" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_phone" type="text" required placeholder="000-0000-0000"
        						value=""> 
        					<input
        						class="login animated fadeInUp animate3 loginfont" 
        						name="mem_birthdate" type="text" id="birthdate" required
        						placeholder="생년월일" value=""> 
        					<input
        						class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_addr" type="text" required placeholder="주소"
        						value=""> 
        					<input class="login animated fadeInUp animate3"
        						class="loginfont" name="mem_email" type="text" required
        						placeholder="이메일" value=""> 
        					<input
        						class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_nick" type="text" required placeholder="닉네임"
        						value=""> 
        					<!--  옵셥을 통해서 성별 변경하기 -->
        					<select
        						class="login animated fadeInUp animate3 loginfont"
        						name="mem_gender" id="gender" required>
        						<option value="M">남성</option>
        						<option value="F">여성</option>
        					</select>
        					
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="height" type="text" required placeholder="키" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="weight" type="text" required placeholder="몸무게" value="">
        				</fieldset>
                            <input type="submit" id="login-form-submit" class="login_form button animated fadeInUp animate4" value="회원가입">
                        </form>
                    </div>`;
		// chg_login 함수 연결
		document.getElementById("chg_login").addEventListener("click", chg_login);
		// chg_join 함수 삭제
		document.getElementById("chg_join").removeEventListener("click", chg_join);
	});

	document.getElementById("chg_login").addEventListener("click", function() {
		document.getElementById("change_main").innerHTML = `
                    <div class="panel shadow1">
                        <link rel="stylesheet" href="assets/css/login.css" />
                        <form class="login-form" action="Login.do" method="post">
                            <div class="panel-switch animated fadeIn">
                                <button type="button" id="chg_login">Login</button>
                                <button type="button" id="chg_join">SignUp</button>
                            </div>
                            <h1 class="animated fadeInUp animate1" id="title-login">FITNEEDS 로그인</h1>
                            <fieldset id="login-fieldset">
        					<input class="login animated fadeInUp animate2" class="loginfont"
        						name="mem_id" type="text" required placeholder="id" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_pw" type="password" required placeholder="pw" value="">
        					</fieldset>
                            <input type="submit" id="login-form-submit" class="login_form button animated fadeInUp animate4" value="로그인">
                        </form>
                        
                       

                    </div>`;
		// chg_join 함수 연결
		document.getElementById("chg_join").addEventListener("click", chg_join);
		// chg_login 함수 삭제
		document.getElementById("chg_login").removeEventListener("click", chg_login);
	});

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
                            <fieldset id="login-fieldset">
        					<input class="login animated fadeInUp animate2" class="loginfont"
        						name="mem_id" type="text" required placeholder="아이디" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_pw" type="password" required placeholder="비밀번호" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_name" type="text" required placeholder="이름" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_phone" type="text" required placeholder="000-0000-0000"
        						value=""> 
        					<input
        						class="login animated fadeInUp animate3 loginfont" 
        						name="mem_birthdate" type="text" id="birthdate" required
        						placeholder="생년월일" value=""> 
        					<input
        						class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_addr" type="text" required placeholder="주소"
        						value=""> 
        					<input class="login animated fadeInUp animate3"
        						class="loginfont" name="mem_email" type="text" required
        						placeholder="이메일" value=""> 
        					<input
        						class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_nick" type="text" required placeholder="닉네임"
        						value=""> 
        					<!--  옵셥을 통해서 성별 변경하기 -->
        					<select
        						class="login animated fadeInUp animate3 loginfont"
        						name="mem_gender" id="gender" required>
        						<option value="M">남성</option>
        						<option value="F">여성</option>
        					</select>
        					
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="height" type="text" required placeholder="키" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="weight" type="text" required placeholder="몸무게" value="">
        				</fieldset>
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
                        <form class="login-form" action="Login.do" method="post">
                            <div class="panel-switch animated fadeIn">
                                <button type="button" id="chg_login">Login</button>
                                <button type="button" id="chg_join">SignUp</button>
                            </div>
                            <h1 class="animated fadeInUp animate1" id="title-login">FITNEEDS 로그인</h1>
                            <fieldset id="login-fieldset">
        					<input class="login animated fadeInUp animate2" class="loginfont"
        						name="mem_id" type="text" required placeholder="id" value="">
        					<input class="login animated fadeInUp animate3" class="loginfont"
        						name="mem_pw" type="password" required placeholder="pw" value="">
        					</fieldset>
                            <input type="submit" id="login-form-submit" class="login_form button animated fadeInUp animate4" value="로그인">
                        </form>
                    </div>`;
		// chg_join 함수 연결
		document.getElementById("chg_join").addEventListener("click", chg_join);
		// chg_login 함수 삭제
		document.getElementById("chg_login").removeEventListener("click", chg_login);
	}
});
function goNaver() {
	location.href = apiURL;
}
