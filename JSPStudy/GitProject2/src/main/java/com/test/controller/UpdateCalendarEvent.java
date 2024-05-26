package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.database.DAO;
import com.test.model.CalendarEventVO;

public class UpdateCalendarEvent implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String startStr = request.getParameter("start");
		String endStr = request.getParameter("end");
		String color = request.getParameter("color");
		int calIdx = Integer.parseInt(request.getParameter("cal_idx"));
		
        // JSON 데이터 처리
        CalendarEventVO vo = new CalendarEventVO(calIdx, title, startStr, endStr, color);
		
        DAO dao = new DAO();
        dao.updateCalendarEvent(vo);
		return null;
	}
}
