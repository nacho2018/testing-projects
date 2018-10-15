package com.java2novice.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java2novice.dao.EmployeeDao;
import com.java2novice.model.Employee;

public class SpringDemo {

	 public static void main(String a[]){
         
        String confFile = "applicationContext.xml";
        ConfigurableApplicationContext context = 
                new ClassPathXmlApplicationContext(confFile);
        EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDAO");
//        Employee emp = new Employee();
//        emp.setName("James");
//        emp.setSalary(23456);
//        emp.setDept("AA");
//        empDao.insertEmployee(emp);
          empDao.updateEmployee(1, 3333);
	 }
}
