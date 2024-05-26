package MVC;

import javazoom.jl.player.MP3Player;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MusicController con = new MusicController();

		System.out.println("======김이박의 Mp3플레이어======");

		while (true) {
			System.out.print("[1]재생 [2]정지 [3]이전곡 [4]다음곡 [5]종료 >> ");
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("======재생======");
				Music m = con.play();

				System.out.println(m.getSinger() + " - " + m.getTitle() + "이(가) 재생중입니다.");

			} else if (input == 2) {
				System.out.println("======정지======");
				if (con.stop() == true) {
					System.out.println("노래 재생을 정지합니다.");
				} else {
					System.out.println("재생 중인 노래가 없습니다.");
				}
			} else if (input == 3) {
				System.out.println("======이전곡======");
				Music m = con.before();
				
				if(m == null) {
					System.out.println("가장 첫번째 곡입니다.");
				}else {
					System.out.println(m.getSinger() + " - " + m.getTitle() + "이(가) 재생중입니다.");
				}

			} else if (input == 4) {
				System.out.println("======다음곡======");
				Music m = con.after();
				if(m == null) {
					System.out.println("가장 마지막 곡입니다.");
				}else {
					System.out.println(m.getSinger() + " - " + m.getTitle() + "이(가) 재생중입니다.");
				
				}

			} else if (input == 5) {
				System.out.println("======종료======");
				con.stop();
				break;
				
			} else {
				System.out.println("번호를 잘못누르셨습니다.");
			}

		}
	}
}
