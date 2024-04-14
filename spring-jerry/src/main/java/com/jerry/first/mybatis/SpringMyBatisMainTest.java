package com.jerry.first.mybatis;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMyBatisMainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringMyBatisConfig.class);

		EmployeeService employeeService = context.getBean(EmployeeService.class);

		Employee employee = employeeService.getEmployeeById(1);

		System.out.println(employee);

	}
}