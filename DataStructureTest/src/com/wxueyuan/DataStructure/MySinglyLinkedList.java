package com.wxueyuan.DataStructure;

import com.wxueyuan.ADT.MyList;

public class MySinglyLinkedList<E> implements MyList<E> {
	
	//单链表中的首节点,此节点不存放元素，只用来指向单链表中的第一个节点
	private Node firstNode;
	
	private int size;
	
	public MySinglyLinkedList() {
		firstNode = new Node(null, null);
		this.size = 0;
	}
	
	class Node{
		E data;
		Node nextNode;
		//提供一个构造函数
		Node(E data, Node nextNode){
			this.data = data;
			this.nextNode = nextNode;
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
		return size()==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if(isEmpty())
			return false;
		if(o == null) {
			for(Node n = firstNode; n.nextNode!=null; n = n.nextNode) {
				if(n.nextNode.data == null) {
					return true;
				}
			}
			return false;
		}else {
			for(Node n = firstNode; n.nextNode!=null; n = n.nextNode) {
				if(o.equals(n.nextNode.data)) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		add(size(),e);
		return true;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		//一旦要插入元素的位置为负或大于目前的元素数量就抛出异常
        //此处允许index等于size，相当于在单链表末尾插入元素
		if(index<0 || index>size())
			throw new IndexOutOfBoundsException();
		Node newNode = new Node(element, null);
		Node posNode = getPrevNodeByIndex(index);
		
		newNode.nextNode = posNode.nextNode;
		posNode.nextNode = newNode;
		this.size++;
	}
	
	private Node getPrevNodeByIndex(int index) {
		Node posNode = firstNode;
		for(int i=0; i<index;i++) {
			posNode = posNode.nextNode;
		}
		return posNode;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(isEmpty())
			return false;
		if(o == null) {
			for(Node n = firstNode; n.nextNode!=null; n = n.nextNode) {
				if(n.nextNode.data == null) {
					Node targetNode = n.nextNode;
					n.nextNode = targetNode.nextNode;
					targetNode.data = null;
					targetNode.nextNode = null;
					targetNode = null;
					this.size--;
					return true;
				}
			}
			return false;
		}else {
			for(Node n = firstNode; n.nextNode!=null; n = n.nextNode) {
				if(o.equals(n.nextNode.data)) {
					Node targetNode = n.nextNode;
					n.nextNode = targetNode.nextNode;
					targetNode.data = null;
					targetNode.nextNode = null;
					targetNode = null;
					this.size--;
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkIndexValidation(index);
		Node prevNode = getPrevNodeByIndex(index);
		Node targetNode = prevNode.nextNode;
		E data = targetNode.data;
		prevNode.nextNode = targetNode.nextNode;
		targetNode.data = null;
		targetNode.nextNode = null;
		targetNode = null;
		this.size--;
		return data;
	}
	
	private void checkIndexValidation(int index) {
		if(index<0 || index>=size())
			throw new ArrayIndexOutOfBoundsException();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(Node n = firstNode; n.nextNode !=null;) {
			Node targetNode = n.nextNode;
			Node next = targetNode.nextNode;
			targetNode.data = null;
			targetNode.nextNode = null;
			targetNode = next;
		}
		this.size = 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkIndexValidation(index);
		return getPrevNodeByIndex(index).nextNode.data;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		checkIndexValidation(index);
		Node targetNode = getPrevNodeByIndex(index).nextNode;
		E oldData = targetNode.data;
		targetNode.data = element;
		return oldData;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(Node n = firstNode; n.nextNode !=null;) {
			sb.append(n.nextNode.data);
			if(n.nextNode.nextNode!=null)
				sb.append(", ");
			n = n.nextNode;
		}
		sb.append("]");
		return sb.toString();
	}
	


}
