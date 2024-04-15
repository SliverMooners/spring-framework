package com.jerry.first.mybatis;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

	public Employee getEmployeeById(@Param("id") Integer id);

	/**
	 * 添加
	 */
	void add(Employee employee);


}