package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.db.BoardMapper;
import com.smhrd.model.BoardVO;

@Controller // 기능이 정의되어있음.
public class BoardController {
	
	@Autowired // ******가장 중요*******
	private BoardMapper mapper;

	// 글쓰기 기능을 수행하는 메소드 생성
	@PostMapping("/regester")
	public String regester(BoardVO vo) {
		mapper.register(vo);
		return "redirect:/";
	}
	
	// 글쓰기 페이지로 이동하는 메소드 생성
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/") 
	public String board(Model model) {
		List<BoardVO> list = mapper.boardList();
		model.addAttribute("list", list);
		return "board";
	}
	
	// 글 상세조회 기능
	@GetMapping("/boardContent/{idx}")
	public String boardContent(@PathVariable("idx") int idx, Model model) {
		BoardVO result = mapper.boardContent(idx);
		model.addAttribute("item", result);
		return "boardContent";
	}
	
	// 글 삭제 기능
	@GetMapping("/boardDelete/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) {
		mapper.boardDelete(idx);
		return "redirect:/";
	}
	
}
