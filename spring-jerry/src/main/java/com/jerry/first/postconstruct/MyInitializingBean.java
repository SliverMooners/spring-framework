package com.jerry.first.postconstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @author fanc
 * 构造方法-> @PostConstruct-> InitializingBean(afterPropertiesSet)-> @Bean(initMethod = "init")
 */
@Component
public class MyInitializingBean implements InitializingBean {

	public MyInitializingBean() {
		System.out.println("我是MyInitializingBean构造方法执行...");
	}

	public MyInitializingBean(String msg) {
		System.out.println(msg);
	}

	/**
	 * 这个应该在BeanPostProcessor时候before执行的, 待确认?
	 */
	@PostConstruct
	public void postConstruct() {
		System.out.println("我是postConstruct方法执行...");
	}

	@Override
	public void afterPropertiesSet() {
		System.out.println("我是afterPropertiesSet方法执行...");
	}

	@Bean(initMethod = "initTest")
	public void test() {
		System.out.println("我是postConstruct方法执行...");
	}

	public void initTest() {
		System.out.println("我是init方法");
	}

	public void init1() {
		System.out.println("我是init方法");
	}

	/**
	 * 这个init1方法并不会执行, test1方法会执行
	 */
	@Bean(initMethod = "init1")
	public void test1() {
		System.out.println("我是test1方法");
	}

}
