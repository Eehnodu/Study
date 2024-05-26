package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 입력받은 데이터 가져오기
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
			System.out.println(email);
			System.out.println("성공");
			session.setAttribute("info", vo);
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("main.jsp");
		}
	}

}
