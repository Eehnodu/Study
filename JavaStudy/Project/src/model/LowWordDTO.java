package model;

public class LowWordDTO extends WordDTO {
	private int lowId;

	public LowWordDTO(int lowId, String words, String means, String hint1, String hint2, String hint3) {
		super(lowId, words, means, hint1, hint2, hint3); 
	}

	public int getLowId() {
		return lowId;
	}

	public void setLowId(int lowId) {
		this.lowId = lowId;
	}

}
