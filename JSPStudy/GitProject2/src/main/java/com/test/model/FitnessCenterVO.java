package com.test.model;

public class FitnessCenterVO {
	// 센터 식별자
	private int center_idx;
	// 센터 이름
	private String center_name;
	// 센터 주소
	private String center_addr;
	// 센터 전화
	private String center_tel;

	public FitnessCenterVO() {
	}

	public int getCenter_idx() {
		return center_idx;
	}

	public void setCenter_idx(int center_idx) {
		this.center_idx = center_idx;
	}

	public String getCenter_name() {
		return center_name;
	}

	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}

	public String getCenter_addr() {
		return center_addr;
	}

	public void setCenter_addr(String center_addr) {
		this.center_addr = center_addr;
	}

	public String getCenter_tel() {
		return center_tel;
	}

	public void setCenter_tel(String center_tel) {
		this.center_tel = center_tel;
	}

	public FitnessCenterVO(int center_idx, String center_name, String center_addr, String center_tel) {
		this.center_idx = center_idx;
		this.center_name = center_name;
		this.center_addr = center_addr;
		this.center_tel = center_tel;
	}
}
