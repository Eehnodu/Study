package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.database.DAO;
import com.test.model.SentenceVO;

public class GetSentence implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Random ran = new Random();
		int idx = ran.nextInt(36)+1;
		
		DAO dao = new DAO();
		SentenceVO vo = dao.getSentence(idx);
		
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
