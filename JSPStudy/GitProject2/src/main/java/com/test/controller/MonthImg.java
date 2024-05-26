package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.database.DAO;
import com.test.model.MonthImgVO;

public class MonthImg implements Command{
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int month = java.time.LocalDate.now().getMonthValue();
		
        DAO dao = new DAO();
        MonthImgVO vo = dao.getMonthImgSen(month);
        // 문장 데이터를 JSON 형식으로 변환
        PrintWriter out;
		try {
			out = response.getWriter();
			String json = new Gson().toJson(vo);
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return null;
	}
}
