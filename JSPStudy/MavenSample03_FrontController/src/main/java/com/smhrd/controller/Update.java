package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

public class Update implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		HttpSession session = request.getSession();
		String email = ((MemberVO) session.getAttribute("member")).getEmail();

		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPw(pw);
		vo.setTel(tel);
		vo.setAddress(address);

		DAO dao = new DAO();
		int row = dao.update(vo);

		if (row > 0) {
			session.setAttribute("info", vo);
			return "redirect:/main";
		} else {
			return "redirect:/main";
		}
	}
}
