package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class HangmanDAO {

	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	private PreparedStatement psmt = null;
	private Connection conn = null;
	private ResultSet rs = null;

	String comPath = "C:\\Users\\smhrd\\Desktop\\JavaStudy\\Project\\player\\";
	MP3Player mp3 = new MP3Player();

	// DB 환원 메소드
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

	// DB 연결 메소드
	private void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://project-db-campus.smhrd.com:3307/cgi_23K_BIG23_p1_4";
			String user = "cgi_23K_BIG23_p1_4";
			String password = "smhrd4";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원가입 메소드
	public int join(HangmanDTO dto) {
		int row = 0;
		try {
			getConnection();
			if (conn != null) {
			} else {
				System.out.println("DB연결 실패");
			}

			String sql = "INSERT INTO cgi_23K_BIG23_p1_4.user (id, pw, nickname, vip) VALUES (?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getNickname());
			psmt.setString(4, dto.getVip());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

	// 로그인 메소드
	public HangmanDTO login(String id, String pw) {
		HangmanDTO dto = null;
		try {
			getConnection();

			if (conn != null) {
			} else {
				System.out.println("DB 연결 실패");
			}

			String sql = "SELECT * FROM cgi_23K_BIG23_p1_4.user WHERE ID = ? AND PW = ? ";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next() == true) {
				String Name = rs.getString("nickname");
				String Vip = rs.getString("vip");
				int Score = rs.getInt("score");

				dto = new HangmanDTO(id, pw, Name, Score, Vip);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;
	}

	// 탈퇴 메소드
	public int delete(String id, String pw) {
		int row = 0;
		try {
			getConnection();

			String sql = "DELETE FROM cgi_23K_BIG23_p1_4.user WHERE ID = ? AND PW = ? ";
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

	// 랭킹 조회 메소드
	public ArrayList<HangmanDTO> selectAll() {
		ArrayList<HangmanDTO> arr = new ArrayList<>();
		try {
			getConnection();

			String sql = "SELECT * FROM cgi_23K_BIG23_p1_4.user ORDER BY user.score desc";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("nickname");
				String vip = rs.getString("vip");
				int score = rs.getInt("score");
				HangmanDTO dto = new HangmanDTO(null, null, name, score, vip);
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return arr;
	}

	// 접수 업데이트 메소드
	public int updateScore(HangmanDTO dto, int score) {
		int row = 0;
		try {
			getConnection();
			String sql = "SELECT * FROM cgi_23K_BIG23_p1_4.user WHERE id = ? AND pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {
				// 사용자가 존재할 경우에만 업데이트 실행
				int currentScore = rs.getInt("score");
				int updatedScore = currentScore + score;

				// 점수 업데이트
				String updateSql = "UPDATE cgi_23K_BIG23_p1_4.user SET score = ? WHERE id = ? AND pw = ?";
				psmt = conn.prepareStatement(updateSql);
				psmt.setInt(1, updatedScore);
				psmt.setString(2, dto.getId());
				psmt.setString(3, dto.getPw());
				row = psmt.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

	// 등급 업데이트 메소드
	public int updateVip(HangmanDTO dto) {
		int row = 0;
		String vip = "";
		try {
			getConnection();
			String sql = "SELECT * FROM cgi_23K_BIG23_p1_4.user WHERE id = ? AND pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {
				int score = rs.getInt("score");
				String Vip = rs.getString("vip");
				if (score < 500) {
					vip = "Bronze";
					if (Vip != vip) {
						vip = "Bronze";
					}

				} else if (score >= 500 && score < 2000) {
					vip = "Silver";
					if (Vip != vip) {
						vip = "Silver";
					}
				} else if (score >= 2000 && score < 5000) {
					vip = "Gold";
					if (Vip != vip) {
						vip = "Gold";
					}
				} else if (score >= 5000) {
					vip = "GOAT★";
					if (Vip != vip) {
						vip = "GOAT★";
					}
				}
				String sql2 = "update cgi_23K_BIG23_p1_4.user set vip = ? where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql2);
				psmt.setString(1, vip);
				psmt.setString(2, dto.getId());
				psmt.setString(3, dto.getPw());
				row = psmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

	// HighWord 불러오는 메소드
	public ArrayList<HighWordDTO> hWordsAll() {

		ArrayList<HighWordDTO> hWords = new ArrayList<HighWordDTO>();

		try {

			getConnection();

			String sql = "select * from cgi_23K_BIG23_p1_4.words_high";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				hWords.add(new HighWordDTO(rs.getInt("high_id"), rs.getString("words"), rs.getString("means"),
						rs.getString("hint1"), rs.getString("hint2"), rs.getString("hint3")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			getClose();

		}
		return hWords;
	}

	// MidWord 불러오는 메소드
	public ArrayList<MidWordDTO> mWordsAll() {

		ArrayList<MidWordDTO> mWords = new ArrayList<MidWordDTO>();

		try {

			getConnection();

			String sql = "select * from cgi_23K_BIG23_p1_4.words_mid";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				mWords.add(new MidWordDTO(rs.getInt("mid_id"), rs.getString("words"), rs.getString("means"),
						rs.getString("hint1"), rs.getString("hint2"), rs.getString("hint3")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return mWords;
	}

	// LowWord 불러오는 메소드
	public ArrayList<LowWordDTO> lWordsAll() {

		ArrayList<LowWordDTO> lWords = new ArrayList<LowWordDTO>();

		try {

			getConnection();

			String sql = "select * from cgi_23K_BIG23_p1_4.words_low";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				lWords.add(new LowWordDTO(rs.getInt("low_id"), rs.getString("words"), rs.getString("means"),
						rs.getString("hint1"), rs.getString("hint2"), rs.getString("hint3")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			getClose();

		}
		return lWords;
	}

	// HangmanGame 메소드
	public int hangmangame(ArrayList<? extends WordDTO> t) {
		int count = 0;
		int score = 0;
		int num = ran.nextInt(20);
		String word = t.get(num).getWords(); // 단어 가져오기

		// 가져온 word를 배열에 저장
		char[] arr = new char[word.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = word.charAt(i);
		}
		System.out.print("\t\t\t");

		// 가져온 word를 " _ "로 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" _ ");
		}
		System.out.println();
		// 입력한 알파벳을 저장할 배열
		ArrayList<Character> insertArr = new ArrayList<>();

		// 알파벳을 맞출 때 저장할 배열
		Character[] answerArr = new Character[word.length()];
		System.out.println();

		char[] alpaArr = new char[26];
		for (int i = 0; i < alpaArr.length; i++) {
			alpaArr[i] = (char) (97 + i); // a-z 배열
			System.out.print(alpaArr[i] + "\t");
			if (i == 8 || i == 17) {
				System.out.println();
			}
		}

		System.out.println();
		hang(); // 사형대 그리기

		// 행맨 게임(알파벳 맞추기)
		while (count <= 6) {

			boolean found = false; // 알파벳이 틀렸을 시, count하기 위해 변수 선언
			boolean allNotNull = true; // 알파벳을 전부 맞췄을 시 확인하기 위한 변수

			// 한글자의 알파벳 입력
			System.out.print(" 알파벳을 입력해 주세요 >> ");
			char alpa = sc.next().charAt(0);

			// 알파벳이 아닌 다른 걸 입력시 다시 실행
			while (true) {
				if (alpa >= 0x61 && alpa <= 0x7A) { // 소문자
					break;
				} else if (alpa >= 0x41 && alpa <= 0x5A) {
					alpa = Character.toLowerCase(alpa); // 대문자 입력시 소문자로 바꿔주는..
					break;

				} else {
					System.out.println(" (ノ｀Д)ノ다시 입력해 주세요"); // 알파벳이 아닌 다른 걸 입력시 다시 입력 받음
					System.out.print("\n알파벳을 입력해 주세요 >> ");
					alpa = sc.next().charAt(0);
				}
			}
			System.out.println();
			// 입력한 알파벳을 insertArr배열에 저장
			insertArr.add(alpa);
			while (true) {
				for (int i = 0; i < insertArr.size(); i++) {
					if (i >= 1) {
						if (insertArr.get(i - 1) == alpa) {
							System.out.println(" (ﾟДﾟ*)ﾉ 입력한 알파벳입니다");
							insertArr.remove(insertArr.size() - 1);
							found = true;
						}
					}
				}
				break;
			}

			// arr과 alpa가 일치할 경우 answerArr배열에 alpa값 삽입
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == alpa) {
					answerArr[i] = alpa;
					found = true; // 맞췄을시 true로 바뀜
				}
			}
			// answerArr에 들어있는 값 출력
			if (count <= 6) {
				System.out.print("\t\t\t");
				for (int i = 0; i < answerArr.length; i++) {
					if (answerArr[i] == null) {
						System.out.print(" _ ");
					} else {
						System.out.print(" " + answerArr[i] + " ");
					}
				}
			}
			System.out.println();
			System.out.println();
			// 한번 고른 것은 ★ 모양으로 바꿔줌
			for (int i = 0; i < alpaArr.length; i++) {
				if (alpaArr[i] == alpa) {
					alpaArr[i] = '★';
				}
			}

			// 별 모양으로 바뀐 배열 출력
			for (int i = 0; i < alpaArr.length; i++) {
				System.out.print(alpaArr[i] + "\t");
				if (i == 8 || i == 17) {
					System.out.println();
				}
			}

			System.out.println();

			// answerArr이 전부 null이 아니라면 게임을 종료
			for (int i = 0; i < answerArr.length; i++) {
				if (answerArr[i] == null) {
					allNotNull = false;
					break;
				}
			}
			if (allNotNull) {
				// instanceof >> 객체의 타입을 비교하는 법
				if (t instanceof ArrayList<?> && t.get(0) instanceof LowWordDTO) {
					// t가 ArrayList<LowWordDTO> 타입이라면 이곳의 코드를 실행
					score = 20 + (6 - count) * 10;
				} else if (t instanceof ArrayList<?> && t.get(0) instanceof MidWordDTO) {
					// t가 ArrayList<MidWordDTO> 타입이라면 이곳의 코드를 실행
					score = 45 + (6 - count) * 20;
				} else if (t instanceof ArrayList<?> && t.get(0) instanceof HighWordDTO) {
					// t가 ArrayList<HighWordDTO> 타입이라면 이곳의 코드를 실행
					score = 80 + (6 - count) * 30;
				}
				successBgm();
				System.out.println("\n o(￣▽￣)ｄ 행맨을 살렸습니다\n");
				break;
			}
			// 알파벳를 맞추지 못했다면 count값 증가
			if (!found) {
				count++;
			}
			// count가 6을 넘어가면 행맨 종료
			if (count > 6) {
				System.out.println("\n (;´༎ຶД༎ຶ`) 행맨을 살리지 못했습니다.\n\n (～￣▽￣)～정답은");
				System.out.print(" [");
				for (char ch : arr) {
					System.out.print(" " + ch + " ");
				}
				System.out.println("]");
				System.out.println();
				sreamBgm();
				break;
			}

			// count가 2,4,6일 때 힌트 출력
			if (count >= 2) {
				System.out.print("\n 힌트1 : " + t.get(num).getHint1() + "\t");
			}
			if (count >= 4) {
				System.out.print(" 힌트2 : " + t.get(num).getHint2() + "\t");
			}
			if (count == 6) {
				System.out.print(" 힌트3 : " + t.get(num).getHint3() + "\t");
			}
			// 행맨 그리기
			System.out.println();
			switch (count) {
			case 0:
				hang();
				break;
			case 1:
				head();
				break;
			case 2:
				body();
				break;
			case 3:
				armRight();
				break;
			case 4:
				armLeft();
				break;
			case 5:
				legRight();
				break;
			case 6:
				legLeft();
				break;
			}
		}
		return score;
	}

	// 시작 배경음 BGM
	public void startBgm() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(comPath + "rope.mp3");
	}

	// 알파벳이 틀렸을 경우 BGM
	public void errorBgm() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(comPath + "error.mp3");
	}

	// 프로그램 종료 BGM
	public void endBgm() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(comPath + "end.mp3");
	}

	// 정답을 못 맞췄을 경우 BGM
	public void sreamBgm() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(comPath + "scream.mp3");
	}

	// 정답일 경우 BGM
	public void successBgm() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(comPath + "success.mp3");
	}

	// 0. 고리
	public void hang() {
		String asciiArt = "                                                                                                    \n"
				+ "                          .@**===============!;:-,,,,,,,,,,,;*                                       \n"
				+ "                          .#.                               ,$                                       \n"
				+ "                          .#.                               ,#                                       \n"
				+ "                          .#.                              ,-@                                       \n"
				+ "                          .#.                                                                         \n"
				+ "                          .#.                                                                         \n"
				+ "                          .#.                                                                         \n"
				+ "                          .#.                                                                         \n"
				+ "                          .#.                                                                         \n"
				+ "                          .#.                                                                         \n"
				+ "                          .#.                                                                        \n"
				+ "                          .#.                                                                        \n"
				+ "                          =!                                        	                                \n"
				+ "                          #;                                                                         \n"
				+ "                          @:                                                                         \n"
				+ "                         .@~                                                                        \n"
				+ "                         .@-                                                                        \n"
				+ "                         !;                                                                        \n"
				+ "                         *:                                                                        \n"
				+ "                         =,                                                                        \n"
				+ "                         =.                                                                        \n"
				+ "                         $.                                                                        \n"
				+ "                         #                                                                         \n"
				+ "                         #                                                                        \n"
				+ "                         #                                                                        \n"
				+ "                        .#                                                                        \n"
				+ "                        .#                                                                         \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        !@!                                                                         \n"
				+ "     -!$##@@@@@@@@@@@@@@@@@@@@@@@@@@@######@@@=                                                     \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n";
		System.out.println(asciiArt);
	}

	// 1. 머리
	public void head() {
		String asciiArt = "                                                                                                    \n"
				+ "                          .@**===============!;:-,,,,,,,,,,,;*                                       \n"
				+ "                          .#.                               ,$                                       \n"
				+ "                          .#.                               ,#                                       \n"
				+ "                          .#.                              ,-@                                       \n"
				+ "                          .#.                             $!:;$@-                                    \n"
				+ "                          .#.                           =!.   .*#~                                   \n"
				+ "                          .#.                          .#.      :#.                                  \n"
				+ "                          .#.                          @;       =!                                   \n"
				+ "                          .#.                          $!      ;@,                                   \n"
				+ "                          .#.                          .#:.   :#~                                    \n"
				+ "                          .#.                           ~#$$$$#~                                     \n"
				+ "                          .#.                                                                        \n"
				+ "                          =!                                        	                                \n"
				+ "                          #;                                                                         \n"
				+ "                          @:                                                                         \n"
				+ "                         .@~                                                                        \n"
				+ "                         .@-                                                                        \n"
				+ "                         !;                                                                        \n"
				+ "                         *:                                                                        \n"
				+ "                         =,                                                                        \n"
				+ "                         =.                                                                        \n"
				+ "                         $.                                                                        \n"
				+ "                         #                                                                         \n"
				+ "                         #                                                                        \n"
				+ "                         #                                                                        \n"
				+ "                        .#                                                                        \n"
				+ "                        .#                                                                         \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        !@!                                                                         \n"
				+ "     -!$##@@@@@@@@@@@@@@@@@@@@@@@@@@@######@@@=                                                     \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n";
		System.out.println(asciiArt);
	}

	// 2. 몸통
	public void body() {

		String asciiArt = "                                                                                                    \n"
				+ "                          .@**===============!;:-,,,,,,,,,,,;*                                       \n"
				+ "                          .#.                               ,$                                       \n"
				+ "                          .#.                               ,#                                       \n"
				+ "                          .#.                              ,-@                                       \n"
				+ "                          .#.                             $!:;$@-                                    \n"
				+ "                          .#.                           =!.   .*#~                                   \n"
				+ "                          .#.                          .#.      :#.                                  \n"
				+ "                          .#.                          @;       =!                                   \n"
				+ "                          .#.                          $!      ;@,                                   \n"
				+ "                          .#.                          .#:.   :#~                                    \n"
				+ "                          .#.                           ~#$$$$#~                                     \n"
				+ "                          .#.                             :=#;                                       \n"
				+ "                          =!                               *$                                        \n"
				+ "                          #;                               *$.                                       \n"
				+ "                          @:                              .$@#                                       \n"
				+ "                         .@~                               =$.                                      \n"
				+ "                         .@-                               =*                                      \n"
				+ "                         !;                               :!                                       \n"
				+ "                         *:                              ~@!                                       \n"
				+ "                         =,                                                                        \n"
				+ "                         =.                                                                        \n"
				+ "                         $.                                                                       \n"
				+ "                         #                                                                        \n"
				+ "                         #                                                                        \n"
				+ "                         #                                                                        \n"
				+ "                        .#                                                                        \n"
				+ "                        .#                                                                         \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        !@!                                                                         \n"
				+ "     -!$##@@@@@@@@@@@@@@@@@@@@@@@@@@@######@@@=                                                     \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n";
		System.out.println(asciiArt);

	}

	// 3. 오른쪽팔
	public void armRight() {
		String asciiArt = "                                                                                                    \n"
				+ "                          .@**===============!;:-,,,,,,,,,,,;*                                       \n"
				+ "                          .#.                               ,$                                       \n"
				+ "                          .#.                               ,#                                       \n"
				+ "                          .#.                              ,-@                                       \n"
				+ "                          .#.                             $!:;$@-                                    \n"
				+ "                          .#.                           =!.   .*#~                                   \n"
				+ "                          .#.                          .#.      :#.                                  \n"
				+ "                          .#.                          @;       =!                                   \n"
				+ "                          .#.                          $!      ;@,                                   \n"
				+ "                          .#.                          .#:.   :#~                                    \n"
				+ "                          .#.                           ~#$$$$#~                                     \n"
				+ "                          .#.                             :=#;                                       \n"
				+ "                          =!                               *$       ..;!!                            \n"
				+ "                          #;                               *$.  ,:=@@!                                \n"
				+ "                          @:                              .$@#$*!;-                                  \n"
				+ "                         .@~                               =$.                                      \n"
				+ "                         .@-                               =*                                      \n"
				+ "                         !;                               :!                                       \n"
				+ "                         *:                              ~@!                                       \n"
				+ "                         =,                                                                        \n"
				+ "                         =.                                                                        \n"
				+ "                         $.                                                                        \n"
				+ "                         #                                                                         \n"
				+ "                         #                                                                        \n"
				+ "                         #                                                                        \n"
				+ "                        .#                                                                        \n"
				+ "                        .#                                                                         \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        !@!                                                                         \n"
				+ "     -!$##@@@@@@@@@@@@@@@@@@@@@@@@@@@######@@@=                                                     \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n";
		System.out.println(asciiArt);
	}

	// 4. 왼쪽 팔
	public void armLeft() {
		String asciiArt = "                                                                                                    \n"
				+ "                          .@**===============!;:-,,,,,,,,,,,;*                                       \n"
				+ "                          .#.                               ,$                                       \n"
				+ "                          .#.                               ,#                                       \n"
				+ "                          .#.                              ,-@                                       \n"
				+ "                          .#.                             $!:;$@-                                    \n"
				+ "                          .#.                           =!.   .*#~                                   \n"
				+ "                          .#.                          .#.      :#.                                  \n"
				+ "                          .#.                          @;       =!                                   \n"
				+ "                          .#.                          $!      ;@,                                   \n"
				+ "                          .#.                          .#:.   :#~                                    \n"
				+ "                          .#.                           ~#$$$$#~                                     \n"
				+ "                          .#.                             :=#;                                       \n"
				+ "                          =!                    !!,         *$       ..;!!                            \n"
				+ "                          #;                     '!@=:,    *$.  ,:=@@!                                \n"
				+ "                          @:                          `*!*$#@#$*!;-                                  \n"
				+ "                         .@~                               =$.                                      \n"
				+ "                         .@-                               =*                                      \n"
				+ "                         !;                               :!                                       \n"
				+ "                         *:                              ~@!                                       \n"
				+ "                         =,                                                                        \n"
				+ "                         =.                                                                        \n"
				+ "                         $.                                                                        \n"
				+ "                         #                                                                         \n"
				+ "                         #                                                                        \n"
				+ "                         #                                                                        \n"
				+ "                        .#                                                                        \n"
				+ "                        .#                                                                         \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        !@!                                                                         \n"
				+ "     -!$##@@@@@@@@@@@@@@@@@@@@@@@@@@@######@@@=                                                     \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n";
		System.out.println(asciiArt);

	}

	// 5. 오른쪽 다리
	public void legRight() {
		String asciiArt = "                                                                                                    \n"
				+ "                          .@**===============!;:-,,,,,,,,,,,;*                                       \n"
				+ "                          .#.                               ,$                                       \n"
				+ "                          .#.                               ,#                                       \n"
				+ "                          .#.                              ,-@                                       \n"
				+ "                          .#.                             $!:;$@-                                    \n"
				+ "                          .#.                           =!.   .*#~                                   \n"
				+ "                          .#.                          .#.      :#.                                  \n"
				+ "                          .#.                          @;       =!                                   \n"
				+ "                          .#.                          $!      ;@,                                   \n"
				+ "                          .#.                          .#:.   :#~                                    \n"
				+ "                          .#.                           ~#$$$$#~                                     \n"
				+ "                          .#.                             :=#;                                       \n"
				+ "                          =!                    !!,         *$       ..;!!                            \n"
				+ "                          #;                     '!@=:,    *$.  ,:=@@!                                \n"
				+ "                          @:                          `*!*$#@#$*!;-                                  \n"
				+ "                         .@~                               =$.                                      \n"
				+ "                         .@-                               =*                                      \n"
				+ "                         !;                               :!                                       \n"
				+ "                         *:                              ~@!                                       \n"
				+ "                         =,                             :@*#=.                                     \n"
				+ "                         =.                                 =#-                                    \n"
				+ "                         $.                                  !@~                                  \n"
				+ "                         #                                    ;#.                                 \n"
				+ "                         #                                      !#,                                \n"
				+ "                         #                                       #=                                \n"
				+ "                        .#                                                                         \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        !@!                                                                         \n"
				+ "     -!$##@@@@@@@@@@@@@@@@@@@@@@@@@@@######@@@=                                                     \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n";
		System.out.println(asciiArt);
	}

	// 6. 왼쪽 다리
	public void legLeft() {
		String asciiArt = "                                                                                                    \n"
				+ "                          .@**===============!;:-,,,,,,,,,,,;*                                       \n"
				+ "                          .#.                               ,$                                       \n"
				+ "                          .#.                               ,#                                       \n"
				+ "                          .#.                              ,-@                                       \n"
				+ "                          .#.                             $!:;$@-                                    \n"
				+ "                          .#.                           =!.   .*#~                                   \n"
				+ "                          .#.                          .#.      :#.                                  \n"
				+ "                          .#.                          @;       =!                                   \n"
				+ "                          .#.                          $!      ;@,                                   \n"
				+ "                          .#.                          .#:.   :#~                                    \n"
				+ "                          .#.                           ~#$$$$#~                                     \n"
				+ "                          .#.                             :=#;                                       \n"
				+ "                          =!                    !!,         *$       ..;!!                            \n"
				+ "                          #;                     '!@=:,    *$.  ,:=@@!                                \n"
				+ "                          @:                          `*!*$#@#$*!;-                                  \n"
				+ "                         .@~                               =$.                                      \n"
				+ "                         .@-                               =*                                      \n"
				+ "                         !;                               :!                                       \n"
				+ "                         *:                              ~@!                                       \n"
				+ "                         =,                             :@*#=.                                     \n"
				+ "                         =.                           .!#-  =#-                                    \n"
				+ "                         $.                           $#,    !@~                                  \n"
				+ "                         #                          .@*       ;#.                                 \n"
				+ "                         #                         :#:         !#,                                \n"
				+ "                         #                        ;@~           #=                                \n"
				+ "                        .#                                                                         \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        !@!                                                                         \n"
				+ "     -!$##@@@@@@@@@@@@@@@@@@@@@@@@@@@######@@@=                                                     \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n";
		System.out.println(asciiArt);
	}

	// 메인화면
	public void hangmanimage() {
		String asciiArt = "                                                                                                    \n"
				+ "                          .@**===============!;:-,,,,,,,,,,,;*                                       \n"
				+ "                          .#.                               ,$                                       \n"
				+ "                          .#.                               ,#                                       \n"
				+ "                          .#.                              ,-@                                       \n"
				+ "                          .#.                             $!:;$@-                                    \n"
				+ "                          .#.                           =!.   .*#~                                   \n"
				+ "                          .#.                          .#.      :#.                                  \n"
				+ "                          .#.                          @;       =!                                   \n"
				+ "                          .#.                          $!      ;@,                                   \n"
				+ "                          .#.                          .#:.   :#~                                    \n"
				+ "                          .#.                           ~#$$$$#~                                     \n"
				+ "                          .#.                             :=#;                                       \n"
				+ "                          =!                               *$       ..;!!                            \n"
				+ "                          #;                               *$.  ,:=@@!                                \n"
				+ "                          @:                              .$@#$*!;-                                  \n"
				+ "                         .@~                               =$.                                      \n"
				+ "                         .@-                               =*                                      \n"
				+ "                         !;                               :!                                       \n"
				+ "                         *:                              ~@!                                       \n"
				+ "                         =,                             :@*#=.                                     \n"
				+ "                         =.                           .!#-  =#-                                    \n"
				+ "                         $.                           $#,    !@~                                  \n"
				+ "                         #                          .@*       ;#.                                 \n"
				+ "                         #                         :#:         !#,                                \n"
				+ "                         #                        ;@~           #=                                \n"
				+ "                        .#                                                                        \n"
				+ "                        .#                                                                         \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        .#                                                                          \n"
				+ "                        !@!                                                                         \n"
				+ "     -!$##@@@@@@@@@@@@@@@@@@@@@@@@@@@######@@@=                                                     \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n"
				+ "                                                                                                    \n"
				+ "       .    .~                                                                               *-     \n"
				+ "       !;   ;#                                                                               @-     \n"
				+ "       *~   *=         ,*-             *-                    .   ,         .                ,@,     \n"
				+ "       $,   *!         !@$             $:                   *#  *#.       ;#.         .-    ~@.     \n"
				+ "       $,   =;        .$-$~       ;   .$-                   @#=~@#,       $#!         $#!   :@      \n"
				+ "       #:~:!#:        ;* ;$      .@,  .#.                  -#-@#!*~      -=~=         #;#!  :#      \n"
				+ "      .@$$$$@-       ;@#$#@.     =@@~ .#.                  *$ *= !:      $!-#.        @:-#: ;$      \n"
				+ "       #,. .$,       =$~~~@:     @!:#,,#                   =*    !:     -@@#@-       .@; ~#~**      \n"
				+ "       #.  .$.      ,#-   $!     @; ;#~#                   $~    !;     !$. ;!       .@:  ;@#:      \n"
				+ "       #.  .$       :=    -$.    ,.   #;                   ,;     ;;     !=   .#!                   \n"
				+ "       $.   .       --     =.                               -:                     .@:  ;*          \n"
				+ "       ,                                                         -.    ~,    -:                     \n"
				+ "       .,-~~~~~:!-   --,.....                                                                       \n"
				+ "      .$$=======*-  .*=$$$$$$:   !======;    ,;*=$$##$:    :#$$====:   ;======*.    -:;!**===*.     \n"
				+ "                        .....    -~~~~~~-    .!:~-,...      ..,-~~~,   ,~~~~~~~     *=!;:~~~~~       ";

		System.out.println(asciiArt);
	}

}
