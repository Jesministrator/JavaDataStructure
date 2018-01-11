package com.wxueyuan.app;

public class RecursionTest {
	public static void main(String[] args) {
		//System.out.println(recFibonacci(6));
		//recHanoi(3, "A", "B", "C");
		System.out.println(fibonacci(5));
	}
	public  static int factorial(int arg) {
		if(arg <0 ) throw new IllegalArgumentException("invalid argument");
		if(arg == 0) return 1;
		int fac = 1;
		for(int i =1; i<=arg; i++) {
			fac *= i;
		}
		return fac;
	}
	public static int recFactorial(int arg) {
		if(arg <0 ) throw new IllegalArgumentException("invalid argument");
		if(arg == 0) return 1;
		return arg*recFactorial(--arg);
	}
	
	public static int fibonacci(int arg) {
		if(arg <0 ) throw new IllegalArgumentException("invalid argument");
		if(arg == 0) return 0;
		if(arg == 1) return 1;
		int pprev = 0;
		int prev = 1;
		for(int i=2; i<arg; i++) {
			int mid = pprev;
			prev = prev + pprev;
			pprev = mid;
		}
		return pprev+prev;
	}
	
	public static int recFibonacci (int arg) {
		if(arg <0 ) throw new IllegalArgumentException("invalid argument");
		if(arg == 0) return 0;
		if(arg == 1) return 1;
		return recFibonacci(arg-1)+recFibonacci(arg-2);
	}
	
	public static void recHanoi(int num, String from, String mid, String to) {
		if(num>0) {
			recHanoi(num-1, from, to, mid);
			move(num,from,to);
			recHanoi(num-1, mid, from, to);
		}
	}
	private static void move(int num, String from, String to) {
		System.out.println("移动盘子"+num+" 从 "+from+" -> "+to);
	}
}
