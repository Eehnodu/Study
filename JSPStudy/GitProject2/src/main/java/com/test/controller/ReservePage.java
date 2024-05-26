package com.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.database.DAO;
import com.test.model.TrainerVO;

public class ReservePage implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		DAO dao = new DAO();
		ArrayList<TrainerVO> list = (ArrayList<TrainerVO>)dao.select_trn_list();
		
		request.setAttribute("trainer_info", list);
		// 예약페이지로 이동
		return "ex_rsv";
	}
}
