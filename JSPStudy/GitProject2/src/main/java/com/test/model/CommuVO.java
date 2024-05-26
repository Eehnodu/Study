package com.test.model;

public class CommuVO {
	// 글 식별자
	private int comm_idx;
	// 글 제목
	private String comm_title;
	// 글 내용
	private String comm_content;
	// 글 첨부파일
	private String comm_file;
	// 글 작성일자
	private String created_at;
	// 글 좋아요수
	private Integer comm_likes;
	// 글 조회수
	private Integer comm_views;
	// 글 작성자
	private String mem_id;

	public int getComm_idx() {
		return comm_idx;
	}

	public void setComm_idx(int comm_idx) {
		this.comm_idx = comm_idx;
	}

	public String getComm_title() {
		return comm_title;
	}

	public void setComm_title(String comm_title) {
		this.comm_title = comm_title;
	}

	public String getComm_content() {
		return comm_content;
	}

	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}

	public String getComm_file() {
		return comm_file;
	}

	public void setComm_file(String comm_file) {
		this.comm_file = comm_file;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Integer getComm_likes() {
		return comm_likes;
	}

	public void setComm_likes(Integer comm_likes) {
		this.comm_likes = comm_likes;
	}

	public Integer getComm_views() {
		return comm_views;
	}

	public void setComm_views(Integer comm_views) {
		this.comm_views = comm_views;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public CommuVO(int comm_idx, String comm_title, String comm_content, String comm_file, String created_at,
			Integer comm_likes, Integer comm_views, String mem_id) {
		this.comm_idx = comm_idx;
		this.comm_title = comm_title;
		this.comm_content = comm_content;
		this.comm_file = comm_file;
		this.created_at = created_at;
		this.comm_likes = comm_likes;
		this.comm_views = comm_views;
		this.mem_id = mem_id;
	}

	public CommuVO() {
	}
}
