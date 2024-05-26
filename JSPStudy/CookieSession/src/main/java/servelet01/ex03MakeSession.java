package servelet01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MakeSession")
public class ex03MakeSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. session을 가져오기
		HttpSession session = request.getSession();
		
		// 2. session에 데이터를 저장하기
		ArrayList<String> list = new ArrayList<String>();
		list.add("김이박");
		session.setAttribute("testsession", list);
		
		// Object value = new ArrayList<String>();
		// * Upcasting이 일어난다.
		// 자식클래스가 부모클래스로 자동 형변환
		
		// 3. Ex02_GetSession.jsp로 redirect방식을 사용해서 이동
		response.sendRedirect("Ex02_GetSession.jsp");
		
		// session을 삭제하는 방법
		// session.invalidate();
		// --> 모든 데이터를 삭제하는게 일반적이므로 위의 코드 사용하기!
		
		// session.removeAttribute("name값");
		
		// 쿠키(장바구니 데이터 / 트랙킹)
		// 저장위치 : 웹 브라우저(Client)
		// 저장가능한 자료형 : String
		// 생명주기 : 지정한 생명만큼 유지될 수 있음
		// 보안성 : 세션보다는 떨어짐
		// 속도 : 빠름
		
		// 세션(로그인 정보 유지)
		// 저장위치 : Server
		// 저장가능한 자료형 : 모든 자료형
		// 생명주기 : 브라우저가 종료되기 전까지
		// 보안성 : 쿠키보다는 나음
		// 속도 : 느림
		// ** 세션을 너무 많이 사용하게되면 서버 속도가 엄청 느려짐
	
	}

}
