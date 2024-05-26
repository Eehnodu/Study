package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.test.database.DAO;
import com.test.model.CalendarEventVO;
import com.test.model.MemberVO;

public class FetchCalendarEvent implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json; charset=utf-8"); // JSON 형식으로 응답하기 위해 content type 변경

        MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
        String mem_id = membervo.getMem_id();

        DAO dao = new DAO();
        ArrayList<CalendarEventVO> list = (ArrayList<CalendarEventVO>) dao.fetchCalendarEvent(mem_id);

        // Gson 객체 생성
        Gson gson = new Gson();

        // JSON 배열 생성
        JsonArray jsonArray = new JsonArray();
        for (CalendarEventVO event : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", event.getcal_idx());
            jsonObject.addProperty("title", event.getTitle());
            jsonObject.addProperty("start", event.getStart().formatted(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
            jsonObject.addProperty("end", event.getEnd().formatted(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
            jsonObject.addProperty("backgroundColor", event.getBackgroundColor());
            jsonArray.add(jsonObject);
        }

        // JSON 문자열로 변환
        String json = gson.toJson(jsonArray);

        // 응답으로 JSON 문자열을 클라이언트에게 전송합니다.
        PrintWriter out;
		try {
			out = response.getWriter();
			out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
