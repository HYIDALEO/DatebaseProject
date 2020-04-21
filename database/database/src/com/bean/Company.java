package com.bean;

public class Company {
	private int CID;
	private String NAME;
	private String PW;
	public void setCID(int cid){
		CID=cid;
	}
	public void setPW(String pw){
		PW=pw;
	}
	public void setNAME(String name){
		NAME=name;
	}
	public int getCID(){
		return CID;
	}
	public String getNAME(){
		return NAME;
	}
	public String getPW(){
		return PW;
	}
}
