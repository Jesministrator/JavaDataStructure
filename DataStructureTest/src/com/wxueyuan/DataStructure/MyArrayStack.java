package com.wxueyuan.DataStructure;

import java.util.Arrays;
import java.util.EmptyStackException;

import com.wxueyuan.ADT.MyStack;

public class MyArrayStack<E> implements MyStack<E> {
	
	private E[] contents;
	//在声明MyArrayStack时，如不指明大小，则初始大小为10
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	
	//两种构造函数，允许用户创建指定大小或者默认大小的栈
	public MyArrayStack() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayStack(int capacity) {
		//注意不能建立泛型数组，因此我们强行转换一个Object数组
		contents = (E[]) new Object[capacity];
		this.size = 0;
	}
	
	@Override
	public E push(E item) {
		// TODO Auto-generated method stub
		//在插入元素之前，检查数组是否有足够的空间放置新的元素，若没有，则对数组进行扩容
		ensureCapacity();
		contents[size++] = item;
		return item;
	}
	

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if(size>=contents.length) {
			//此处新数组的容量是旧数组的2倍加1，你可以自己选择扩容的多少
			E[] newContents = (E[]) new Object[2*size+1];
			//将就数组中的值全部拷于新数组中
			System.arraycopy(contents, 0, newContents, 0, size);
			//再让contents指向新的数组
			contents = newContents;
		}
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(empty())
			throw new EmptyStackException();
		E data = contents[size-1];
		contents[--size] = null;
		return data;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(empty())
			throw new EmptyStackException();
		return contents[size-1];
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return this.size==0;
	}

	@Override
	public int search(Object o) {
		// TODO Auto-generated method stub
		if(empty()) {
			return -1;
		}else {
			int distance;
			if(o == null) {
				for(int i=size-1; i>=0; i--) {
					if(contents[i] == null) {
						distance = this.size-i;
						return distance;
					}
				}
				return -1;
			}else {
				for(int i=size-1; i>=0; i--) {
					if(o.equals(contents[i])) {
						distance = this.size-i;
						return distance;
					}
				}
				return -1;
			}
			
		}
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i=this.size-1;i>=0;i--) {
			contents[size--] = null;
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(contents);
	}

}
