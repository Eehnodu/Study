package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.db.BoardMapper;
import com.smhrd.model.BoardVO;
import com.smhrd.model.SearchCriteria;


// Rest = Representational State Transfer
@RestController // @ResponseBody +  @Controller를 합친 기능
public class BoardRestController {
	
	@Autowired // ******가장 중요*******
	private BoardMapper mapper;

	// 검색 기능
	@GetMapping("/search")
	public List<BoardVO> search(SearchCriteria criteria) {
		List<BoardVO> result = mapper.search(criteria);
		return result; // return 된 값이 화면에 출력
		// list에는 주소값이 담겨져있다! 우리가 비동기통신으로 보내줘야하는 데이터는 json구조다!!
		// 주소값 -- 변환 --> json
		// 변환을 spring에서 자동으로 진행! (라이브러리 하나 필요)
	}
	
	// 작성자 리스트 조회
	@GetMapping("/autocomplete")
	public List<BoardVO> autocomplete(SearchCriteria criteria) {
		List<BoardVO> result = mapper.autocomplete(criteria);
		return result;
	}
}
