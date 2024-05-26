package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.database.DAO;
import com.test.model.MemberVO;
import com.test.model.PurchaseVO;

public class Purchase implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String mem_id = membervo.getMem_id();

		// AJAX 요청으로부터 값 가져오기
		String vc_idxs = request.getParameter("get_vc_idx");
		if (vc_idxs != null && !vc_idxs.isEmpty()) {
			String[] get_vc_idx = vc_idxs.split(",");
			DAO dao = new DAO();
			for (String idx : get_vc_idx) {
				int vc_idx = Integer.parseInt(idx);
				PurchaseVO vo = new PurchaseVO(mem_id, vc_idx);
				dao.insert_Purchase(vo);
			}
		} else {
		}
		return null;
	}
}
