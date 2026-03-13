package com.gal;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gal.algo.Calc;
import com.gal.algo.PasswordEncrypter;
import com.gal.algo.UserVerifier;

public class MainBeans {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//which packages to scan for annotations @Component
		//Componect scan
		context.scan("com.gal");
		context.refresh();
		PasswordEncrypter bean = context.getBean(PasswordEncrypter.class);
		PasswordEncrypter bean2 = context.getBean(PasswordEncrypter.class);
		System.out.println(bean);
		System.out.println(bean2);
		System.out.println(bean.hash("hello"));
		
		StringBuilder bean3 = context.getBean(StringBuilder.class);
		StringBuilder bean9 = context.getBean(StringBuilder.class);
		System.out.println(bean3);
		System.out.println(bean9);
		
		
		Calc bean4 = context.getBean(Calc.class);
		int sum = bean4.add(4, 5);
		System.out.println(sum);
		
		String[] beans = context.getBeanDefinitionNames();
		for(String bea : beans) {
			System.out.println(bea);
		}
		
		Object bean5 = context.getBean("myCalc");
		Object bean6 = context.getBean("getCalc");
		//create an object of dataSource and inject into the spring context
		DataSource bean7 = context.getBean(DataSource.class);
		
		
		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("beans.xml");
		xmlContext.refresh();
		StringBuilder bean10 = xmlContext.getBean(StringBuilder.class);
		System.out.println(bean10);
		UserVerifier userVerifier = context.getBean(UserVerifier.class);
		userVerifier.verifyUser();
		context.close();
		
	}
}
