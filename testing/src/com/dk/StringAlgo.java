package com.dk;

public class StringAlgo {
	public String func(String str) {
		String start = str.substring(0, 2);
		String end = str.substring(2);
		return end + start;
	}
	public static void main(String[] args){
		/**
		 * @param str : non null string of length min 2
		 * @return returns first 2 chars shifted to last of the string 
		 * @throws for null input : nullpointerexception
		 * for input < length(2) returns stringindexoutofboundsexception
		 */
		StringAlgo obj = new StringAlgo();
		System.out.println(obj.func("Saurabh"));
	}
}
