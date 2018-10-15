package com.web.tests.beans;

public class PersonData {

	private String name;
	private String phone;
	private String contact;
	private String date;
	
	public PersonData(){}
	
	public PersonData(String name, String phone, String contact, String date){
		
		this.name = name;
		this.contact = contact;
		this.date = date;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String toString(){
		
		return this.name + ", " + this.phone + ", " + this.contact + ", " + this.date;
	}
	
	
}
