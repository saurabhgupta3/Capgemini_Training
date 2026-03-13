package com.gal.algo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MyCalc implements Calc{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}
	
	//act as initializer
	//after calling the constructor e and dependency injection call this method
	@PostConstruct
	public void onInit() {
		System.out.println(" hello initialization method for dbconnect, websockets open, n/w connect");
	}
	//acts as destoyer
	@PreDestroy
	public void onDestroy() {
		System.out.println("hello on destroy of object: close resources");
	}
}
