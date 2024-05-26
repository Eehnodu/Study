package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.database.DAO;
import com.test.model.AccChangeVO;
import com.test.model.CountDateVO;
import com.test.model.MemberVO;

public class CountDate implements Command{
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json; charset=utf-8");

		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String mem_id = membervo.getMem_id();

		// 오늘 날짜 획득
		LocalDate endDate = LocalDate.now();
		// 해당 월의 시작일 계산
		LocalDate startDate = endDate.withDayOfMonth(1);

		// 오늘과 해당 월의 시작일 사이의 일 수 계산
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;
		int daysBetweenInt = (int) daysBetween;
		AccChangeVO accChangeVO = new AccChangeVO(mem_id, startDate.toString(), endDate.toString());
		DAO dao = new DAO();
		ArrayList<AccChangeVO> list = dao.getCountDate(accChangeVO);

		// 해당월의 1일부터 오늘날짜까지 총 일수 계산
		int count_date = 0;
		for (AccChangeVO count : list) {
			count_date++;
		}

		// 총 날짜수에서 운동한 날짜를 빼서 미운동 날짜 계산
		int nocount_date = daysBetweenInt - count_date;

		CountDateVO countdate = new CountDateVO(nocount_date, count_date);

		// 계산된 countdate 데이터를 json 형식으로 넘겨주기
		PrintWriter out;
		try {
			out = response.getWriter();
			Gson gson = new Gson();
			String json = gson.toJson(countdate);

			out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
