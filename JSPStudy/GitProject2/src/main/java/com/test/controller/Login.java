package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.database.DAO;
import com.test.model.MemberVO;
import com.test.model.SaltVO;
import com.test.util.Encrypt;

public class Login implements Command{
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");

		DAO dao = new DAO();
		SaltVO saltvo = new SaltVO();

		// id와 일치하는 salt 값을 가져옴
		saltvo.setMem_id(mem_id);
		SaltVO saltResult = dao.saltLogin(saltvo);

		// salt값이 존재한다면 실행
		if (saltResult != null) {
			String mem_salt = saltResult.getMem_salt();

			String encry = Encrypt.getEncrypt(mem_pw, mem_salt);
			MemberVO vo = new MemberVO();
			vo.setMem_id(mem_id);
			vo.setMem_pw(encry);

			MemberVO result = dao.login(vo);
			
			if (result != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", result);
				
				// 로그인 성공 후 나의운동페이지(메인페이지로 이동)
				return "redirect:/fitindex.do"; 
			} else {
				// 로그인 실패 시 첫 화면으로 이동
				return "redirect:/fitjoin.do";
			}
		} else {
			
			// salt값이 존재하지 않는다면(로그인 실패 시) 첫 화면으로 이동
			return "redirect:/fitjoin.do";
		}
	}
}
