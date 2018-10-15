package com.java2novice.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.java2novice.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
      
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
	public void insertEmployee(Employee emp) {
		
		String query = "insert into employee (name,salary,dept) values (?,?,?)";
		
		
		try{
			jdbcTemplate = new JdbcTemplate(dataSource);
	        Object[] inputs = new Object[] {emp.getName(), emp.getSalary(), emp.getDept()};
	        int rows = jdbcTemplate.update(query, inputs);
	        
	        System.out.println("Number of rows inserted: " + rows);
	       
		}catch(Exception ex){
			System.out.println("Error inserting...." + ex.getMessage());
		}
        
	}

	public void updateEmployee(Integer id, Integer salary) {
		
		String sql = "update employee set salary = ? where id_emp = ?";
		
		
		try{
			jdbcTemplate = new JdbcTemplate(dataSource);
			int rows = jdbcTemplate.update(sql, new Object[] {id, salary});
			
			System.out.println("Number of rows updated: " + rows);
			
		}catch(Exception ex){
			System.out.println("Error updating...." + ex.getMessage());
		}
		
	}



}
