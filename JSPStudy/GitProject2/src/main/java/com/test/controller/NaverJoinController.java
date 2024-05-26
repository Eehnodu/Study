package com.test.controller;

import com.test.database.DAO;
import com.test.model.MemberVO;
import com.test.model.SaltVO;
import com.test.util.Encrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NaverJoinController implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String birthday = request.getParameter("birthday");
		String birthyear = request.getParameter("birthyear");
		String nickName = request.getParameter("nickName");

		request.setAttribute("email", email);
		request.setAttribute("name", name);
		request.setAttribute("mobile", mobile);
		request.setAttribute("birthday", birthday);
		request.setAttribute("birthyear", birthyear);
		request.setAttribute("nickName", nickName);
		return "join";

	}

}