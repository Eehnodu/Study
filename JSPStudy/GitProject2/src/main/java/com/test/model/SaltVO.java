package com.test.model;

public class SaltVO {

	private String mem_id;
	private String mem_salt;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_salt() {
		return mem_salt;
	}

	public void setMem_salt(String mem_salt) {
		this.mem_salt = mem_salt;
	}

	public SaltVO(String mem_id, String mem_salt) {
		this.mem_id = mem_id;
		this.mem_salt = mem_salt;
	}

	public SaltVO() {
	}
}
