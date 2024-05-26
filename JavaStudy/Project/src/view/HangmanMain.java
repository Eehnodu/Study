package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.HangmanDAO;
import model.HangmanDTO;
import model.HighWordDTO;
import model.LowWordDTO;
import model.MidWordDTO;

public class HangmanMain {

	public static void main(String[] args) {
		boolean logincheck = false;
		Scanner sc = new Scanner(System.in);
		HangmanDAO dao = new HangmanDAO();
		ArrayList<LowWordDTO> lList = dao.lWordsAll();
		ArrayList<MidWordDTO> mList = dao.mWordsAll();
		ArrayList<HighWordDTO> hList = dao.hWordsAll();

		System.out.println("★☆★☆★☆★☆★☆★☆★행맨 게임을 시작합니다★☆★☆★☆★☆★☆★☆★");
		dao.hangmanimage();
		System.out.println();
		boolean isRunning = true;
		

		// 메인화면
		while (isRunning) {
			// 게임 시작 BGM
			dao.startBgm();
			System.out.print("[1]로그인 [2]회원가입 [3]회원탈퇴 [4]랭킹조회 [5]종료 >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				// 로그인 처리
				System.out.println();
				System.out.println("|==========로그인을 수행합니다==========|");
				System.out.print(" ID 입력 : ");
				String id = sc.next();
				System.out.print(" 비밀번호 입력 : ");
				String pw = sc.next();
				System.out.println("|=======================================|");
				System.out.println();

				HangmanDTO dto = dao.login(id, pw);
				logincheck = false; // 로그인이 되었는지 확인할 함수

				// 성공
				if (dto != null) {
					System.out.println(" ╰(*°▽°*)╯[" + dto.getNickname() + "(" + dto.getVip() + ")]╰(*°▽°*)╯");
					System.out.println("      (￣┰￣*)[" + dto.getScore() + "점](￣┰￣*)");
					System.out.println();
					logincheck = true;
				}
				// 실패
				else {
					System.out.print(" ※ 로그인에 실패했습니다.");
					System.out.println(" 아이디와 비밀번호를 확인해주세요 ※");
					System.out.println();
					logincheck = false;
				}

				if (logincheck == true) {
					while (true) {
						// 기회 count 선언언 및 초기화
						System.out.println("|=========난이도선택 및 로그아웃=========|");
						System.out.print(" [1]하 [2]중 [3]상 [4]뒤로가기 >> ");
						int nan = sc.nextInt();
						System.out.println();

						// 행맨게임의 결과를 저장할 변수 선언
						int score = 0;

						// 하 게임 실행
						if (nan == 1) {
							// 하 난이도의 행맨게임 실행
							score = dao.hangmangame(lList);
							dao.updateScore(dto, score);
							dao.updateVip(dto);
							System.out.println(" " + score + "점을 획득했습니다!ヾ(^▽^*)))");
							System.out.println();
						}
						// 중 게임 실행
						else if (nan == 2) {
							// 중 난이도의 행맨게임 실행
							score = dao.hangmangame(mList);
							dao.updateScore(dto, score);
							dao.updateVip(dto);
							System.out.println(" " + score + "점을 획득했습니다!ヾ(^▽^*)))");
							System.out.println();
						}
						// 상 게임 실행
						else if (nan == 3) {
							// 상 난이도의 행맨게임 실행
							score = dao.hangmangame(hList);
							dao.updateScore(dto, score);
							dao.updateVip(dto);
							System.out.println(score + "점을 획득했습니다!ヾ(^▽^*)))");
							System.out.println();

						} else if (nan == 4) {
							System.out.println("\n[뒤로 가기를 선택했습니다. 메인 메뉴로 돌아갑니다]\n");
							logincheck = false;
							break;
						} else {
							System.out.println("╰（‵□′）╯ 숫자를 잘못 입력하였습니다. 다시 선택해주세요. ╰（‵□′）╯");
						}
					}
				}
			} else if (choice == 2) {
				// 회원가입 처리
				System.out.println();
				System.out.println("|========회원가입을 수행합니다========|");
				System.out.print(" ID 입력 : ");
				String id = sc.next();
				System.out.print(" PW 입력 : ");
				String pw = sc.next();
				System.out.print(" 닉네임 입력 : ");
				String nickname = sc.next();
				System.out.println("|=====================================|");
				System.out.println();

				HangmanDTO dto = new HangmanDTO(id, pw, nickname, null);
				int row = dao.join(dto);

				if (row > 0) {
					System.out.println(" (☞ﾟヮﾟ)☞ 회원가입 성공 ☜(ﾟヮﾟ☜) ");
					System.out.println();
				} else {
					System.out.println(" ಥ_ಥ 회원가입 실패 ಥ_ಥ ");
					System.out.println();
				}

			} else if (choice == 3) {
				// 회원탈퇴 처리
				System.out.println();
				System.out.println("|=========회원탈퇴를 수행합니다=========|");
				System.out.print("┌( ಠ_ಠ)┘ 탈퇴할 ID 입력 : ");
				String id = sc.next();
				
				System.out.print("(ノ｀Д)ノ 탈퇴할 ID의 PW 입력 : ");
				String pw = sc.next();
				System.out.println("|=======================================|");
				System.out.println();
				int row = dao.delete(id, pw);

				if (row > 0) {
					System.out.println(" ಥ_ಥ 계정이 탈퇴되었습니다. ಥ_ಥ"); // 탈퇴 성공
					System.out.println();
				} else {
					System.out.println(" ಥ_ಥ ID와 PW를 다시 확인해주세요 ಥ_ಥ"); // 탈퇴 실패
					System.out.println();
				}

			} else if (choice == 4) {
				// 랭킹조회 처리
				System.out.println();
				System.out.println("|==============랭킹 조회를 수행합니다=============|");
				System.out.println(" ★☆★☆★☆★☆★☆전체 회원 조회☆★☆★☆★☆★");
				System.out.println("\t랭킹\t이름\t등급\t점수");

				ArrayList<HangmanDTO> arr = dao.selectAll();

				for (int i = 0; i < arr.size(); i++) {
					System.out.println("\t" + (i + 1) + "\t" + arr.get(i).getNickname()+ "\t" + arr.get(i).getVip()
							+ "\t" + arr.get(i).getScore());
				}
				System.out.println(" ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println();
			} else if (choice == 5) {
				// 종료 처리
				System.err.println();
				System.out.println(" (ﾉ*ФωФ)ﾉ 게임이 종료되었습니다. (ﾉ*ФωФ)ﾉ");
				isRunning = false;//
				break;

			} else {
				// 숫자를 잘못 입력 했을 시
				System.out.println();
				System.out.println("  ಥ_ಥ 숫자를 잘못 입력하였습니다. 다시 선택해주세요.  ಥ_ಥ");
			}
		}
		dao.endBgm();
		sc.close();

	}
}
