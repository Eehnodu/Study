package mp3Player;

import javazoom.jl.player.MP3Player;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MP3Player mp3 = new MP3Player();

		String comPath = "C:\\Users\\smhrd\\Desktop\\JavaStudy\\Ex0115ArrayList\\player\\";

		ArrayList<Music> musicList = new ArrayList<Music>();

		musicList.add(new Music("HypeBoy", "뉴진스", 180, comPath + "HypeBoy.mp3"));
		musicList.add(new Music("IAM", "아이브", 198, comPath + "IAM.mp3"));
		musicList.add(new Music("LoveLee", "악동뮤지션", 200, comPath + "LoveLee.mp3"));
		musicList.add(new Music("Smoke", "다이나믹듀오", 210, comPath + "Smoke.mp3"));
		musicList.add(new Music("한페이지가될수있게", "Day6", 185, comPath + "한페이지가될수있게.mp3"));

		System.out.println("======김이박의 Mp3플레이어======");
		int i = 0;

		while (true) {
			System.out.print("[1]재생 [2]정지 [3]이전곡 [4]다음곡 [5]종료 >> ");
			int input = sc.nextInt();

			if (input == 1) {
				System.out.println("======재생======");
				if (mp3.isPlaying()) {
					mp3.stop();
				}
				mp3.play(musicList.get(i).getPath());
				System.out.println(musicList.get(i).getSinger() + " - " + musicList.get(i).getTitle() + "이(가) 재생중입니다.");

			} else if (input == 2) {
				System.out.println("======정지======");
				if (mp3.isPlaying()) {
					mp3.stop();
					System.out.println("노래 재생을 정지합니다.");
				} else {
					System.out.println("재생 중인 노래가 없습니다.");
				}

			} else if (input == 3) {
				System.out.println("======이전곡======");
				if (i == 0) {
					System.out.println("가장 첫번째 곡입니다.");
				} else {
					if (mp3.isPlaying()) {
						mp3.stop();
						i--;
						mp3.play(musicList.get(i).getPath());
						System.out.println(
								musicList.get(i).getSinger() + " - " + musicList.get(i).getTitle() + "이(가) 재생중입니다.");
					}
				}

			} else if (input == 4) {
				System.out.println("======다음곡======");
				if (i == musicList.size() - 1) {
					System.out.println("가장 마지막 곡입니다.");
				} else {
					if (mp3.isPlaying()) {
						mp3.stop();
						i++;
						mp3.play(musicList.get(i).getPath());
						System.out.println(
								musicList.get(i).getSinger() + " - " + musicList.get(i).getTitle() + "이(가) 재생중입니다.");
					}
				}

			} else if (input == 5) {
				System.out.println("======종료======");
				if (mp3.isPlaying()) {
					mp3.stop();
				}
				break;
			} else {
				System.out.println("번호를 잘못누르셨습니다.");
			}

		}
	}
}
