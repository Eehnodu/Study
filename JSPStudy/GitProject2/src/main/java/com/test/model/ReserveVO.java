package com.test.model;

public class ReserveVO {
	// 예약 식별자
	private int res_idx;
	// PT 식별자
	private int pt_idx;
	// 회원 아이디
	private String mem_id;
	// 등록 시간
	private String created_at;
	// 예약 상태
	private String res_status;
	// 예약 메모
	private String res_memo;
	// 취소 여부
	private String cancel_yn;
	// 취소 사유
	private String cancel_reason;
	
	private String endTime;

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getRes_idx() {
		return res_idx;
	}

	public void setRes_idx(int res_idx) {
		this.res_idx = res_idx;
	}

	public int getPt_idx() {
		return pt_idx;
	}

	public void setPt_idx(int pt_idx) {
		this.pt_idx = pt_idx;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getRes_status() {
		return res_status;
	}

	public void setRes_status(String res_status) {
		this.res_status = res_status;
	}

	public String getRes_memo() {
		return res_memo;
	}

	public void setRes_memo(String res_memo) {
		this.res_memo = res_memo;
	}

	public String getCancel_yn() {
		return cancel_yn;
	}

	public void setCancel_yn(String cancel_yn) {
		this.cancel_yn = cancel_yn;
	}

	public String getCancel_reason() {
		return cancel_reason;
	}

	public void setCancel_reason(String cancel_reason) {
		this.cancel_reason = cancel_reason;
	}

	public ReserveVO(int res_idx, int pt_idx, String mem_id, String created_at, String res_status, String res_memo,
			String cancel_yn, String cancel_reason) {
		this.res_idx = res_idx;
		this.pt_idx = pt_idx;
		this.mem_id = mem_id;
		this.created_at = created_at;
		this.res_status = res_status;
		this.res_memo = res_memo;
		this.cancel_yn = cancel_yn;
		this.cancel_reason = cancel_reason;
	}

	public ReserveVO() {
	}
	
	public ReserveVO(String mem_id, String created_at) {
	}
	
	public ReserveVO(String mem_id,int pt_idx,String created_at,String res_status) {
		this.pt_idx = pt_idx;
		this.mem_id = mem_id;
		this.created_at = created_at;
		this.res_status = res_status;
	}
	
	
}
