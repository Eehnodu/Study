package com.test.model;

public class SentenceVO {
	private int sentence_idx;
	private String content;

	public int getSentence_idx() {
		return sentence_idx;
	}

	public void setSentence_idx(int sentence_idx) {
		this.sentence_idx = sentence_idx;
	}

	public String getcontent() {
		return content;
	}

	public void setcontent(String content) {
		this.content = content;
	}

	public SentenceVO() {
	}

	public SentenceVO(int sentence_idx, String content) {
		this.sentence_idx = sentence_idx;
		this.content = content;
	}
}
