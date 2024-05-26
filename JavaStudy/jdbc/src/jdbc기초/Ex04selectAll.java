package jdbc기초;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex04selectAll {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("======== 전체 회원 조회 ========");
		System.out.println("ID\t이름\t나이\t점수");

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
			} else {
				System.out.println("DB연결 실패");
			}

			String sql = "select * from jdbctest.bigdatamember";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("id") + "\t" + rs.getString("b_name") + "\t" + rs.getInt("age") + "\t"
						+ rs.getInt("score"));
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
