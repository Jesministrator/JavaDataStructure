package com.wxueyuan.DataStructure;

import com.wxueyuan.ADT.MyStack;

public class MyLinkedStack<E> implements MyStack<E>{

	private int size;
	private Node headNode;
	
	public MyLinkedStack() {
		// TODO Auto-generated constructor stub
	}
	
	class Node{
		E data;
		Node next;
		Node (Node next, E data){
			this.data = data;
			this.next = next;
		}
	}
	
	@Override
	public E push(E item) {
		// TODO Auto-generated method stub
		Node newNode = new Node(headNode,item);
		headNode = newNode;
		size++;
		return item;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E data = headNode.data;
		Node next = headNode.next;
		headNode.data = null;
		headNode.next = null;
		headNode = next;
		size--;
		return data;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return headNode.data;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public int search(Object o) {
		// TODO Auto-generated method stub
		if(o==null) {
			int i=1;
			for(Node n=headNode; n!=null; n=n.next,i++) {
				if(n.data==null)
					return i;
			}
		}else {
			int i=1;
			for(Node n=headNode; n!=null; n=n.next,i++) {
				if(o.equals(n.data))
					return i;
			}
		}
		return -1;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(Node n=headNode; n!=null;) {
			Node next = n.next;
			n.data=null;
			n.next = null;
			n=next;
		}
		headNode = null;
		size = 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(Node n=headNode; n!=null; n=n.next) {
			if(n.next!=null)
				sb.append(n.data+", ");
			else
				sb.append(n.data);
		}
		sb.append("]");
		return sb.toString();
	} 
}
