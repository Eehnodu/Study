package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.database.DAO;
import com.test.model.TrainerVO;

public class RsvInfo implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		String trn_name = request.getParameter("trn_name");
		DAO dao = new DAO();

		TrainerVO trnvo = dao.selectTrainer(trn_name);
		trnvo.setTrn_name(trn_name);
		PrintWriter out;
		try {
			out = response.getWriter();
			Gson gson = new Gson();
			String json = gson.toJson(trnvo);
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
