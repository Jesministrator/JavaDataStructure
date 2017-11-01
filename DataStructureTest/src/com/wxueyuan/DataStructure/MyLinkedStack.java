package com.wxueyuan.DataStructure;

import com.wxueyuan.ADT.MyStack;

public class MyLinkedStack<E> implements MyStack<E>{
	
	//栈顶节点，不存储元素，只用来指向栈顶的元素
	private Node stackTop;
	private int size;
	
	public MyLinkedStack () {
		stackTop = new Node(null,null);
		size = 0;
	}
	
	class Node{
		E data;
		Node nextNode;
		Node(E data, Node nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
		
	}
	
	@Override
	public E push(E item) {
		// TODO Auto-generated method stub
		Node newNode = new Node(item,stackTop.nextNode);
		stackTop.nextNode = newNode;
		this.size++;
		return item;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		Node n = stackTop.nextNode;
		E data = n.data;
		stackTop.nextNode = n.nextNode;
		n.data = null;
		n.nextNode = null;
		n = null;
		this.size--;
		return data;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return stackTop.nextNode.data;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public int search(Object o) {
		// TODO Auto-generated method stub
		if(empty()) return -1;
		int index =1;
		if(o == null) {
			for(Node n=stackTop.nextNode; n!=null; n=n.nextNode, index++) {
				if(n.data == null) {
					return index;
				}
			}
			return -1;
		}else {
			for(Node n=stackTop.nextNode; n!=null; n=n.nextNode, index++) {
				if(o.equals(n.data)) {
					return index;
				}
			}
			return -1;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		if(empty()) return;
		for(Node n=stackTop.nextNode; n!=null ;) {
			Node next = n.nextNode;
			n.data = null;
			n.nextNode = null;
			n = next;
		}
		this.size = 0;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(Node n=stackTop.nextNode; n!=null; n=n.nextNode) {
			sb.append(n.data);
			if(n.nextNode!=null) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
