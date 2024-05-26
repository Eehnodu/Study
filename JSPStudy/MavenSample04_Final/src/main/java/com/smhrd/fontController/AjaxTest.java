package com.smhrd.fontController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.smhrd.model.MemberVO;

@WebServlet("/Ajax")
public class AjaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 출력데이터 한글 인코딩
		response.setContentType("text/html; charset=utf-8");
		
		System.out.println("요청이 들어옴");
		// ex)Ajax?sendData=안녕
		String data = request.getParameter("sendData");
		System.out.println(data);
	
		// DAO사용해서 DB 데이터조회하기
		// 조회 성공!!
		// 결과값을 반환
		// ★ 비동기통신을 통해서 결과값을 반환하기 위해서는 화면에 반환하고 싶은 데이터가 출력되면 된다
		// 1) 출력객체 꺼내오기
		PrintWriter out = response.getWriter();
		// 2) 출력해주기		
		MemberVO vo = new MemberVO();
		vo.setEmail("admin");
		vo.setTel("01012345678");
		vo.setAddress("광주광역시");
		
		Gson gson = new Gson();
		String json = gson.toJson(vo);

		// java 객체 --> js 객체 변환
		// json형태로 변환
		out.print(json);
	}
}
