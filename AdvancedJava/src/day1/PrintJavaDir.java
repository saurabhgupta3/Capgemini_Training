package day1;

import java.util.*;
import java.io.*;


public class PrintJavaDir {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter dir name : ");
		try {
			String dir = sc.nextLine();
			File file = new File(dir);
			if(!file.exists() || !file.isDirectory()) {
				System.out.println("can not procedd");
				return;
			}
			
			File[] list = file.listFiles();
			List<File> java = new ArrayList<>();
			for(File name : list) {
				if(name.getName().endsWith(".java")) {
					java.add(name);
				}
			}
			
			java.sort((a, b) -> Long.compare(b.length(), a.length()));
			for(File name : java) {
				System.out.println(name.getName() + " -> " + name.length());
			}
		} finally {
			sc.close();
		}
	}
}