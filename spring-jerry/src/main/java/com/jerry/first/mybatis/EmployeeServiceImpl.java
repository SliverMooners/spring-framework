package com.jerry.first.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(rollbackFor = Exception.class)
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeMapper.getEmployeeById(id);
	}


	@Override
	public void add() {
		Employee employee = new Employee();
		employee.setId(9);
		employee.setGender("man");
		employee.setLastName("fcc9");
		employee.setEmail("email9");
		employeeMapper.add(employee);
		int j = 0;
		int i = 1/j;
	}
}
