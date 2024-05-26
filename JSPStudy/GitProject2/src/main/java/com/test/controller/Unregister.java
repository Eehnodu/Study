package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.database.DAO;
import com.test.model.MemberVO;

public class Unregister implements Command{
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		
		DAO dao = new DAO();
		dao.unregister(membervo);
		
		// 회원탈퇴후 회원가입 페이지로 이동
		return "redirect:/fitjoin.do";
	}
}
