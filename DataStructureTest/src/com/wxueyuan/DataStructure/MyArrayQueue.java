package com.wxueyuan.DataStructure;

import java.util.Arrays;

import com.wxueyuan.ADT.MyQueue;

public class MyArrayQueue<E> implements MyQueue<E>{
	
	private E[] content;
	private static final int DEFAULT_SIZE = 10;
	private int front,rear;
	
	public MyArrayQueue() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayQueue(int capacity) {
		content = (E[])new Object[capacity];
		front = rear = 0;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return rear==front;
	}

	@Override
	public boolean enqueue(E element) {
		// TODO Auto-generated method stub
		ensureCapacity();
		content[rear++] = element;
		if(rear==content.length) rear=0;
		return true;
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if((rear+1)%content.length==front) {
			E[] newContent = (E[]) new Object[2*content.length+1];
			if(rear>front) {
				System.arraycopy(content, 0, newContent, 0, size());
			}else {
				//若rear<front，则复制需要分为两部分进行
				System.arraycopy(content, front, newContent, 0, content.length-front);
				if(rear>0)
					System.arraycopy(content, 0, newContent, content.length-front, rear);
			}
			content = newContent;
			rear = size();
			front=0;
		}
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		E element = content[front++];
		if(front==content.length) front=0;
		return element;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return content[front];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (rear-front+content.length)%content.length;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(content);
	}

}
