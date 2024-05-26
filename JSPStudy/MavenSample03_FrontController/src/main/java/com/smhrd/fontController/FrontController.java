package com.smhrd.fontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.controller.Command;
import com.smhrd.controller.Join;
import com.smhrd.controller.Login;
import com.smhrd.controller.Logout;
import com.smhrd.controller.SelectAll;
import com.smhrd.controller.Update;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	// 모든 요청은 반드시 FC를 거쳐서만 넘아갈 수 있게끔 설계
	// 이유는?
	// > 중복되는 코드 방지
	// > HttpServlet 엄청 무겁고, 자원을 많이 차지함. Servlet역할을 하는 파일을 한개만 놔둠

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. uri 가져오기
		String uri = request.getRequestURI();
		// 2. cp(ContextPath) 가져오기
		String cp = request.getContextPath();
		// 3. uri에서 cp 자르기
		// ex) /web/Login.do --> Login.do
		String path = uri.substring(cp.length() + 1);

		// 중복코드1. 한글인코딩 잡아주기
		request.setCharacterEncoding("UTF-8");
		// 4. 최종경로가 무엇으로 끝나는지에 따라 서로 다른 기능을 실행

		String finalPath = null;
		Command com = null;

		// 4-1. Join.do와 최종경로가 같다면 회원가입 기능을 실행
		if (path.equals("Join.do")) {
			com = new Join();

		} else if (path.equals("Login.do")) {
			com = new Login();

		} else if (path.equals("Logout.do")) {
			com = new Logout();

		} else if (path.equals("SelectAll.do")) {
			com = new SelectAll();

		} else if (path.equals("Update.do")) {
			com = new Update();
		}

		finalPath = com.execute(request, response);

		if (finalPath.contains("redirect:/")) {
			response.sendRedirect(finalPath.split("/")[1] + ".jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(finalPath + ".jsp");
			rd.forward(request, response);
		}

	}

}
