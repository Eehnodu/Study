package com.test.model;

public class PersonalTrainingVO {
	// PT 식별자
	private int pt_idx;
	// 트레이너 식별자
	private int trn_idx;
	// PT 날짜
	private String pt_date;
	// PT 시작시간
	private String pt_st_dt;
	// PT 종료 시간
	private String pt_ed_dt;
	// PT 인원수
	private int pt_limits;
	// 마감상태
	private String pt_status;

	public PersonalTrainingVO(int pt_idx, int trn_idx, String pt_date, String pt_st_dt, String pt_ed_dt, int pt_limits,
			String pt_status) {
		this.pt_idx = pt_idx;
		this.trn_idx = trn_idx;
		this.pt_date = pt_date;
		this.pt_st_dt = pt_st_dt;
		this.pt_ed_dt = pt_ed_dt;
		this.pt_limits = pt_limits;
		this.pt_status = pt_status;
	}

	public int getPt_idx() {
		return pt_idx;
	}

	public void setPt_idx(int pt_idx) {
		this.pt_idx = pt_idx;
	}

	public int getTrn_idx() {
		return trn_idx;
	}

	public void setTrn_idx(int trn_idx) {
		this.trn_idx = trn_idx;
	}

	public String getPt_date() {
		return pt_date;
	}

	public void setPt_date(String pt_date) {
		this.pt_date = pt_date;
	}

	public String getPt_st_dt() {
		return pt_st_dt;
	}

	public void setPt_st_dt(String pt_st_dt) {
		this.pt_st_dt = pt_st_dt;
	}

	public String getPt_ed_dt() {
		return pt_ed_dt;
	}

	public void setPt_ed_dt(String pt_ed_dt) {
		this.pt_ed_dt = pt_ed_dt;
	}

	public int getPt_limits() {
		return pt_limits;
	}

	public void setPt_limits(int pt_limits) {
		this.pt_limits = pt_limits;
	}

	public String getPt_status() {
		return pt_status;
	}

	public void setPt_status(String pt_status) {
		this.pt_status = pt_status;
	}

	public PersonalTrainingVO() {
	}
}
