package com.jerry.first.mybatis.mapper;

import com.jerry.first.mybatis.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {

	Employee getEmployeeById(@Param("id") Integer id);

	/**
	 * 添加
	 */
	void add(Employee employee);


}