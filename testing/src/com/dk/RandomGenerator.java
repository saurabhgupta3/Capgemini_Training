package com.dk;
import java.util.Random;

public class RandomGenerator {
	public int[] getTenRandoms() {
		int[] arr = new int[10];
		for(int i=0; i<10; i++) {
			arr[i] = new Random().nextInt(10)+1;
		}
		return arr;
	}
	public static void main(String[] args) {
		
		RandomGenerator obj = new RandomGenerator();
		int[] arr = obj.getTenRandoms();
		for(int it : arr) {
			System.out.println(it);
		}
	}
}
