package com.test.model;

public class AccChangeVO {
	// 변화 식별자
	private int change_idx;
	// 회원 아이디
	private String mem_id;
	// 키
	private double height;
	// 체중
	private double weight;
	// 기록 날짜
	private String ch_date;
	// 체질량지수(BMI)
	private double bmi;
	// 근육량
	private double muscle;
	// 체지방률
	private double fat_per;

	private int ex_calories;
	// 시작 날짜
	private String start_date;
	// 종료 날짜
	private String end_date;

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getAc_date() {
		return ch_date;
	}

	public void setAc_date(String ac_date) {
		this.ch_date = ac_date;
	}

	// 기록 등록
	private String created_at;

	public int getEx_calories() {
		return ex_calories;
	}

	public void setEx_calories(int ex_calories) {
		this.ex_calories = ex_calories;
	}

	public int getChange_idx() {
		return change_idx;
	}

	public void setChange_idx(int change_idx) {
		this.change_idx = change_idx;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public double getMuscle() {
		return muscle;
	}

	public void setMuscle(double muscle) {
		this.muscle = muscle;
	}

	public double getFat_per() {
		return fat_per;
	}

	public void setFat_per(double fat_per) {
		this.fat_per = fat_per;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public AccChangeVO(int change_idx, String mem_id, double height, double weight, String ch_date, double bmi,
			double muscle, double fat_per, int ex_calories, String created_at) {
		this.change_idx = change_idx;
		this.mem_id = mem_id;
		this.height = height;
		this.weight = weight;
		this.ch_date = ch_date;
		this.bmi = bmi;
		this.muscle = muscle;
		this.fat_per = fat_per;
		this.ex_calories = ex_calories;
		this.created_at = created_at;
	}

	public AccChangeVO(String mem_id, double height, double weight, String ch_date, int ex_calories) {
		this.mem_id = mem_id;
		this.height = height;
		this.weight = weight;
		this.ch_date = ch_date;
		this.ex_calories = ex_calories;
	}

	public AccChangeVO() {
	}
	
	public AccChangeVO(String mem_id, String start_date, String end_date) {
		this.mem_id = mem_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public AccChangeVO(String mem_id) {
		this.mem_id = mem_id;
	}
}