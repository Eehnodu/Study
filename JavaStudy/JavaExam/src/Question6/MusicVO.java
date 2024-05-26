package Question6;

public class MusicVO {
	String title;
	String single;
	int playTime;

	public MusicVO(String title, String single, int playTime) {
		super();
		this.title = title;
		this.single = single;
		this.playTime = playTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	
	public String toString() {
		return (getTitle() + getSingle() + getPlayTime());
	}
}
