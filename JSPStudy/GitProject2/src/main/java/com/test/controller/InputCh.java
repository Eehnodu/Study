package com.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.database.DAO;
import com.test.model.AccChangeVO;
import com.test.model.AccExerciseVO;
import com.test.model.MemberVO;

public class InputCh implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		double weight = Double.parseDouble(request.getParameter("weight"));
		String ch_date = request.getParameter("ch_date");
		int ex_calories_sum = 0;
		
		DAO dao = new DAO();

		// session에 저장된 mem_id를 가져옴
		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String mem_id = membervo.getMem_id();

		// 날짜와 일치하는 ex_calories를 가져와서 총합 calories 계산
		ArrayList<AccExerciseVO> list = (ArrayList<AccExerciseVO>) dao.getAcExData(mem_id);
		for (AccExerciseVO accExercise : list) {
			if (accExercise.getEx_date().equals(ch_date)) {
				ex_calories_sum += accExercise.getEx_calories();
			}
		}
		
		// mem_id와 일치하는 height를 가져옴
		MemberVO mem_height = dao.getHeight(mem_id);
		double height = mem_height.getHeight();
		
		// 가져온 값들을 tb_accumulated_change에 저장
		AccChangeVO vo = new AccChangeVO(mem_id, height, weight, ch_date, ex_calories_sum);
		int row = dao.accChInput(vo);
		
		if (row > 0) {
			return "redirect:/fitindex.do"; // 체중입력페이지만들면 연동해야함
		} else {
			return "redirect:/fitindex.do"; // 체중입력페이지만들면 연동해야함
		}
		
	}
}
