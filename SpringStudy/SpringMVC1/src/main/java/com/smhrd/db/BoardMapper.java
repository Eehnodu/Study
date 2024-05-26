package com.smhrd.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.smhrd.model.BoardVO;

public interface BoardMapper {
	
	// 전체 게시글을 조회해서 결과값을 반환해주는 메소드
	public List<BoardVO> boardList();
	// BoardMapper mappper = new SqlSessionFactroyBean();
	// sql session 빌려오기, 사용하기, 반납하기, 결과값 반환하기
	// mapper.boardList();
	// 모두 SqlSessionFactoryBean의 역할!!!!!!
	// 즉, Spring에서 알아서 해줌
	
	// 게시글 등록 메소드
	public int register(BoardVO vo);

	// 게시글 한 개를 조회하는 메소드
	// mybatis를 사용하는 방법
	// 1. 기존DAO 방식 --> jsp/servlet 사용했던 방식
	// 2. interface 방식 --> spring f/w 사용하는 방식
	// 3. annotation 방식 --> 비교적 간단한 sql구문일 때 사용권장
	// SELECT * FROM BOARD WHERE IDX = #{idx}
	@Select("SELECT * FROM BOARD WHERE IDX = #{idx}")
	public BoardVO boardContent(int idx);
	
	@Delete("DELETE FROM BOARD WHERE IDX = #{idx}")
	public void boardDelete(int idx);
}
