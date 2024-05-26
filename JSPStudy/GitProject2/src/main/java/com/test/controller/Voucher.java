package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.controller.Command;
import com.test.database.DAO;
import com.test.model.VoucherVO;

public class Voucher implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		String trn_name = request.getParameter("trn_name");

		DAO dao = new DAO();
		ArrayList<VoucherVO> vouchervo = dao.voucher(trn_name);

		PrintWriter out;
		try {
			out = response.getWriter();
			Gson gson = new Gson();
			String json = gson.toJson(vouchervo);
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
