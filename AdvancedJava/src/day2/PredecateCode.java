package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredecateCode {
	public static void main(String[] args) {
		Predicate<String> pred = new Predicate<>() {
			public boolean test(String t) {
				return t.length() >= 10;
			}
		};
		pred = (str) -> str.length() >= 10;
		Integer[] arr = {34, 46, 23, 57, 66, 34, 54679, 786, 54, 23, 64, 9, 5, 634};
		List<Integer> list2 = new ArrayList<>();
		list2.addAll(Arrays.asList(arr));
		//remove elements greater than 100
		list2.removeIf((num) -> num > 100);
		System.out.println(list2);
	}
}