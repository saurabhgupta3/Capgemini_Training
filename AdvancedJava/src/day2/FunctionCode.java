package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCode {
	public static void main(String[] args) {
		Function<String, Integer> func = (str) -> str.length();
		System.out.println(func.apply("saurabh"));
		Function<String, String> func2 = (str) -> str.substring(0,2).toUpperCase();
		System.out.println(func2.apply("dharDubeyj"));
		
	}
}