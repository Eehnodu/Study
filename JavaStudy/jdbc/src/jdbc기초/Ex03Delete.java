package jdbc기초;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex03Delete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PreparedStatement psmt = null;
		Connection conn = null;

		// 1. 사용자에게 아이디와 비밀번호 입력받기
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();

		// 2. 회원탈퇴 성공 => 회원탈퇴 성공
		// 회원탈퇴 실패 => 회원탈퇴 실패

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 1) 연결
			String url = "jdbc:mysql://localhost/jdbctest";
			String user = "root";
			String password = "12345";

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("연결 성공!");
			} else {
				System.out.println("연결 실패");
			}

			String sql = "DELETE FROM jdbctest.bigdatamember where id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			int row = psmt.executeUpdate();

			if (row > 0) {
				System.out.println("회원탈퇴 성공");
			} else {
				System.out.println("회원탈퇴 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 위에서 예외상황이 발생하더라도 반드시 한번은 들어오는 구간
			// 6. DB연결 종료 --> 자원 반납
			try {
				// ★★★자원을 반납할 때는 항상 사용한 순서의 역순으로 반납한다!!★★★
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
