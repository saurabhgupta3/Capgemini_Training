package com.dk;
import java.util.*;
import java.io.*;

public class FindIdxOfLine {
	public static List<Integer> getIdx(String str) {
		List<Integer> arr = new ArrayList<>();
		int n = str.length();
		for(int i=0; i<n; i++) {
			if(str.charAt(i) == 'l' || str.charAt(i) == 'L') {
				if(i+3 < n && str.charAt(i+1) == 'i' && str.charAt(i+2) == 'n' && str.charAt(i+3) == 'e') {
					arr.add(i);
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		String str = "this is line. Line contains few words. Line is in java";
		List<Integer> arr = getIdx(str);
		System.out.println(arr);
	}
}
