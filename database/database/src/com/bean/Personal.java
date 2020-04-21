package com.bean;

public class Personal {
	private int UID;
	private int money;
	private String NAME;
	private String PW;
	public Personal(){
		
	}
	
	public void setUID(int uid){
		UID = uid;
	}
	public int getUID(){
		return UID;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	public int getMoney(){
		return money;
	}
	
	public void setNAME(String name){
		NAME = name;
	}
	public String getNAME(){
		return NAME;
	}
	
	public void setPW(String pw){
		PW = pw;
	}
	public String getPW(){
		return PW;
	}
}
