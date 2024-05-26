package com.smhrd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.DAO;
import com.smhrd.model.MemberVO;

public class SelectAll implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		DAO dao = new DAO();

		ArrayList<MemberVO> list = (ArrayList<MemberVO>) dao.selectall();

		request.setAttribute("memberinfo", list);
		return "select";
	}
}
