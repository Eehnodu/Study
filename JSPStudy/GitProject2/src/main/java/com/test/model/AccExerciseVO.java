package com.test.model;

public class AccExerciseVO {
	// 누적 식별자
	private int acc_idx;
	// 회원 아이디
	private String mem_id;
	// 운동 식별자
	private int ex_idx;

	private String ex_name; // 원래 ex_idx인데 운동명을 받아와야해서 Strig ex_name으로 바꿔놈
	// 운동 날짜
	private String ex_date;
	// 운동 완료 여부
	private String ex_done;
	// 운동 횟수
	private int ex_reps;
	// 소요 시간
	private int ex_time;
	// 소모 칼로리
	private int ex_calories;
	// 등록 일자
	private String created_at;
	// 운동 카테고리
	private String ex_category;
	// 운동 횟수 카운트
	private int ex_count;
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

	public int getEx_count() {
		return ex_count;
	}

	public void setEx_count(int ex_count) {
		this.ex_count = ex_count;
	}

	public String getEx_category() {
		return ex_category;
	}

	public void setEx_category(String ex_category) {
		this.ex_category = ex_category;
	}

	public int getAcc_idx() {
		return acc_idx;
	}

	public void setAcc_idx(int acc_idx) {
		this.acc_idx = acc_idx;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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

	public String getEx_date() {
		return ex_date;
	}

	public void setEx_date(String ex_date) {
		this.ex_date = ex_date;
	}

	public String getEx_done() {
		return ex_done;
	}

	public void setEx_done(String ex_done) {
		this.ex_done = ex_done;
	}

	public int getEx_reps() {
		return ex_reps;
	}

	public void setEx_reps(int ex_reps) {
		this.ex_reps = ex_reps;
	}

	public int getEx_time() {
		return ex_time;
	}

	public void setEx_time(int ex_time) {
		this.ex_time = ex_time;
	}

	public int getEx_calories() {
		return ex_calories;
	}

	public void setEx_calories(int ex_calories) {
		this.ex_calories = ex_calories;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public AccExerciseVO(int acc_idx, String mem_id, int ex_idx, String ex_date, String ex_done, int ex_reps,
			int ex_time, int ex_calories, String created_at) {
		this.acc_idx = acc_idx;
		this.mem_id = mem_id;
		this.ex_idx = ex_idx;
		this.ex_date = ex_date;
		this.ex_done = ex_done;
		this.ex_reps = ex_reps;
		this.ex_time = ex_time;
		this.ex_calories = ex_calories;
		this.created_at = created_at;
	}

	public AccExerciseVO(String mem_id, int ex_idx, String ex_date, String ex_done, int ex_reps, int ex_time) {
		this.mem_id = mem_id;
		this.ex_idx = ex_idx;
		this.ex_date = ex_date;
		this.ex_done = ex_done;
		this.ex_reps = ex_reps;
		this.ex_time = ex_time;
	}

	public AccExerciseVO(String ex_date, int ex_calories) {
		this.ex_date = ex_date;
		this.ex_calories = ex_calories;
	}

	public AccExerciseVO(String mem_id, String start_date, String end_date) {
		this.mem_id = mem_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
}