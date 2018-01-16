package com.wxueyuan.DataStructure;

import com.wxueyuan.ADT.MyQueue;

public class MyLinkedQueue<E> implements MyQueue<E> {

	private int size;
	private Node headNode;
	private Node tailNode;
	
	public MyLinkedQueue() {
		// TODO Auto-generated constructor stub
	}
	
	class Node{
		E data;
		Node prev;
		Node next;
		Node (Node prev,Node next,E data){
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	@Override
	public boolean enqueue(E element) {
		// TODO Auto-generated method stub
		Node n = tailNode;
		Node newNode = new Node(n,null,element);
		tailNode = newNode;
		if(n==null) {
			headNode = newNode;
		}else {
			n.next = newNode;
		}
		size++;
		return true;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		E element = headNode.data;
		Node next = headNode.next;
		headNode.data = null;
		headNode.next = null;
		headNode = next;
		size--;
		return element;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return headNode.data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(Node n=headNode;n!=null;n=n.next) {
			if(n.next!=null)
				sb.append(n.data+", ");
			else
				sb.append(n.data);
		}
		sb.append("]");
		return sb.toString();
	}

}
