package com.jerry.first;


import com.jerry.first.service.ISayHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanc
 */
@Service
public class SayHelloService {

	@Autowired
	ISayHelloService sayAutowiredHelloServiceImpl;

	public void say() {
		System.out.println("------------------------");
		System.out.println("您好, 欢迎使用...");
		sayAutowiredHelloServiceImpl.add();
	}

}
