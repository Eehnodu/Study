package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.database.DAO;
import com.test.model.AccChangeVO;
import com.test.model.MemberVO;

public class AccCh implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// JSON 형식으로 응답하기 위해 content type 변경
		response.setContentType("application/json; charset=utf-8");

		// 입력한 start_date와 end_date 가져오기
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");

		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String mem_id = membervo.getMem_id();

		AccChangeVO accChangeVO = new AccChangeVO(mem_id, start_date, end_date);
		DAO dao = new DAO();
		ArrayList<AccChangeVO> list = (ArrayList<AccChangeVO>) dao.getAccChangeData(accChangeVO);

		// 가져온 변화량 데이터를 json 형식으로 넘겨주기
		PrintWriter out;
		try {
			out = response.getWriter();
			Gson gson = new Gson();
			String json = gson.toJson(list);

			out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
