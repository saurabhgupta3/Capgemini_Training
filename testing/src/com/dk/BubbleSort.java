package com.dk;

public class BubbleSort {
	public void bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {3, 8, 2, 7, 6};
		BubbleSort obj = new BubbleSort();
		obj.bubbleSort(arr);
		for(int it : arr) {
			System.out.println(it);
		}
	}
}
