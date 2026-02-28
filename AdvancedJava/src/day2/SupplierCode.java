package day2;

import java.util.*;
import java.io.*;

import java.util.function.Supplier;

public class SupplierCode {
	public static void main(String[] args) {
		Supplier<Integer> supp = new Supplier<>() {
			public Integer get() {
				return new Random().nextInt(400);
			}
		};
		Random r = new Random();
		Supplier<Integer> supp2 = () -> new Random().nextInt(400);
		System.out.println(supp.get());
		Supplier<Integer> supp3 = r::nextInt;
		System.out.println(supp3.get());
	}
}