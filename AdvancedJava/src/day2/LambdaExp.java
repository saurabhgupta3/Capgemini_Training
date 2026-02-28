package day2;

import java.util.*;
import java.io.*;

class Emp {
	int empid;
	String name;
	Emp(int empid, String name) {
		this.empid = empid;
		this.name = name;
	}
}

public class LambdaExp {
	public static void main(String[] args) {
		List<Emp> arr = new ArrayList<>();
		arr.add(new Emp(23, "Shubham"));
		arr.add(new Emp(44, "DharDubey"));
		arr.add(new Emp(55, "Aman"));
		arr.sort((a, b) -> a.name.compareTo(b.name));
		for(Emp emp : arr) {
			System.out.println(emp.name);
		}
		
	}
}