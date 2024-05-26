package model;

public class MidWordDTO extends WordDTO {
	private int midId;

	public MidWordDTO(int midId, String words, String means, String hint1, String hint2, String hint3) {
		super(midId, words, means, hint1, hint2, hint3); 
	}

	public int getMidId() {
		return midId;
	}

	public void setMidId(int midId) {
		this.midId = midId;
	}

}
