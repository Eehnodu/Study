package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

public class Join implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		MemberVO vo = new MemberVO(email, pw, tel, address);
		DAO dao = new DAO();
		int row = dao.join(vo);

		if (row > 0) {
			request.setAttribute("email", email);
			return "join_success";
		} else {
			// redirect로 이동할때는 우리만의 약속기호를 앞쪽에 붙여주자
			// redirect:/ >> 우리만의 약속기호! 다른걸로 바꿔도 상관없음.
			return "redirect:/main";
		}
	}
}
