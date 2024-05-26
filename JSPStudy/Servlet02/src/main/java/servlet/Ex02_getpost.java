package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02_getpost")
public class Ex02_getpost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// post 방식일때!
		request.setCharacterEncoding("utf-8");
		
		
		
		String name = request.getParameter("name");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("입력한 이름 : " + name);
		
		
		request.setCharacterEncoding("utf-8");
		// 클라이언트가 전송한 요청 데이터 인코딩 방식 지정
		
		response.setCharacterEncoding("utf-8");
		// 클라이언트가 전송할 응답 데이터 인코딩 방식 지정
		
		response.setContentType("charset=utf-8");
		// 클라이언트에 응답할 페이지 환경설정
		// 브라우저마다 문자 해석 방식이 다르기 때문에
	}

}
