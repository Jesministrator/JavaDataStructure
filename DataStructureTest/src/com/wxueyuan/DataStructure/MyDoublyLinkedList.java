package com.wxueyuan.DataStructure;

import com.wxueyuan.ADT.MyList;

public class MyDoublyLinkedList<E> implements MyList<E> {
	
	private int size;
	private Node headNode;
	private Node tailNode;
	
	public MyDoublyLinkedList() {
		
	}

	class Node{
		Node prev;
		Node next;
		E data;
		Node (Node prev, Node next, E data){
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if(o==null) {
			for(Node n= headNode; n!=null; n=n.next) {
				if(n.data==null)
					return true;
			}
		}else {
			for(Node n = headNode; n!=null; n = n.next) {
				if(o.equals(n.data))
					return true;
			}
		}
		return false;
	}
	private Node getNodeById(int index) {
		
		if(index<size()/2) {
			Node n = headNode;
			for(int i=0; i<index ; i++) {
				n = n.next;
			}
			return n;
		}else {
			Node n = tailNode;
			for(int i=size()-1; i>index; i--) {
				n = n.prev;
			}
			return n;
		}
	}
	
	
	
	@Override
	public boolean add(E e) {
		Node n = tailNode;
		Node newNode = new Node(n,null,e);
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
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(index<0 || index>size()) throw new IndexOutOfBoundsException();
		if(index == size) 
			add(element);
		else {
			Node n = getNodeById(index);
			Node newNode = new Node(n.prev,n,element);
			if(n.prev == null) {
				headNode = newNode;
				n.prev = newNode;
			}else {
				n.prev.next = newNode;
				n.prev = newNode;
			}
			size++;
		}
	}
	private void fastRemove(Node n) {
		Node prev = n.prev;
		Node next = n.next;
		if(prev == null) {
			headNode = next;
		}else {
			prev.next = next;
			n.prev = null;
		}
		
		if(next == null) {
			tailNode = prev;
		}else {
			next.prev = prev;
			n.next = null;
		}
		n.data = null;
		size--;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(o == null) {
			for(Node n = headNode; n!=null; n=n.next) {
				if(n.data==null) {
					fastRemove(n);
					return true;
				}
			}
		}else {
			for(Node n = tailNode; n!=null; n=n.prev) {
				if(o.equals(n.data)){
					fastRemove(n);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBounds(index);
		Node n = getNodeById(index);
		E data = n.data;
		fastRemove(n);
		return data;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(Node n = headNode; n!=null;) {
			Node next = n.next;
			n.prev = null;
			n.next = null;
			n.data = null;
			n = next;
		}
		headNode = null;
		tailNode = null;
		this.size = 0;
	}

	private void checkBounds(int index) {
		if(index<0 || index>=size()) throw new IndexOutOfBoundsException();
	}
	
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBounds(index);
		return getNodeById(index).data;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		checkBounds(index);
		Node n = getNodeById(index);
		E data = n.data;
		n.data = element;
		return data;
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(Node n = headNode;n!=null;n=n.next) {
			if(n.next!=null)
				sb.append(n.data.toString()+", ");
			else
				sb.append(n.data.toString());
		}
		sb.append("]");
		return sb.toString();
	}
	
}
