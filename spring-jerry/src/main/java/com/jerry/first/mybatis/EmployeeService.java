package com.jerry.first.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	public Employee getEmployeeById(Integer id) {
		return employeeMapper.getEmployeeById(id);
	}


	@Transactional(rollbackFor = Exception.class)
	public void add() {
		Employee employee = new Employee();
		employee.setId(3);
		employee.setGender("man");
		employee.setLastName("fcc3");
		employee.setEmail("email3");
		employeeMapper.add(employee);
		int i = 1/0;
	}
}
