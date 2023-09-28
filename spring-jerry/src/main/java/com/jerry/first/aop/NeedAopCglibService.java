package com.jerry.first.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeedAopCglibService {

	@Autowired
	NeedAopService needAopService;

	public void needProxy(){
		System.out.println("cglib 方法内执行");
		needAopService.aopAdd();
	}

	public void noProxy(){

	}

}
