package mp3Player;

import javazoom.jl.player.MP3Player;
import java.util.ArrayList;

public class Ex01사용법 {

	public static void main(String[] args) {
	      // 노래 재생 가능한 도구 꺼내기
	      MP3Player mp3 = new MP3Player();
	      
	      // 1. 재생하기
	      mp3.play("C:\\Users\\smhrd\\Desktop\\JavaStudy\\Ex0115ArrayList\\player\\한페이지가될수있게.mp3");
	      mp3.stop();
	      mp3.play("C:\\Users\\smhrd\\Desktop\\JavaStudy\\Ex0115ArrayList\\player\\LoveLee.mp3");
	      // 2. 노래 멈추기
	      mp3.stop();
	      
	      // 3. 노래 재생여부 판단하기
	      System.out.println(mp3.isPlaying());
		
	}
}
