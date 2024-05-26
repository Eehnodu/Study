package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.database.DAO;
import com.test.model.AccExerciseVO;
import com.test.model.MemberVO;

public class AccEx implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");

		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String mem_id = membervo.getMem_id();

		AccExerciseVO getExCatevo = new AccExerciseVO(mem_id, start_date, end_date);
		DAO dao = new DAO();
		ArrayList<AccExerciseVO> list = (ArrayList<AccExerciseVO>) dao.getAcExCate(getExCatevo);

		// 가져온 운동카테고리 데이터를 json 형식으로 넘겨주기
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
