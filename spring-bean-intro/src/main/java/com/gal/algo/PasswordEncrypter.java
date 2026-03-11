package com.gal.algo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

//asking Ioc container (applicationContext: AnnotationConfigApplicationContext
//create an object for this class
@Component
public class PasswordEncrypter {
	public String hash(String password) {
		return new StringBuilder(password).reverse().toString();
	}
	public PasswordEncrypter() {
		System.out.println("passwordencryptor object created");
	}
}
