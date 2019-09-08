package com.bean;

public class Medicine {
	/*
	 * 根据数据表结构声明成员变量
	 */
	private String mno;
	private String mname;
	private String mmode;
	private String mefficacy;
	
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMmode() {
		return mmode;
	}

	public void setMmode(String mmode) {
		this.mmode = mmode;
	}

	public String getMefficacy() {
		return mefficacy;
	}

	public void setMefficacy(String mefficacy) {
		this.mefficacy = mefficacy;
	}
	
}
