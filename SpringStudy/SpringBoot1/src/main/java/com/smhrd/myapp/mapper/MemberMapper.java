package com.smhrd.myapp.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.myapp.entity.MemberEntity;


//@Mapper // Bean으로 등록하기 위한 annotation
@Repository
public interface MemberMapper extends JpaRepository<MemberEntity, Long>{
	
	// Spring MVC
	// SqlSessionFactoryBean 구현체를 만들어서 사용
	// Springboot
	// Hibernate 구현체를 만들어서 사용
	// --> SpringbootContainer 안쪽에 해당 클래스가 등록되어있어야함
	
	
	// JPA에서 제공해주는 기본 CRUD 메소드
	// 1. findAll()
	// --> SELECT * FROM T(ex)MEMBER_ENTITY))
	// 2. findById(pk값)
	// --> SELECT * FROM T(ex)MEMBER_ENTITY)) WHERE PK컬럼명 = 매개변수
	// 3. save(받아올 매개변수 순서대로 OR Entity 형태)
	// --> INSERT INTO T(ex)MEMBER_ENTITY)) VALUES(?,?,?,?)
	// 4. delete()
	// --> DELETE FROM T(ex)MEMBER_ENTITY)) WHERE PK컬럼명 = 매개변수
	
	// 프로젝트에서 간단한 SQL 구문만 사용한다 --> JPA 사용하기
	// 복잡한 SQL 구문 사용한다 --> Mybatis Mapper 사용하기
	
	// 메소드명을 기준으로 sql 구문을 생성
	// SELECT 규칙
	// find + 테이블명(생략가능) + By + 컬럼명 + And(or) + 컬럼명
	// *주의할 점 : 반드시 카멜식으로 작성해야 함*
	
	// SELECT * FROM MEMBER_ENTITY
	// WHERE ID = ?
	// AND PK = ?
	
	public MemberEntity findByIdAndPw(String id, String pw);
	// ** 주의할 점!! SELECT 구문의 조건절 데이터를 채울 때는 매개변수의 순서대로 채워준다.**
	//						매개변수의 순서대로 채워진다.
}
