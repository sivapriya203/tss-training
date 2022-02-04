package com.tss.util;

public class sumNumber {

	public static void main(String[] args) {
		 sumNumber ex = new sumNumber();

	        int sum2 = ex.sumNumber1(2, 4);
	        System.out.println("sum2 = " + sum2);

	        int sum3 = ex.sumNumber1(1, 3, 5);
	        System.out.println("sum3 = " + sum3);

	        int sum4 = ex.sumNumber1(1, 3, 5, 7);
	        System.out.println("sum4 = " + sum4);

	}
	public int sumNumber1(int ... args){
        System.out.println("argument length: " + args.length);
        int sum = 0;
        for(int x: args){
            sum += x;
        }
        return sum;
    }


}
