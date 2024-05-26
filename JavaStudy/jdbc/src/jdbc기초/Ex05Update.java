package jdbc기초;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex05Update {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원정보 수정 =====");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();
		System.out.print("수정할 점수 입력 : ");
		int newscore = sc.nextInt();

		PreparedStatement psmt = null;
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/jdbctest";
			String user = "root";
			String password = "12345";

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
			} else {
				System.out.println("DB연결 실패");
			}

			String sql = "UPDATE jdbctest.bigdatamember SET score = ? where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, newscore);
			psmt.setString(2, id);
			psmt.setString(3, pw);

			int row = psmt.executeUpdate();

			if (row > 0) {
				System.out.println("갱신 성공");
			} else {
				System.out.println("갱신 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (psmt != null) {
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
