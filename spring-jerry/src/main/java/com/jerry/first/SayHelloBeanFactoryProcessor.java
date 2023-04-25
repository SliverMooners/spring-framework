package com.jerry.first;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author fanc
 */
@Component
public class SayHelloBeanFactoryProcessor implements BeanFactoryPostProcessor {

	private static final String BEAN_NAME = "sayHelloSetService";

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition)beanFactory.getBeanDefinition(BEAN_NAME);
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
	}


}
