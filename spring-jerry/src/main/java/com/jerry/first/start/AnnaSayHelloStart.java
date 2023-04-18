package com.jerry.first.start;

import com.jerry.first.SayHelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fanc
 */
public class AnnaSayHelloStart {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext("com.jerry.first");
		final SayHelloService sayHelloService = annotation.getBean(SayHelloService.class);
		sayHelloService.say();
	}

}
