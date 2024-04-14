package com.jerry.first.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	public Employee getEmployeeById(Integer id) {
		return employeeMapper.getEmployeeById(id);
	}
}
