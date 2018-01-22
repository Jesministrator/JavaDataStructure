package com.wxueyuan.app;

import java.util.Arrays;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(indexOfSubStringKMP("BBC ABCDABBABCDABCDABDE","ABCDABD"));
		System.out.println(Arrays.toString(getNext("ABCDABD")));
	}
	
	public static int indexOfSubString(String target,String sub){
		int i=0;
		int j=0;
		while(i<target.length() && j<sub.length()){
			if(target.charAt(i)==sub.charAt(j)){
				i++;
				j++;
			}else{
				i=i-j+1;
				j=0;
			}
		}
		if(j>=sub.length())
			return i-sub.length();
		return -1;
	}
	
	public static int indexOfSubStringKMP(String target,String sub){
		int i=0;
		int j=0;
		int[] next = getNextVal(sub);
		System.out.println(Arrays.toString(next));
		while(i<target.length() && j<sub.length()){
			if(j==-1 || target.charAt(i)==sub.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		if(j>=sub.length())
			return i-sub.length();
		return -1;
	}
	
	
	private static int[] getNext(String s){
		int next[] = new int[s.length()];
		int j=-1;
		int i=0;
		next[0] = -1;
		while(i<s.length()-1){
			if(j==-1 || s.charAt(i)==s.charAt(j)){
				++i;
				++j;
				next[i]=j;
			}
			else{
				j=next[j];
			}
		}
		return next;
	}
	
	private static int[] getNextVal(String s) {
		int next[] = new int[s.length()];
		int j=-1;
		int i=0;
		next[0] = -1;
		while(i<s.length()-1){
			if(j==-1 || s.charAt(i)==s.charAt(j)){
				++i;
				++j;
				if(s.charAt(i)!=s.charAt(j)) {
					next[i]=j;
				}else {
					next[i]=next[j];
				}
				
			}
			else{
				j=next[j];
			}
		}
		return next;
	}
	
}
