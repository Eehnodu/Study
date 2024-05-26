package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

public class Login implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPw(pw);

		DAO dao = new DAO();
		MemberVO resultVO = dao.login(vo);

		if (resultVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", resultVO);
			return "redirect:/main";
		} else {
			return "redirect:/main";
		}
	}
}
