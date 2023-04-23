package com.jerry.first;


import org.springframework.stereotype.Service;

/**
 * @author fanc
 */
@Service
public class SayAutowiredHelloService {

	public void add() {
		System.out.println("------------------------");
		System.out.println("Autowired 填充属性");
		System.out.println("------------------------");
	}

}
