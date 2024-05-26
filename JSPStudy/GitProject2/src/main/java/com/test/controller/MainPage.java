package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.database.DAO;
import com.test.model.MemberVO;

public class MainPage implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = new DAO();

		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String mem_id = membervo.getMem_id();

		// 나의운동페이지(메인페이지)로 이동
		return "redirect:/fitindex.do";
	}
}
