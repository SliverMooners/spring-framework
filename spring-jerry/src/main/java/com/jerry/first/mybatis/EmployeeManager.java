package com.jerry.first.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {

	@Autowired
	EmployeeService employeeService;

	public void get() {
		employeeService.add();
		final Employee em = employeeService.getEmployeeById(1);
		System.out.println(em.toString());

	}

}
