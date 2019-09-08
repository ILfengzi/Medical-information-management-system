package com.bean;

import java.util.Date;

public class Orderform {
	/*
	 * 根据数据表结构声明成员变量
	 */
	private int ono;
	private String cno;
	private String ano;
	private String mno;
	private Date date;
	private String symptom;
	
	public Orderform() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public int getOno() {
		return ono;
	}

	public void setOno(int ono) {
		this.ono = ono;
	}
	
}
