package com.test.model;

public class StdDataVO {
	// 표준 식별자
	private int std_idx;
	// 성별
	private String gender;
	// 나이	
	private int age;
	// 키
	private int height;
	// 체중
	private int weight;
	// 체질량지수(BMI)
	private int bmi;
	// 근육량
	private int muscle;
	// 체지방률
	private int fat_per;

	public StdDataVO(int std_idx, String gender, int age, int height, int weight, int bmi, int muscle, int fat_per) {
		this.std_idx = std_idx;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.muscle = muscle;
		this.fat_per = fat_per;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStd_idx() {
		return std_idx;
	}

	public void setStd_idx(int std_idx) {
		this.std_idx = std_idx;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getBmi() {
		return bmi;
	}

	public void setBmi(int bmi) {
		this.bmi = bmi;
	}

	public int getMuscle() {
		return muscle;
	}

	public void setMuscle(int muscle) {
		this.muscle = muscle;
	}

	public int getFat_per() {
		return fat_per;
	}

	public void setFat_per(int fat_per) {
		this.fat_per = fat_per;
	}

	public StdDataVO() {
	}

	public StdDataVO(String gender, int age) {
		this.gender = gender;
		this.age = age;
	}

}
