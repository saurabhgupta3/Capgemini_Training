package day1;

import java.io.*;


public class PrintLast2 {
    public static void main(String[] args) {
        try {
        	RandomAccessFile raf = new RandomAccessFile("Application.java", "r");
    		long len = raf.length();
    		raf.seek(len-2);
    		System.out.println(raf.readByte());
    		System.out.println(raf.readByte());
    		raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}