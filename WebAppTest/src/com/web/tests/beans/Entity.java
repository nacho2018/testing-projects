package com.web.tests.beans;

public class Entity {

	private String code;
	private int numberStaff;
	private String address;
	
	public Entity(String code, int numberStaff, String address){
		
		this.code = code;
		this.numberStaff = numberStaff;
		this.address = address;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNumberStaff() {
		return numberStaff;
	}
	public void setNumberStaff(int numberStaff) {
		this.numberStaff = numberStaff;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
