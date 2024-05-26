package com.smhrd.myapp.entity;

import com.smhrd.myapp.vo.MemberVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity annotation이 안나오면 JPA 라이브러리르 안가져온거다
@Entity // DB에 있는 Table을 표현하는 자료형
@Data // getter, setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
	
	public MemberEntity(MemberVO vo) {
		this.id = vo.getId();
		this.pw = vo.getPw();
		this.name = vo.getName();
		this.tel = vo.getTel();
	}
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long idx;
	// JPA 쓰려면 필수!!!!!!!
	
	// 유니크, 길이, null 허용 등등
	@Column(unique = true) // 해당 컬럼에 대한 설정값
	private String id;
	@Column(length = 200)
	private String pw;
	@Column(nullable = false)
	private String name;
	@Column()
	private String tel;
	
	
}
