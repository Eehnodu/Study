package model;

public class HighWordDTO extends WordDTO{
	private int highId;

	public HighWordDTO(int highId, String words, String means, String hint1, String hint2, String hint3) {
        super(highId, words, means, hint1, hint2, hint3); 
    }
	
	public int getHighId() {
		return highId;
	}

	public void setHighId(int highId) {
		this.highId = highId;
	}

}
