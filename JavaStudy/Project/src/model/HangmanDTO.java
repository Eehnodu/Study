package model;

public class HangmanDTO {
	private String id;
	private String pw;
	private String nickname;
	private int score;
	private String vip;

	public HangmanDTO(String id, String pw, String nickname, int score, String vip) {
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.score = score;
		this.vip = vip;
	}

	public HangmanDTO(int score, String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.score = score;
	}

	public HangmanDTO(String vip, String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.vip = vip;
	}

	public HangmanDTO(String id, String pw, String nickname, String vip) {
		this.id = id;
		this.pw = pw;
		this.vip = "bronze";
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
