package com.jerry.first.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {

	@Autowired
	EmployeeService employeeServiceImpl;

	public void get() {
		employeeServiceImpl.add();
		final Employee em = employeeServiceImpl.getEmployeeById(1);
		System.out.println(em.toString());

	}

}
