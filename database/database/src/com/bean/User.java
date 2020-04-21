package com.bean;

public class User {
	private int UID;
	private String NAME;
	private String PW;
	public void setUID(int uid){
		UID=uid;
	}
	public void setPW(String pw){
		PW=pw;
	}
	public void setNAME(String name){
		NAME=name;
	}
	public int getUID(){
		return UID;
	}
	public String getNAME(){
		return NAME;
	}
	public String getPW(){
		return PW;
	}
}
