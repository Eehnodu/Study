package com.test.FrontController;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.controller.AccCh;
import com.test.controller.AccEx;
import com.test.controller.Command;
import com.test.controller.ComparePage;
import com.test.controller.CountDate;
import com.test.controller.DeleteCalendarEvent;
import com.test.controller.FetchCalendarEvent;
import com.test.controller.FitCenterInfo;
import com.test.controller.GetSentence;
import com.test.controller.MainPage;
import com.test.controller.MonthImg;
import com.test.controller.MyData;
import com.test.controller.NaverJoinController;
import com.test.controller.Purchase;
import com.test.controller.ReservePage;
import com.test.controller.RsvCommit;
import com.test.controller.RsvInfo;
import com.test.controller.Rsv_Date;
import com.test.controller.SaveCalendarEvent;
import com.test.controller.StdData;
import com.test.controller.Unregister;
import com.test.controller.Update;
import com.test.controller.UpdateCalendarEvent;
import com.test.controller.UpdatePage;
import com.test.controller.Voucher;
import com.test.controller.WeightPage;
import com.test.controller.InputCh;
import com.test.controller.InputEx;
import com.test.controller.InputPage;
import com.test.controller.Join;
import com.test.controller.Login;
import com.test.controller.Logout;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException{
		map.put("Join.do", new Join());
		map.put("Login.do", new Login());
		map.put("InputEx.do", new InputEx()); // 누적 운동 기입
		map.put("Logout.do", new Logout()); // 로그아웃
		map.put("InputCh.do", new InputCh()); // 누적 신체변화량 입력
		map.put("MainPage.do", new MainPage()); // 메인
		map.put("ComparePage.do", new ComparePage()); // 비교
		map.put("InputPage.do", new InputPage()); // 운동입력
		map.put("ReservePage.do", new ReservePage()); // 예약
		map.put("UpdatePage.do", new UpdatePage()); // 회원정보수정페이지 이동
		map.put("Update.do", new Update()); // 회원정보수정
		map.put("Unregister.do", new Unregister());
		map.put("NaverJoin.do", new NaverJoinController()); //네이버 회원정보
		map.put("WeightPage.do", new WeightPage()); //체중 입력페이지 이동
		map.put("CalendarSave.do", new SaveCalendarEvent()); //일정추가하기
		map.put("CalendarUpdate.do", new UpdateCalendarEvent()); //일정 수정하기
		map.put("CalendarDelete.do", new DeleteCalendarEvent()); //일정 삭제하기
		map.put("MonthImg.do", new MonthImg()); // 월별 사진 가져오기
		map.put("GetSentence.do", new GetSentence()); //메인페이지 문장 가져오기
		map.put("FetchCalendarEvent.do", new FetchCalendarEvent()); // 달력에 일정 출력하기
		map.put("AccCh.do", new AccCh()); // 누적 변화량
		map.put("AccEx.do", new AccEx()); // 누적 운동
		map.put("CountDate.do", new CountDate()); // 출석률
		map.put("MyData.do", new MyData()); // 개인 데이터
		map.put("StdData.do", new StdData()); // 표준 데이터
		map.put("FitCenterInfo.do", new FitCenterInfo()); // 센터정보 가져오기
		map.put("Purchase.do", new Purchase()); // 클릭된 이용권 정보 넘겨주기
		map.put("Voucher.do", new Voucher()); // 이용권 정보 모달창에 띄우기
		map.put("RsvInfo.do", new RsvInfo()); // 예약 정보 가져오기
		map.put("Rsv_Date.do", new Rsv_Date()); // 예약 날짜 가져오기
		map.put("RsvCommit.do", new RsvCommit()); 
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String path = uri.substring(cp.length() + 1);

		String finalPath = null;
		Command com = map.get(path);
		// 우리의 화면페이지를 fit~~로 설정
		if(path.startsWith("fit")) {
			finalPath = path.replace("fit", "").replace(".do", "");
		}else {
			finalPath = com.execute(request, response);
		}
		
		if(finalPath == null) {
			
		}else if(finalPath.contains("redirect:/")) {
			String redirectPath = finalPath.substring("redirect:/".length());
		    response.sendRedirect(redirectPath);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Views/" + finalPath + ".jsp");
			rd.forward(request, response);
		}
	}
}
