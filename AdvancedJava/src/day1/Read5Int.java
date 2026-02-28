package day1;

import java.util.*;
import java.io.*;

public class Read5Int {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 5 intergers: ");
		try {
			int sum = 0;
			for(int i=0; i<5; i++) {
				int inp = sc.nextInt();
				sum += inp;
			}
			System.out.println(sum);
		} catch(InputMismatchException e) {
			System.out.println(e);
			
		} catch(NoSuchElementException e) {
			System.out.println(e);
		} catch(IllegalStateException e) {
			System.out.println(e);
		} catch(Exception e) {
			System.out.println("some error occured" + e);
		} finally {
			sc.close();
		}
		System.out.println("AFTER TRY");
		
	}
}