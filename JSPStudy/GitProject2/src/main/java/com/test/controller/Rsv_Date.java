package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.database.DAO;
import com.test.model.PersonalTrainingVO;

public class Rsv_Date implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out;
		try {
			out = response.getWriter();
			String trn_idx = request.getParameter("trn_idx");


			if (trn_idx != null && !trn_idx.isEmpty()) {
				String[] get_trn_idx = trn_idx.split(",");
				DAO dao = new DAO();
				for (String idx : get_trn_idx) {
					int trnidx = Integer.parseInt(idx);
					ArrayList<PersonalTrainingVO> vo = dao.PT(trnidx);
					Gson gson = new Gson();

					String json = gson.toJson(vo);

					out.print(json);
				}
			} else {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
