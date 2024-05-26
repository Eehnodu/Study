<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <!-- 경로 바꿔야함-->
    <link rel="stylesheet"  href="assets/css/demo_1/intro.css">
    <!-- CSS -->

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
</head>
<body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/scrollify/1.0.19/jquery.scrollify.min.js"></script>

    <!--메인 상단바 -->
    <header id="header">
        <nav class="menu">
            <ul>
                <li><img role="button" src="assets/images/intro/rogo.png" alt="FitNeeds" class="headerfitImg"></li>
                <li>
                	<a href="http://localhost:8080/GitProject/fitjoin.do">
                		<img role="button" src ="assets/images/intro/introbtn3.png" 
                		class="headerImg">
                	</a>
                	</li>
            </ul>
        </nav>
    </header>

    <!--page1-->
    <div class="panel home active" data-section-name="">
        <div class="shape">
            <div class="home1Img">
                 <!-- 텍스트 이미지 교체 구간-->
                <img src="assets/images/intro/home1.png" alt="대한민국 1등 건강관리 앱">
                 <!-- 텍스트 이미지 교체 구간-->
            </div>
            <h3 class="hometest">우리의 건강이야기 지금 시작합니다</h3>
            <div class="home"></div>
            <div class="home2Img">
                 <!-- 이미지 교체 구간-->
                <img src="assets/images/intro/home2.png" alt="우리의 마스코트">
                 <!-- 이미지 교체 구간-->
            </div>
        </div>
    </div>

    <!--page2-->
    <div class="panel panel2" data-section-name="">
        <div class="shape">
            <div class="panel21Img">
                 <!-- 텍스트 이미지 교체 구간-->
                <img src="assets/images/intro/panel21.png" alt="문구">
                 <!-- 텍스트 이미지 교체 구간-->
            </div>
            <h3 class="panel2test"></h3>
            <div class="home"></div>
            <div class="panel22Img">
                 <!--  이미지 교체 구간-->
                <img src="assets/images/intro/hell.png" alt="자기관리 이미지">
                <!--  이미지 교체 구간-->
            </div>
        </div>
    </div>

    <!--page3-->
    <div class="panel panel1" data-section-name="">
        <div class="shape">
            <div class="swiper-container" style="width: 100%; height: 70%;">
                <div class="swiper-wrapper">
                    <div class="swiper-slide active"><img src="assets/images/intro/s1.png" alt="1번"></div>
                    <div class="swiper-slide"><img src="assets/images/intro/s2.png" alt="test"></div>
                    <div class="swiper-slide"><img src="assets/images/intro/s3.png" alt="test"></div>
                    <div class="swiper-slide"><img src="assets/images/intro/s4.png" alt="test"></div>
                    <div class="swiper-slide"><img src="assets/images/intro/rogo.png" alt="test"></div>
                </div>

                <div class="swiper-pagination"></div> <!--자동이동-->
                <div class="swiper-button-prev"></div> <!--버튼이전-->
                <div class="swiper-button-next"></div> <!--버튼다음-->
            </div>
        </div>
    </div>



    <div class="panel panel1" data-section-name="">
        <div class="shape">
            <div class="swiper-container" style="width: 100%; height: 70%;">
                <div class="swiper-wrapper">
                    <div class="swiper-slide active"><img src="assets/images/banner/slide1.jpg" alt="1번"></div>
                    <div class="swiper-slide"><img src="assets/images/banner/slide2.jpg" alt="test"></div>
                    <div class="swiper-slide"><img src="assets/images/banner/slide3.jpg" alt="test"></div>
                    <div class="swiper-slide"><img src="assets/images/banner/slide4.jpg" alt="test"></div>
                    <div class="swiper-slide"><img src="assets/images/banner/slide5.jpg" alt="test"></div>
                </div>

                <div class="swiper-pagination"></div> <!--자동이동-->
                <div class="swiper-button-prev"></div> <!--버튼이전-->
                <div class="swiper-button-next"></div> <!--버튼다음-->
            </div>
        </div>
    </div>




    <!--page4-->
    <div class="panel panel3" data-section-name="">
        <div class="shape">
            <div class="panel31Img">
                <img src="assets/images/intro/sulmung.png" alt="대한민국 1등 건강관리 앱">
            </div>
            <div class="home"></div>
            <div class="imgzip">
                <div class="panel32Img">
                    <img src="assets/images/intro/eximg.png" alt="우리의 마스코트">
                </div>
            </div>
        </div>
    </div>

    <!--page5-->
    <div class="panel panel4" data-section-name="">
        <div class="shape">
            <div class="panel41Img">
                <img src="assets/images/intro/final.png" alt="대한민국 1등 건강관리 앱">
            </div>
            <h5 class="panel4test">
                (주)FitNeeds<br>
                광주 광산구 월곡산정로 80 13층<br>
                <br>
                사업자번호 : 123-12-1231241243<br>
                통신판매업 : 광주 광산구 123<br>
                전자금융분쟁처리 TEL : 1234-1234 FAX :  02-123-1234<br>
                MAIL : kws1234@naver.com
            </h3>
        </div>
    </div>

</body>
<!-- JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/scrollify/1.0.19/jquery.scrollify.min.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script type="text/javascript" src="assets/js/intro.js"></script>
<script>
    var swiper = new Swiper('.swiper-container', {
        loop: true,
        autoplay: {
            delay: 3000, // 3초마다 슬라이드 이동
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
</script>

</html>>