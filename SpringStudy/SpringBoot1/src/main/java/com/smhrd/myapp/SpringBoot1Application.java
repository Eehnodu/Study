package com.smhrd.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// SpringBoot 프로젝트으 시작지점
@SpringBootApplication
// @SpringBootConfiguration
// : SpringBoot의 전반적인 환경설정을 담당
// @EnableAutoConfiguration
// : jar 파일을 경로상에 놔두기만 하면, 필요한 객체들을 자동으로 생성, 사용
// @ComponentScan : 해당 경로를 기준으로 하위 패키지에 있는 Bean을 자동으로 SpringBootContainer에 등로
// 위 3개의 annotation을 하나로 함해놓은 @SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}

}
