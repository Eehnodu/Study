package MVC;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class MusicController {

	private MP3Player mp3 = new MP3Player();
	private ArrayList<Music> musicList = new ArrayList<Music>();
	private int i = 0;

	public MusicController() {
		String comPath = "C:\\Users\\smhrd\\Desktop\\JavaStudy\\Ex0115ArrayList\\player\\";

		musicList.add(new Music("HypeBoy", "뉴진스", 180, comPath + "HypeBoy.mp3"));
		musicList.add(new Music("IAM", "아이브", 198, comPath + "IAM.mp3"));
		musicList.add(new Music("LoveLee", "악동뮤지션", 200, comPath + "LoveLee.mp3"));
		musicList.add(new Music("Smoke", "다이나믹듀오", 210, comPath + "Smoke.mp3"));
		musicList.add(new Music("한페이지가될수있게", "Day6", 185, comPath + "한페이지가될수있게.mp3"));
	}

	public Music play() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(musicList.get(i).getPath());
		return musicList.get(i);
	}

	public boolean stop() {
		boolean result = false;
		if (mp3.isPlaying()) {
			mp3.stop();
			result = true;
		}
		return result;
	}

	public Music before() {
		if (i == 0) {
			return null;
		} else {
			if (mp3.isPlaying()) {
				mp3.stop();
				i--;
				mp3.play(musicList.get(i).getPath());
			}
			return musicList.get(i);
		}
	}

	public Music after() {
		if (i == musicList.size() - 1) {
			return null;
		} else {
			if (mp3.isPlaying()) {
				mp3.stop();
				i++;
				mp3.play(musicList.get(i).getPath());
			}
			return musicList.get(i);
		}
	}
	
	public boolean exit() {
		boolean result = true;
		if (mp3.isPlaying()) {
			mp3.stop();
			result = true;
		}
		return result;
	}
}
