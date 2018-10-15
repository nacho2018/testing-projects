package com.web.tests.beans;

public class StaffData {

	private String name;
	private String office;
	private long salary;
	
	public StaffData(String name, String office, long salary){
		
		this.name = name;
		this.office = office;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	
}
