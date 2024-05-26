package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_login
 */
@WebServlet("/Ex01_login")
public class Ex01_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(id.equals("smart") && pwd.equals("123")) {
			out.print(id +"님 환영합니다");	
		}else {
			out.print("로그인에 실패하였습니다.");
		}
		
	}

}
