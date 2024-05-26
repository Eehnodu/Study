package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.database.DAO;
import com.test.model.FitnessCenterVO;

public class FitCenterInfo implements Command{
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String trn_name = request.getParameter("trn_name");
		
		DAO dao = new DAO();
		FitnessCenterVO fitvo = dao.fit_center(trn_name);
		
		PrintWriter out;
		try {
			out = response.getWriter();
			Gson gson = new Gson();
			String json = gson.toJson(fitvo);
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	        
		return null;
	}
}
