package day2;

import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class StreamCode {
	public static void main(String[] args) {
		List<Integer> list = List.of(23, 23, 45, 34, 65, 4, 46, 78, 54, 23, 56, 7, 65, 46, 43);
		System.out.println(list.stream().allMatch(x ->  x >= 40));
		System.out.println(list.stream().anyMatch(x -> x >= 40));
		System.out.println(list.stream().count());
		list.stream().distinct().forEach(System.out::println);
		System.out.println();
		list.stream().filter(x -> x > 40).forEach(System.out::println);
	}
}