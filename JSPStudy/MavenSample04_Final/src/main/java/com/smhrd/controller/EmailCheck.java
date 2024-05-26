package com.smhrd.controller;




import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;

public class EmailCheck implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
				
		DAO dao = new DAO();
		
		String result = dao.EmailCheck(email);
		
		// 결과값 반환
		try {
			// try-catch가 필요한 이유는 ?
			// >> response.getWriter() 메소드 안에 IOException을 사요하려면
			//	  예외처리 하라고 잡혀져있기 때문
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
