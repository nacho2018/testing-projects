package com.java2novice.model;

public class Employee {

	 private int empId;
	 private String name;
	 private int salary;
	 private String dept;
	 
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	 
	public String toString(){
		
		return "emp{" + this.empId + ", " + this.name + ", " + this.salary + ", " + this.dept + "}";
		
		
	}
	    
	
}
