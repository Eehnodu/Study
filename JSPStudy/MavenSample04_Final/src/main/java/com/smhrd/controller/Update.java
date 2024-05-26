package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

public class Update implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		MemberVO sessionVo = (MemberVO)request.getSession().getAttribute("member");
		String email =  sessionVo.getEmail();
		
		MemberVO vo = new MemberVO(email, pw, tel, address);

		DAO dao = new DAO();
		dao.update(vo);
		request.getSession().setAttribute("member", vo);
		
		return "redirect:/gomain.do";
		
	}
}
