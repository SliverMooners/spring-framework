package com.jerry.first.mybatis;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMyBatisMainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringMyBatisConfig.class);

		EmployeeManager employeeService = context.getBean(EmployeeManager.class);

		employeeService.get();

	}
}