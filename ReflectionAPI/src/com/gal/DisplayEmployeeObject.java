package com.gal;

import java.lang.reflect.Field;

class Employee {
	String name;
	int age;
	String email;
}

public class DisplayEmployeeObject {
	public static void main(String[] args) throws Exception {
		Employee emp = new Employee();
		emp.name = "Sumit Khanna";
		emp.age = 22;
		emp.email = "sumitkhanna@gmail.com";
		
		Class<?> c = emp.getClass();
		System.out.println(c);
		Field[] fields = c.getDeclaredFields();
		
		for(Field f : fields) {
			System.out.println(f.getName() + " = " + f.get(emp));
		}
	}
}
