package com.test.naverserverproject;

public class MemberVO {
	String st_id ,st_name,st_phon ,pass ,hire_date; 
	int	st_check;
	
	@Override
	public String toString() {
		return "MemberVO [st_id=" + st_id + ", st_name=" + st_name + ", st_phon=" + st_phon + ", pass=" + pass
				+ ", hire_date=" + hire_date + ", st_check=" + st_check + "]";
	}
	public MemberVO() {}
	public MemberVO(String st_id, String st_name, String st_phon, String pass) {
		super();
		this.st_id = st_id;
		this.st_name = st_name;
		this.st_phon = st_phon;
		this.pass = pass;
		this.hire_date = hire_date;
		this.st_check = st_check;
	}
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_phon() {
		return st_phon;
	}
	public void setSt_phon(String st_phon) {
		this.st_phon = st_phon;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public int getSt_check() {
		return st_check;
	}
	public void setSt_check(int st_check) {
		this.st_check = st_check;
	}
}
