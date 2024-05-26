package com.test.model;

public class MonthImgVO {
	private int img_idx;
	private int month;
	private String img_src;
	private String img_content;

	public int getImg_idx() {
		return img_idx;
	}

	public void setImg_idx(int img_idx) {
		this.img_idx = img_idx;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public String getImg_content() {
		return img_content;
	}

	public void setImg_content(String img_content) {
		this.img_content = img_content;
	}

	public MonthImgVO(int img_idx, int month, String img_src, String img_content) {
		this.img_idx = img_idx;
		this.month = month;
		this.img_src = img_src;
		this.img_content = img_content;
	}

	public MonthImgVO() {
	}

}
