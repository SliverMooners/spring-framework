package com.jerry.first;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanc
 */
@Service
public class SayAutowiredHelloServiceImpl implements ISayHelloService{

	@Autowired
	SayHelloService sayHelloService;

	@Override
	public void add() {
		System.out.println("------------------------");
		System.out.println("方法执行");
		System.out.println("------------------------");
	}

}
