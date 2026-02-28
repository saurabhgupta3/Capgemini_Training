package day2;

import java.util.*;
import java.io.*;
import java.util.function.Consumer;

public class ConsumerCl {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(34);
		arr.add(33);
		arr.add(88);
		arr.add(24);
		arr.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("consuming " + t);
			}
		});
		arr.forEach((x) -> System.out.println("consuming " + x));
	}
}