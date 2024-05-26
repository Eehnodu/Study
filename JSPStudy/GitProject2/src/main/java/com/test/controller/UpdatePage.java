package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.database.DAO;
import com.test.model.MemberVO;

public class UpdatePage implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAO dao = new DAO();

		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String mem_id = membervo.getMem_id();

		// 개인정보수정 페이지 이동
		return "redirect:/fitupdateForm.do";
	}
}
