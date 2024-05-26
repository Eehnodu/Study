package com.smhrd.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.myapp.dto.MemberDTO;
import com.smhrd.myapp.entity.Member;
import com.smhrd.myapp.repo.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ServiceController {
	
	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/join-process")
	public String join(MemberDTO dto) {
		Member entity = new Member(dto.getUserid(), dto.getPw(), "user", encoder);
		repo.save(entity);
		return "redirect:/";
	}
	
	@PostMapping("/login-process")
	public String login(MemberDTO dto, HttpSession session) {
		Member entity = repo.findByUseridAndPw(dto.getUserid(), dto.getPw());
		if(entity != null) {
			session.setAttribute("mydata", entity);
			return "redirect:/dashboard";
		}
		return "redirect:/";
	}
}
