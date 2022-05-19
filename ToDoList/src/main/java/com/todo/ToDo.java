package com.todo;

public class ToDo {
	
	String code;
	String cont;
	int check;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public ToDo(String code, String cont, int check) {
		super();
		this.code = code;
		this.cont = cont;
		this.check = check;
	}

	public ToDo() {
		// TODO Auto-generated constructor stub
	}
	
	

	
}
