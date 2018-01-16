package com.wxueyuan.ADT;

public interface MyQueue<E> {
	boolean isEmpty();
	boolean enqueue(E element);
	E poll();
	E peek();
	int size();
}
