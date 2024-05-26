package Question6;

import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===뮤직 플레이어====");
		ArrayList<String> titleArr = new ArrayList<>();
		ArrayList<String> singerArr = new ArrayList<>();
		ArrayList<Integer> pTArr = new ArrayList<>();

		while (true) {
			System.out.print("1.등록 2.목록 3.삭제 4.전체삭제 5.종료 >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("====등록====");
				System.out.print("제목 : ");
				String title = sc.next();
				System.out.print("가수 : ");
				String singer = sc.next();
				System.out.print("시간 : ");
				int playTime = sc.nextInt();
				MusicVO mu = new MusicVO(title, singer, playTime);
				titleArr.add(title);
				singerArr.add(singer);
				pTArr.add(playTime);

			} else if (choice == 2) {
				System.out.println("====노래목록====");
				for (int i = 1; i <= titleArr.size(); i++) {
					System.out.print(i + ". 제목 : " + titleArr.get(i - 1) + "\t가수 : " + singerArr.get(i - 1) + "\t시간 : "
							+ pTArr.get(i - 1));
					System.out.println();

				}

			} else if (choice == 3) {
				System.out.println("====노래목록====");
				for (int i = 1; i <= titleArr.size(); i++) {
					System.out.print(i + ". 제목 : " + titleArr.get(i - 1) + "\t가수 : " + singerArr.get(i - 1) + "\t시간 : "
							+ pTArr.get(i - 1));
					System.out.println();
				}
				System.out.println("====노래삭제====");
				System.out.print("삭제하고 싶은 노래 번호 입력 : ");
				int select = sc.nextInt();
				if (select != 0) {
					titleArr.remove(select - 1);
					singerArr.remove(select - 1);
					pTArr.remove(select - 1);
				}
			} else if (choice == 4) {
				System.out.println("====전체노래삭제====");
				titleArr.clear();
				singerArr.clear();
				pTArr.clear();
				System.out.println("전체 노래가 삭제되었습니다.");
			} else if (choice == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("정확한 숫자를 입력해주세요.");
			}
		}
	}

}
