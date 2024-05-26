package com.test.model;

public class ExerciseVO {
	// 운동 식별자
	private int ex_idx;
	// 운동 명
	private String ex_name;
	// 운동 카테고리
	private String ex_category;
	// 운동 세부분류
	private String ex_dtls;
	// 운동 소모칼로리
	private int ex_calories;
	// 운동 시간
	private int ex_duration;
	// 운동 강도
	private String ex_strength;

	public ExerciseVO(int ex_idx, String ex_name, String ex_category, String ex_dtls, int ex_calories,
			Integer ex_duration, String ex_strength) {
		this.ex_idx = ex_idx;
		this.ex_name = ex_name;
		this.ex_category = ex_category;
		this.ex_dtls = ex_dtls;
		this.ex_calories = ex_calories;
		this.ex_duration = ex_duration;
		this.ex_strength = ex_strength;
	}

	public int getEx_idx() {
		return ex_idx;
	}

	public void setEx_idx(int ex_idx) {
		this.ex_idx = ex_idx;
	}

	public String getEx_name() {
		return ex_name;
	}

	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}

	public String getEx_category() {
		return ex_category;
	}

	public void setEx_category(String ex_category) {
		this.ex_category = ex_category;
	}

	public String getEx_dtls() {
		return ex_dtls;
	}

	public void setEx_dtls(String ex_dtls) {
		this.ex_dtls = ex_dtls;
	}

	public double getEx_calories() {
		return ex_calories;
	}

	public void setEx_calories(int ex_calories) {
		this.ex_calories = ex_calories;
	}

	public int getEx_duration() {
		return ex_duration;
	}

	public void setEx_duration(int ex_duration) {
		this.ex_duration = ex_duration;
	}

	public String getEx_strength() {
		return ex_strength;
	}

	public void setEx_strength(String ex_strength) {
		this.ex_strength = ex_strength;
	}

	public ExerciseVO() {
	}

}
