package com.java2novice.dao;

import java.util.List;

import com.java2novice.model.Employee;

public interface EmployeeDao {

	public void insertEmployee(Employee emp);
	
	public void updateEmployee(Integer id, Integer salary);
	
	
}
