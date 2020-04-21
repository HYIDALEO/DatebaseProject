package com.bean;

public class Airplane {
	private String airplaneDate;
	private String airplaneRoute;
	private String airplaneFlyTime;
	private String airplaneLandTime;
	private int airplanePrice;
	private int ticketNum;
	private int ID;
	private int UID;
	public Airplane(){
		
	}
	
	public void setAirplaneDate(String date){
		airplaneDate = date;
		
	}
	public void setAirplaneRoute(String route){
		airplaneRoute = route;
		
	}
	public void setAirplaneFlyTime(String flyTime){
		airplaneFlyTime = flyTime;
		
	}
	public void setAirplaneLandTime(String landTime){
		airplaneLandTime = landTime;
		
	}
	public void setAirplanePrice(int price){
		airplanePrice = price;
		
	}
	public void setTicketNum(int Num){
		ticketNum = Num;
		
	}
	
	public void setID(int id){
		ID = id;
		
	}
	public void setUID(int uid){
		UID = uid;
	}
	public int getUID(){
		
		return UID;
	}
	
	public String getAirplaneDate(){
		return airplaneDate;
		
	}
	public String getAirplaneRoute(){
		return airplaneRoute;
		
	}
	public String getAirplaneFlyTime(){
		return airplaneFlyTime;
		
	}
	public String getAirplaneLandTime(){
		return airplaneLandTime;
		
	}
	public int getAirplanePrice(){
		return airplanePrice;
		
	}
	public int getTicketNum(){
		return ticketNum;
		
	}
	public int getID(){
		return ID;
		
	}
}
