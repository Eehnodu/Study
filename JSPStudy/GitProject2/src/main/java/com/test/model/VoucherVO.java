package com.test.model;

public class VoucherVO {
	// 이용권 식별자
	private int vc_idx;
	// 이용권 이름
	private String vc_name;
	// 이용권 금액
	private String vc_price;
	// 센터 식별자
	private int center_idx;
		 

	public int getVc_idx() {
		return vc_idx;
	}

	public void setVc_idx(int vc_idx) {
		this.vc_idx = vc_idx;
	}

	public String getVc_name() {
		return vc_name;
	}

	public void setVc_name(String vc_name) {
		this.vc_name = vc_name;
	}

	public String getVc_price() {
		return vc_price;
	}

	public void setVc_price(String vc_price) {
		this.vc_price = vc_price;
	}

	public int getCenter_idx() {
		return center_idx;
	}

	public void setCenter_idx(int center_idx) {
		this.center_idx = center_idx;
	}

	public VoucherVO(int vc_idx, String vc_name, String vc_price, int center_idx) {
		this.vc_idx = vc_idx;
		this.vc_name = vc_name;
		this.vc_price = vc_price;
		this.center_idx = center_idx;
	}

	public VoucherVO() {
	}
	
	public VoucherVO getVoucher(String vc_idx) {
		return null;
	    
	}
	
}
