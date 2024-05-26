package jdbc기초;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex02Login {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 로그인
		// 1. 사용자에게 아이디와 비밀번호 입력받기
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();

		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DB연결 통로 열기(url, user, password)
			String url = "jdbc:mysql://localhost/jdbctest";
			String user = "root";
			String password = "12345";

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("DB연결 성공");
			} else {
				System.out.println("DB연결 실패");
			}

			// 3. 쿼리문 준비
			// 로그인 기능 >> 테이블에 일치하는 데이터가 있는지 확인 >> select
			// 아이디와 비밀번호가 일치하는 데이터의 모든 컬럼을 가져오는 쿼리문
			String sql = "select * from jdbctest.bigdatamember where id = ? and pw = ? ";

			psmt = conn.prepareStatement(sql);

			// ? 인자를 채우는 작업
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			// ResultSet이란?
			// : 조회된 데이터를 테이블과 같은 형태로 표현해주는 집합 자료구조!
			// : cursor를 가지고 있다. (처음에는 column을 가리키고 있음)
			// : cursor가 가리키고 있는 데이터만 가져올 수 있음.
			// rs.next() --> cursor를 내리는 메소드
			if (rs.next()) {
				String name = rs.getString("b_name");
				int age = rs.getInt("age");
				System.out.println(name + "(" + age + ")" + "님 환영합니다.");
			} else {
				System.out.println("로그인에 실패했습니다.");
				System.out.println("아이디와 비밀번호를 확인해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				} else if (psmt != null) {
					psmt.close();
				} else if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
