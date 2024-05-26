package com.smhrd.database;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.model.MemberVO;

public class DAO {

	// Data Access Object
	// 데이터에 접근하는 객체

	// 1. 필드
	// DBCP 꺼내오기
	// factory == Connection 객체들을 가지고 있는 공간
	private SqlSessionFactory factory = MySqlSessionManager.getSqlSessionFactory();

	public int join(MemberVO vo) {
		// 1. 연결객체 빌려오기
		SqlSession session = factory.openSession(true);
		// 2. 연결객체 사용하기
		// *공통*
		// 매개변수 한개 >> Mapper파일의 sql구문 id값
		// 매개변수 두개 >> id값 , 보내줘야하는 데이터
		// session.insert() : insert구문
		// session.delete() : delete구문
		// session.update() : update구문
		// session.selectOne() : select구문인데, 가져와야하는 데이터가 한 개일 때 사용
		// session.selectList() : select구문인데, 가져와야하는 데이터가 여러 개일 때 사용
		int row = session.insert("join", vo);
		// 3. 연결객체 반납하기
		session.close();
		return row;
	}

	public MemberVO login(MemberVO vo) {
		SqlSession session = factory.openSession();
		MemberVO result = session.selectOne("login", vo);
		// --> select 기능을 수행하고 난 결과 자료형은 제네릭 기법으로 결정된다.
		// 제네릭 기법이란?
		// : 클래스 내부(SqlSession)에서 사용해야하는 자료형 클래스 외부(DAO)에서 결정하는 기법
		session.close();
		return result;
	}

	public int update(MemberVO vo) {
		SqlSession session = factory.openSession();
		int row = session.update("update", vo);
		session.commit();
		session.close();
		return row;
	}

	public ArrayList<MemberVO> selectall() {
		SqlSession session = factory.openSession();
		ArrayList<MemberVO> list = new ArrayList<>(session.selectList("selectall"));
		session.close();
		return list;
	}

}
