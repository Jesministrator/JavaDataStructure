package com.wxueyuan.DataStructure;

import java.util.Arrays;

import com.wxueyuan.ADT.MyList;

public class MyArrayList<E> implements MyList<E>{

	private E[] content;
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	
	public MyArrayList() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity) {
		content = (E[]) new Object[capacity];
		size = 0;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if(o==null) {
			for(int i=0; i<size; i++) {
				if(content[i] == null) {
					return true;
				}
			}
		}else {
			for(int i=0 ; i<size(); i++) {
				if(o.equals(content[i])) 
					return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if(this.size>=content.length) {
			E[] newContent = (E[]) new Object[2*size+1];
			System.arraycopy(content, 0, newContent, 0, size());
			content = newContent;
			newContent = null;
		}
	}
	
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		add(this.size,e);
		return true;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(index<0 || index>size()) throw new IndexOutOfBoundsException();
		ensureCapacity();
		int movedNum = this.size-index;
		if(movedNum>0)
			System.arraycopy(content, index, content, index+1, movedNum);
		content[index] = element;
		this.size++;
	}
	
	private void checkBounds(int index) {
		if(index<0 || index>=size()) throw new IndexOutOfBoundsException();
	}
	
	private void fastRemove(int index) {
		int movedNum = size()-index-1;
		if(movedNum>0)
			System.arraycopy(content, index+1, content, index, movedNum);
		content[--size] = null;
	}
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(o == null) {
			for(int i =0; i<size(); i++) {
				if(content[i] == null) {
					fastRemove(i);
					return true;
				}
			}
			return false;
		}else {
			for(int i =0; i<size(); i++) {
				if(o.equals(content[i])) {
					fastRemove(i);
					return true;
				}
			}
			return false;
		}
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBounds(index);
		E element = content[index];
		fastRemove(index);
		return element;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i = 0; i<size(); i++) {
			content[i] = null;
		}
		this.size = 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBounds(index);
		return content[index];
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		checkBounds(index);
		E x = content[index];
		content[index] = element;
		return x;
	}
	
	public void trimToSize() {
		if(size()<content.length) {
			content = Arrays.copyOf(content, size());
		}
	}
	@Override
	public String toString() {
		return Arrays.toString(content);
	}
}
