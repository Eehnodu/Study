package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.database.DAO;
import com.test.model.MemberVO;
import com.test.model.SaltVO;
import com.test.util.Encrypt;

public class Join implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		String mem_name = request.getParameter("mem_name");
		String mem_phone = request.getParameter("mem_phone");
		String mem_birthdate = request.getParameter("mem_birthdate");
		String mem_addr = request.getParameter("mem_addr");
		String mem_email = request.getParameter("mem_email");
		String mem_nick = request.getParameter("mem_nick");
		String mem_gender = request.getParameter("mem_gender");
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));

		// SHA2 + salt 방식을 이용하여 해시화된 pw를 db에 저장
		String salt = Encrypt.getSalt();
		String encry = Encrypt.getEncrypt(mem_pw, salt);

		MemberVO vo = new MemberVO(mem_id, encry, mem_name, mem_phone, mem_birthdate, mem_addr, mem_email, mem_nick,
				mem_gender, height, weight);

		// id에 해당하는 salt 값을 tb_salt에 저장
		SaltVO saltvo = new SaltVO(mem_id, salt);

		DAO dao = new DAO();
		int row = dao.join(vo);
		int saltrow = dao.saltJoin(saltvo);

		if (row > 0 & saltrow > 0) {
			request.setAttribute("join", mem_nick);
			
			// 회원가입 성공 시 회원가입 성공 화면으로 이동
			return "redirect:/fitjoin.do";
		} else {
			
			// 회원가입 실패시 회원가입 화면으로 이동
			return "redirect:/fitjoin.do";
		}

	}

}