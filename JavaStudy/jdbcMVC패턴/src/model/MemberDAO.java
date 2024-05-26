package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import com.mysql.cj.protocol.Resultset;

public class MemberDAO {
	// Data Access Object : 데이터에 접근하는 것을 도와주는 객체

	private PreparedStatement psmt = null;
	private Connection conn = null;
	private ResultSet rs = null;

	private void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jdbctest";
			String user = "root";
			String password = "12345";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int join(MemberDTO dto) {
		int row = 0;
		try {
			getConnection();
			if (conn != null) {
			} else {
				System.out.println("DB연결 실패");
			}

			String sql = "INSERT INTO jdbctest.bigdatamember VALUES (?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());
			psmt.setInt(4, dto.getAge());
			psmt.setInt(5, dto.getScore());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

////////////////////////////////////////////////////
	public MemberDTO login(String id, String pw) {
		MemberDTO dto = null;
		try {
			getConnection();

			if (conn != null) {
			} else {
				System.out.println("DB 연결 실패");
			}

			String sql = "SELECT * FROM JDBCTEST.BIGDATAMEMBER WHERE ID = ? AND PW = ? ";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next() == true) {
				String name = rs.getString("b_name");
				int age = rs.getInt("age");

				dto = new MemberDTO(null, null, name, age, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;
	}

////////////////////////////////////////////////////
	public int delete(String id, String pw) {
		int row = 0;
		try {
			getConnection();

			String sql = "DELETE FROM JDBCTEST.BIGDATAMEMBER WHERE ID = ? AND PW = ? ";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

////////////////////////////////////////////////////
	public ArrayList<MemberDTO> selectAll() {
		ArrayList<MemberDTO> arr = new ArrayList<>();
		try {
			getConnection();

			String sql = "SELECT * FROM JDBCTEST.BIGDATAMEMBER ORDER BY BIGDATAMEMBER.score desc";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("b_name");
				int age = rs.getInt("age");
				int score = rs.getInt("score");
				MemberDTO dto = new MemberDTO(id, null, name, age, score);
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return arr;
	}

////////////////////////////////////////////////////
	public int update(MemberDTO dto) {
		int row = 0;
		try {
			getConnection();

			String sql = "UPDATE JDBCTEST.BIGDATAMEMBER SET SCORE = ? WHERE ID =? AND PW =?";
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getScore());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());

			row = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}
}
