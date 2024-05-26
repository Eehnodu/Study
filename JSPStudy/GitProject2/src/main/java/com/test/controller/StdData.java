package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.test.database.DAO;
import com.test.model.MemberVO;
import com.test.model.StdDataVO;

public class StdData implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
		String gender = membervo.getMem_gender();
		String mem_birthdate = membervo.getMem_birthdate();

		// 생년월일 문자열을 LocalDate로 변환
		LocalDate birthdate = LocalDate.parse(mem_birthdate);
		// 현재 날짜와 생년월일을 비교하여 나이 계산
		int age = Period.between(birthdate, LocalDate.now()).getYears();

		StdDataVO stdvo = new StdDataVO(gender, age);

		DAO dao = new DAO();
		StdDataVO stddata = dao.StdPhysicalData(stdvo);

		// 가져온 변화량 데이터를 json 형식으로 넘겨주기
		// 데이터를 가져올때 std_idx값과 age값을 가져와서 나머지 필드만 json으로 변환
		PrintWriter out;
		try {
			out = response.getWriter();
			Gson gson = new Gson();
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("height", stddata.getHeight());
			jsonObject.addProperty("weight", stddata.getWeight());
			jsonObject.addProperty("bmi", stddata.getBmi());
			jsonObject.addProperty("muscle", stddata.getMuscle());
			jsonObject.addProperty("fat_per", stddata.getFat_per());
			String json = gson.toJson(jsonObject);

			out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
