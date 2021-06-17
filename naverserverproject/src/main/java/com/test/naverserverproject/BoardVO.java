package com.test.naverserverproject;

public class BoardVO {
	String st_id,come_in,go_out,result,iscome_in,isgo_out;

	public String getSt_id() {
		return st_id;
	}

	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}

	public String getCome_in() {
		return come_in;
	}

	public void setCome_in(String come_in) {
		this.come_in = come_in;
	}

	public String getGo_out() {
		return go_out;
	}

	public void setGo_out(String go_out) {
		this.go_out = go_out;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getIscome_in() {
		return iscome_in;
	}

	public void setIscome_in(String iscome_in) {
		this.iscome_in = iscome_in;
	}

	public String getIsgo_out() {
		return isgo_out;
	}

	public void setIsgo_out(String isgo_out) {
		this.isgo_out = isgo_out;
	}
	public BoardVO() {}
	public BoardVO(String st_id, String come_in, String go_out, String result, String iscome_in, String isgo_out) {
		super();
		this.st_id = st_id;
		this.come_in = come_in;
		this.go_out = go_out;
		this.result = result;
		this.iscome_in = iscome_in;
		this.isgo_out = isgo_out;
	}

	@Override
	public String toString() {
		return "boardVO [st_id=" + st_id + ", come_in=" + come_in + ", go_out=" + go_out + ", result=" + result
				+ ", iscome_in=" + iscome_in + ", isgo_out=" + isgo_out + "]";
	}
			
}
