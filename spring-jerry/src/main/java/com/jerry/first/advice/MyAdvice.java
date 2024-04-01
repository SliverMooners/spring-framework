package com.jerry.first.advice;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fanc
 * 需要引入   optional("org.aspectj:aspectjweaver")  这玩意好像就是运行时的包
 * 记录: 1. @PostContrust 会在populateBean后执行, 但是此时还没有生成代理
 */
@Component
@Aspect
public class MyAdvice {


	@Pointcut("execution(void com.jerry.first.aop.NeedAopService.aopAdd())")
	public void ptUpdate(){

	}

	@Pointcut("execution(void com.jerry.first.aop.NeedAopService.aopDel())")
	public void ptInsert(){}


	@Pointcut("execution(void com.jerry.first.aop.NeedAopCglibService.needProxy())")
	public void ptAdd(){}

	@Before("ptUpdate()")
	public void methodBefore(){
		System.out.println("----------add advice------------");
	}

	@Before("ptAdd()")
	public void methodBefore1(){
		System.out.println("----------add advice------------");
	}


}
