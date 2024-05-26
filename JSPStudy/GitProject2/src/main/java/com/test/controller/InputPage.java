package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.database.DAO;
import com.test.model.MemberVO;

public class InputPage implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = new DAO();

		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String mem_id = membervo.getMem_id();

		// 운동입력 페이지로 이동
		return "redirect:/fitmyhealth.do";
	}
}
