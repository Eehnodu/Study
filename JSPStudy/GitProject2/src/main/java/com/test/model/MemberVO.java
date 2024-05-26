package com.test.model;

public class MemberVO {
	// 회원 아이디
	private String mem_id;
	// 회원 비밀번호
	private String mem_pw;
	// 회원 이름
	private String mem_name;
	// 회원 연락처
	private String mem_phone;
	// 회원 생년월일
	private String mem_birthdate;
	// 회원 주소
	private String mem_addr;
	// 회원 이메일
	private String mem_email;
	// 회원 닉네임
	private String mem_nick;
	// 회원 성별
	private String mem_gender;
	// 회원 키
	private double height;
	// 회원 체중
	private double weight;
	// 체질량지수
	private double bmi;
	// 근육량
	private double muscle;
	// 체지방률
	private double fat_per;
	// 회원 가입일자
	private String joined_at;
	// 회원 구분
	private String mem_role;
	// 회원 이미지
	private String mem_img;

	public MemberVO(String mem_id, String mem_pw, String mem_name, String mem_phone, String mem_birthdate,
			String mem_addr, String mem_email, String mem_nick, String mem_gender, double height, double weight) {
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_birthdate = mem_birthdate;
		this.mem_addr = mem_addr;
		this.mem_email = mem_email;
		this.mem_nick = mem_nick;
		this.mem_gender = mem_gender;
		this.height = height;
		this.weight = weight;
	}
	
	public MemberVO(String mem_id, String mem_pw, String mem_name, String mem_phone, String mem_birthdate,
			String mem_addr, String mem_email, String mem_nick, String mem_gender, double height, double weight, String mem_img) {
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_birthdate = mem_birthdate;
		this.mem_addr = mem_addr;
		this.mem_email = mem_email;
		this.mem_nick = mem_nick;
		this.mem_gender = mem_gender;
		this.height = height;
		this.weight = weight;
		this.mem_img = mem_img;
	}

	public MemberVO(String mem_id, String mem_pw, String mem_name, String mem_phone, String mem_birthdate,
			String mem_addr, String mem_email, String mem_nick, String mem_gender, double height, double weight,
			double bmi, double muscle, double fat_per, String joined_at, String mem_role, String mem_img) {
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_birthdate = mem_birthdate;
		this.mem_addr = mem_addr;
		this.mem_email = mem_email;
		this.mem_nick = mem_nick;
		this.mem_gender = mem_gender;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.muscle = muscle;
		this.fat_per = fat_per;
		this.joined_at = joined_at;
		this.mem_role = mem_role;
		this.mem_img = mem_img;
	}

	public String getMem_img() {
		return mem_img;
	}

	public void setMem_img(String mem_img) {
		this.mem_img = mem_img;
	}

	public MemberVO() {
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_birthdate() {
		return mem_birthdate;
	}

	public void setMem_birthdate(String mem_birthdate) {
		this.mem_birthdate = mem_birthdate;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
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

	public String getJoined_at() {
		return joined_at;
	}

	public void setJoined_at(String joined_at) {
		this.joined_at = joined_at;
	}

	public String getMem_role() {
		return mem_role;
	}

	public void setMem_role(String mem_role) {
		this.mem_role = mem_role;
	}

}
