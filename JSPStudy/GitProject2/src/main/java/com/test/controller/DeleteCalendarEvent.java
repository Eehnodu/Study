package com.test.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.database.DAO;

public class DeleteCalendarEvent implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int calIdx = Integer.parseInt(request.getParameter("cal_idx"));
		
        DAO dao = new DAO();
        dao.deleteCalendarEvent(calIdx);
		return null;
	}
}
