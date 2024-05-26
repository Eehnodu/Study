package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex00_Create")
public class Ex00_Create extends HttpServlet {
	// 컴파일 (.java -> .class) 과정에서 데이터 저장시 빠르게 정리할 수 있는
	// 일종의 아이디 지정!
	private static final long serialVersionUID = 1L;
    
	// 기본 생성자 메소드
	// 초기화 작업을 진행할 수 있는 메소드!
    public Ex00_Create() {
        super();
        System.out.println("생성자 메소드 호출");
    }

    // 서블릿의 시작을 알리는 메소드!
    // 서블릿의 초기화 작업을 진행하는 메소드 -> 서블릿 객체 생성시 최초 한번만 진행!
	public void init(ServletConfig config) throws ServletException {
	}
	
	// 서블릿 종료시 호출되는 메소드 -> 종료시 마지막에 한번만 호출되는 메소드
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}

	// 클라이언트 오청을 받아 서비스를 진행하는 메소드!
	// 여러번 동작이 가능하다!
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 메소드 호출");
		
		// 서비스를 제공하는 형태!
		doGet(request, response);
		doPost(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget 응답");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost 응답");
	}

}
