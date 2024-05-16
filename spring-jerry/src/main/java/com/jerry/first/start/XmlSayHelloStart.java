package com.jerry.first.start;

import com.jerry.first.SayHelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fanc
 */
public class XmlSayHelloStart {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		final SayHelloService sayHelloService = context.getBean(SayHelloService.class);

		sayHelloService.say();
	}

}
