package com.jerry.first.aop;

import org.springframework.stereotype.Service;

@Service
public class NeedAopCglibService {

	public void needProxy(){
		System.out.println("cglib 方法内执行");
	}

	public void noProxy(){

	}

}
