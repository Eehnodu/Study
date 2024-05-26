package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글 인코딩 잡아주기
		request.setCharacterEncoding("UTF-8");
		// 2. 요청 데이터 꺼내오기(4개)
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		// 3. 요청 데이터를 하나로 묶어주기
		MemberVO vo = new MemberVO(email, pw, tel, address);
		// 4. DAO 객체 생성하기
		DAO dao = new DAO();
		// 5. DAO안에 있는 회원가입 기능 사용하기
		int row = dao.join(vo);
		if (row > 0) {
			request.setAttribute("email", email);
			// 6. 회원가입 성공한다면, join_success.jsp로 forward 방식으로 이동
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
			rd.forward(request, response);
		} else {
			// 7. 회원가입 실패한다면, main.jsp로 redirect 방식으로 이동
			response.sendRedirect("main.jsp");
		}

	}

}
