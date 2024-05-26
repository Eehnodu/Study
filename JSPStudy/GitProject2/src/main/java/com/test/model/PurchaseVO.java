package com.test.model;

public class PurchaseVO {
	// 구매 식별자
	private int pc_idx;
	// 회원 아이디
	private String mem_id;
	// 이용권 식별자
	private int vc_idx;
	// 구매 날짜
	private String bought_at;

	public int getPc_idx() {
		return pc_idx;
	}

	public void setPc_idx(int pc_idx) {
		this.pc_idx = pc_idx;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getVc_idx() {
		return vc_idx;
	}

	public void setVc_idx(int vc_idx) {
		this.vc_idx = vc_idx;
	}

	public String getBought_at() {
		return bought_at;
	}

	public void setBought_at(String bought_at) {
		this.bought_at = bought_at;
	}

	public PurchaseVO(int pc_idx, String mem_id, int vc_idx, String bought_at) {
		this.pc_idx = pc_idx;
		this.mem_id = mem_id;
		this.vc_idx = vc_idx;
		this.bought_at = bought_at;
	}

	public PurchaseVO() {
	}

	public PurchaseVO(String mem_id, int vc_idx) {
		this.mem_id = mem_id;
		this.vc_idx = vc_idx;
	}
}
