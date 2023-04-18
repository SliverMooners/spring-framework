package com.jerry.first;


import org.springframework.stereotype.Service;

/**
 * @author fanc
 */
@Service
public class SayHelloService {

	public void say() {
		System.out.println("------------------------");
		System.out.println("您好, 欢迎使用...");
		System.out.println("------------------------");
	}

}
