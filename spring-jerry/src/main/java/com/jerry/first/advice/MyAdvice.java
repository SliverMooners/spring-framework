package com.jerry.first.advice;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fanc
 * 需要引入   optional("org.aspectj:aspectjweaver")  这玩意好像就是运行时的包
 */
@Component
@Aspect
public class MyAdvice {


	@Pointcut("execution(void com.jerry.first.aop.NeedAopServiceImpl.aopAdd())")
	public void ptUpdate(){

	}

	@Pointcut("execution(void com.jerry.first.aop.NeedAopServiceImpl.aopDel())")
	public void ptInsert(){}

	@Before("ptUpdate()")
	public void methodBefore(){
		System.out.println(System.currentTimeMillis());
	}


}
