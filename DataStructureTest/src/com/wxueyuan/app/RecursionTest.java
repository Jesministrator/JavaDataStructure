package com.wxueyuan.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecursionTest {
	public static void main(String[] args) {
		//System.out.println(recFibonacci(6));
		//recHanoi(4, "A", "B", "C");
		//System.out.println("------------------");
		//hanoi(4);
		//System.out.println(fibonacci(12));
		
		recFibonacci(5);
		
		
	
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
			int mid = prev;
			prev = prev + pprev;
			pprev = mid;
		}
		return pprev+prev;
	}
	
	public static int recFibonacci (int arg) {
		if(arg <0 ) throw new IllegalArgumentException("invalid argument");
		System.out.println("正在执行Fibonacci("+arg+")");
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
	
	public static void hanoi(int num) {
		String[] s = {"A","B","C"};
		List<Stack<Integer>> list = new ArrayList<>();
		list.add(new Stack<>());
		list.add(new Stack<>());
		list.add(new Stack<>());
		Stack<Integer> destStack = list.get(2);
		for(int i=num;i>=1;i--)
			list.get(0).push(i);
		int count =0;
		if(num%2!=0) {
			s[1] = "C";
			s[2] = "B";
			destStack = list.get(1);
		}
		while(destStack.size()!=num) {
			int smallestIndex = (count+1)%3;
			moveTop(list,s,count%3,smallestIndex);
			moveTop(list, s, (smallestIndex+2)%3, (smallestIndex+1)%3);
			count++;
		}
	}
	private static void moveTop(List<Stack<Integer>> list,String[] s, int fromIndex, int toIndex) {
		if(list.get(fromIndex).isEmpty()&&list.get(toIndex).isEmpty()) return;
		if(list.get(fromIndex).isEmpty()) {
			System.out.println("移动盘子"+list.get(toIndex).peek()+" 从 "+s[toIndex]+" -> "+s[fromIndex]);
			list.get(fromIndex).push(list.get(toIndex).pop());
			return;
		}
		if(list.get(toIndex).isEmpty()) {
			System.out.println("移动盘子"+list.get(fromIndex).peek()+" 从 "+s[fromIndex]+" -> "+s[toIndex]);
			list.get(toIndex).push(list.get(fromIndex).pop());
			return;
		}
		if(list.get(fromIndex).peek()<list.get(toIndex).peek()) {
			System.out.println("移动盘子"+list.get(fromIndex).peek()+" 从 "+s[fromIndex]+" -> "+s[toIndex]);
			list.get(toIndex).push(list.get(fromIndex).pop());
			return;
		}else {
			System.out.println("移动盘子"+list.get(toIndex).peek()+" 从 "+s[toIndex]+" -> "+s[fromIndex]);
			list.get(fromIndex).push(list.get(toIndex).pop());
			return;
		}
		
	}
}
