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

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPw(pw);
		DAO dao = new DAO();
		
		MemberVO resultVO = dao.login(vo);
		
		if(resultVO != null) {
			// System.out.println("성공"); 
			HttpSession session = request.getSession();
			session.setAttribute("member",resultVO);
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("main.jsp");
		}
		
	}

}
