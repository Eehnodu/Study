package com.test.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.database.DAO;
import com.test.model.CalendarEventVO;
import com.test.model.MemberVO;
import com.test.model.ReserveVO;

public class RsvCommit implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html; charset=utf-8");

        // 세션에서 회원 정보 가져오기
        MemberVO membervo = (MemberVO) request.getSession().getAttribute("member");
        if (membervo == null) {
            // 세션이 없는 경우 로그인 페이지로 리다이렉트 등의 처리를 수행할 수 있음
            try {
                response.sendRedirect("login.jsp");
            } catch (IOException e) {
                e.printStackTrace(); // 또는 로깅 라이브러리를 사용하여 로그에 기록
            }
            return null;
        }
        String mem_id = membervo.getMem_id();

        try {
            // 클라이언트로부터 전송된 JSON 데이터 읽기
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
            reader.close();

            // JSON 데이터 파싱
            ObjectMapper mapper = new ObjectMapper();
            ReserveVO[] reservations = mapper.readValue(jsonData.toString(), ReserveVO[].class);
            String title = "PT";
            String backgroundColor = "red";
            
            // 예약 정보 처리
            if (reservations != null && reservations.length > 0) {
                DAO dao = new DAO();
                for (ReserveVO reservation : reservations) {
                    dao.RsvCommit(mem_id, reservation.getPt_idx(), reservation.getCreated_at(),
                            reservation.getRes_status());
                    CalendarEventVO calvo = new CalendarEventVO(mem_id, title, reservation.getCreated_at(), reservation.getEndTime(), backgroundColor);
                    dao.saveCalendarEvent(calvo);
                }
                response.getWriter().println("예약이 완료되었습니다.");
            } else {
                response.getWriter().println("예약할 항목이 선택되지 않았습니다.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // 또는 로깅 라이브러리를 사용하여 로그에 기록
        }

        return null;
    }
}
