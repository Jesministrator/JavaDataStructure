package com.wxueyuan.app;

import java.util.Arrays;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(indexOfSubStringKMP("Xgoogleggggoogle","google"));
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
		int[] next = getNext(sub);
		System.out.println(Arrays.toString(next));
		while(i<target.length() && j<sub.length()){
			if(j==0 || target.charAt(i)==sub.charAt(j)){
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
	
	//根据字符串s获取next数组
	private static int[] getNext(String s){
		//next下标需要从1开始，因此声明长度时需要为length+1
		int next[] = new int[s.length()+1];
		int j=0;
		int i=1;
		next[1] = 0;
		while(i<s.length()){
			if(j==0 || s.charAt(i-1)==s.charAt(j-1)){
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
	
}
