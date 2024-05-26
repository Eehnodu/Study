package model;

public class WordDTO {
	private int id;
	private String words;
	private String means;
	private String hint1;
	private String hint2;
	private String hint3;
	
    public WordDTO(int id, String words, String means, String hint1, String hint2, String hint3) {
		this.id = id;
		this.words = words;
		this.means = means;
		this.hint1 = hint1;
		this.hint2 = hint2;
		this.hint3 = hint3;
	}

	public String getWords() {
        return words;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeans() {
		return means;
	}

	public void setMeans(String means) {
		this.means = means;
	}

	public String getHint1() {
		return hint1;
	}

	public void setHint1(String hint1) {
		this.hint1 = hint1;
	}

	public String getHint2() {
		return hint2;
	}

	public void setHint2(String hint2) {
		this.hint2 = hint2;
	}

	public String getHint3() {
		return hint3;
	}

	public void setHint3(String hint3) {
		this.hint3 = hint3;
	}

	public void setWords(String words) {
		this.words = words;
	}
}

