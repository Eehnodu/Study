package com.test.model;

public class TrainerVO {
	// 트레이너 식별자
	private int trn_idx;
	// 트레이너 이름
	private String trn_name;
	// 트레이너 연락처
	private String trn_phone;
	// 트레이너 정보
	private String trn_info;
	// 트레이너 경력
	private String trn_career;
	// 센터 식별자
	private int center_idx;
	// 트레이너 사진
	private String trn_img;
	// 트레이너 입사일자
	private String joined_at;
	
	private String selectTrainer;

	public TrainerVO(int trn_idx, String trn_name, String trn_phone, String trn_info, String trn_career,
			int center_idx, String trn_img, String joined_at) {
		this.trn_idx = trn_idx;
		this.trn_name = trn_name;
		this.trn_phone = trn_phone;
		this.trn_info = trn_info;
		this.trn_career = trn_career;
		this.center_idx = center_idx;
		this.trn_img = trn_img;
		this.joined_at = joined_at;
	}
	
	

	public String getSelectTrainer() {
		return selectTrainer;
	}



	public void setSelectTrainer(String selectTrainer) {
		this.selectTrainer = selectTrainer;
	}



	public int getTrn_idx() {
		return trn_idx;
	}

	public void setTrn_idx(int trn_idx) {
		this.trn_idx = trn_idx;
	}

	public String getTrn_name() {
		return trn_name;
	}

	public void setTrn_name(String trn_name) {
		this.trn_name = trn_name;
	}

	public String getTrn_phone() {
		return trn_phone;
	}

	public void setTrn_phone(String trn_phone) {
		this.trn_phone = trn_phone;
	}

	public String getTrn_info() {
		return trn_info;
	}

	public void setTrn_info(String trn_info) {
		this.trn_info = trn_info;
	}

	public String gettrn_career() {
		return trn_career;
	}

	public void settrn_career(String trn_career) {
		this.trn_career = trn_career;
	}

	public int getCenter_idx() {
		return center_idx;
	}

	public void setCenter_idx(int center_idx) {
		this.center_idx = center_idx;
	}

	public String getTrn_img() {
		return trn_img;
	}

	public void setTrn_img(String trn_img) {
		this.trn_img = trn_img;
	}

	public String getJoined_at() {
		return joined_at;
	}

	public void setJoined_at(String joined_at) {
		this.joined_at = joined_at;
	}

	public TrainerVO() {
		
	}

	
}
