package com.intelliSwift.billing;

public class Test {
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{ 1,2,3,4,5,6,7,8}; 			
		
		int extra = arr.length % 2 == 0? 1 : 0;

	    int[] a = new int[1 + extra];

	    int startIndex = arr.length / 2 - extra;
	    int endIndex = arr.length / 2;

	    for (int i = 0; i <= endIndex - startIndex; i++) {
	        a[i] = arr[startIndex + i];
	   
	    System.out.println(a[i]);
	    
	    }
	}
	
}
