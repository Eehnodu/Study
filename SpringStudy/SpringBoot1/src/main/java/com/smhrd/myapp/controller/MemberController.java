package com.smhrd.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smhrd.myapp.entity.MemberEntity;
import com.smhrd.myapp.mapper.MemberMapper;
import com.smhrd.myapp.vo.MemberVO;


@Controller
public class MemberController {

	@Autowired
	private MemberMapper mapper;
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	// index.jsp를 띄워주는 메소드
	// RequestMapping() 보다 SpringBoot에선느 @GET ~ @POST Mapping을 권장
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// session 사용
//	@PostMapping("/login")
//	public String login(MemberVO vo, HttpSession session) {
//		// mapper.login(vo);
//		// JPA (mapper == repositor)
//		MemberEntity entity = mapper.findByIdAndPw(vo.getId(), vo.getPw());
//		// entity(JPA용) --> vo(java, jsp용)으로 변경
//		MemberVO myData = new MemberVO(entity.getId(), entity.getPw(), entity.getName(), entity.getTel());
//
//		// Model : request 경량화 버전
//		// --> 응답을 되돌려주기 전까지만 유효
//		session.setAttribute("entity", myData);
//		// session --> 브라우저 닫히기 전까지 유효
//	
//		return "redirect:/mypage";
//	}
	
	// 로그인기능
	@PostMapping("/login")
	public String login(MemberVO vo, RedirectAttributes rttr) {
		// mapper.login(vo);
		// JPA (mapper == repository)
		MemberEntity entity = mapper.findByIdAndPw(vo.getId(), vo.getPw());
		// entity(JPA용) --> vo(java, jsp용)으로 변경
		MemberVO myData = new MemberVO(entity.getId(), entity.getPw(), entity.getName(), entity.getTel());
		rttr.addAttribute("entity", myData.getId());
		// *주의할 점 : 들어가는 value 의 형태를 String으로 변환가능한 형태로 넣어주기
		
		// redirect:/myPage?myData = 보내준 데이터
		
		// /login 페이지 유효
		// /mypage 유효
		
		return "redirect:/mypage";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	
	@PostMapping("/join-process")
	public String join(MemberVO vo) {
		MemberEntity entity = new MemberEntity(vo);
		mapper.save(entity);
		// update sql문도 save 처리
		// save(entity)
		// --> entity안에 idx가 없으면, insert 진행
		// --> entity안에 idx가 채워져있으면, update 진행
		
		
		return "redirect:/";
	}
}
