package com.dk;
import java.util.*;
import java.io.*;

public class SumSquareDigitsRepeat {
	public static int getSq(int num) {
		int sum = 0;
		while(num > 0) {
			int digit = num%10;
			sum += (digit*digit);
			num /= 10;
		}
		return sum;
	}
	public static int getAns(int n) {
		Map<Integer, Integer> mp = new HashMap<>();
		int curr = n;
		int cnt = 0;
		while(true) {
			cnt++;
			int sq = getSq(curr);
			if(mp.containsKey(sq)) {
				return -1;
			} else if(sq == n){
				return cnt;
			} else {
				curr = sq;
				mp.put(sq, 1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = getAns(n);
		System.out.println(ans);
	}
}
