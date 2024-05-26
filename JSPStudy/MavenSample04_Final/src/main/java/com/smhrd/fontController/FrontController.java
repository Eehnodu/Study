package com.smhrd.fontController;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.controller.Command;
import com.smhrd.controller.EmailCheck;
import com.smhrd.controller.Join;
import com.smhrd.controller.Login;
import com.smhrd.controller.Logout;
import com.smhrd.controller.SelectAll;
import com.smhrd.controller.Update;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// (Command - String)
	private HashMap<String, Command> map = new HashMap<String, Command>();

	// Servlet 생명주기
	// > tomcat 관리 > 생성 ~ 소멸
	// 1) 생성자 호출 2) init 초기화메소드 호출 3) service 메소드 호출 4) destroy 호출
	@Override
	public void init() throws ServletException {
		// map 자료구조에 경로-실행시켜야되는 클래스 파일들을 하나씩 추가
		map.put("Join.do", new Join());
		map.put("Login.do", new Login());
		map.put("Logout.do", new Logout());
		map.put("SelectAll.do", new SelectAll());
		map.put("Update.do", new Update());
		map.put("EmailCheck.do", new EmailCheck());
		// 새로운 기능을 만들때마다 map 자료구조안에
		// 경로 - 실행해야하는 클래스 한세트로 묶어서 추가해주기만 하면 됨
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI(); // ex)/smhrd/gomain.do
		String cp = request.getContextPath(); // ex)/smhrd
		String path = uri.substring(cp.length() + 1); // ex)gomain.do

		String finalPath = null;
		Command com = map.get(path);

		if (path.startsWith("go")){
			// go가 포함이 되어있다면, DAO를 사용하지 않고, .jsp 파일로 이동하겠다.
			// gomain.do --> main
			// goupdate.do --> update
			// path --> 일부분만 가지고오는 로직
			
			finalPath = path.replace("go", "").replace(".do", "");
		} else {
			finalPath = com.execute(request, response);
		}
		
		if(finalPath == null) {
			// 비동기 통신일때는 이동해야하는 경로가 없으니까! 조건을 그냥 하나만 잡아주기!!!
		}
		else if (finalPath.contains("redirect:/")) {
			response.sendRedirect(finalPath.split("/")[1]);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Views/"+finalPath+".jsp");
			rd.forward(request, response);
		}
	}
}
