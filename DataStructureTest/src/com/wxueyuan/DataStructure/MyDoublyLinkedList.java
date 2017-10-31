package com.wxueyuan.DataStructure;

import com.wxueyuan.ADT.MyList;

public class MyDoublyLinkedList<E> implements MyList<E> {
	
	//双链表中的首标记节点,此节点不存放元素，前驱结点指向null，后继节点指向链表中的第一个元素节点
	private Node firstFlagNode;
	//双链表中的尾标记节点,此节点不存放元素，后继结点指向null，前驱节点指向链表中的最后一个元素节点
	private Node lastFlagNode;
	//双链表中元素的数量
	private int size;
	
	public MyDoublyLinkedList() {
		firstFlagNode = new Node (null,null,null);
		//首标记节点的后继指向尾标记节点，尾标记节点的前驱指向首标记节点
		lastFlagNode = new Node (null,firstFlagNode,null);
		firstFlagNode.nextNode = lastFlagNode;
		size = 0;
	}

	//内部类Node，用来表示双链表中每一个数据元素
	class Node{
		//数据域
		E data;
		//前驱指针域，指向该节点的前一个节点
		Node prevNode;
		//后继指针域，指向该节点的后一个节点
		Node nextNode;
		public Node(E data, Node prevNode, Node nextNode) {
			this.data = data;
			this.prevNode = prevNode;
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
		if(o == null) {
			for(Node n = firstFlagNode.nextNode; n!=null&&n!=lastFlagNode; n = n.nextNode) {
				if(n.data == null) {
					return true;
				}
			}
			return false;
		}else {
			for(Node n = firstFlagNode.nextNode; n!=null&&n!=lastFlagNode; n = n.nextNode) {
				if(o.equals(n.data)) {
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
		//当index=0时，相当于在第一个位置插入元素，当index=size时相当于在链表末尾插入一个元素
		if(index<0 || index>size())
			throw new IndexOutOfBoundsException();
		Node newNode = new Node(element,null,null);
		Node n = getPrevNodeByIndex(index);
		//在它之后插入新的节点
		n.nextNode.prevNode = newNode;
		newNode.prevNode = n;
		newNode.nextNode = n.nextNode;
		n.nextNode = newNode;
		this.size++;
		return;
	}
	//私有方法获取当前index位置的前一个节点
	private Node getPrevNodeByIndex(int index) {
		//双链表能够从前后两个方向遍历，根据index的大小选择方向遍历
		Node n = null;
		if(index<size()/2) {
			n = firstFlagNode;
			for(int i=0; i<index; i++) {
				n = n.nextNode;
			}
		}else {
			n = lastFlagNode;
			for(int i = size(); i>=index; i--) {
				n = n.prevNode;
			}
		}
		
		return n;
	}
	

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(o == null) {
			for(Node n = firstFlagNode.nextNode; n!=null&&n!=lastFlagNode; n = n.nextNode) {
				if(n.data == null) {
					//删除本节点
					n.prevNode.nextNode = n.nextNode;
					n.nextNode.prevNode = n.prevNode;
					//清空旧节点的数据域与指针域，方便GC工作
					n.data = null;
					n.nextNode = null;
					n.prevNode = null;
					n = null;
					this.size--;
					return true;
				}
			}
			return false;
		}else {
			for(Node n = firstFlagNode.nextNode; n!=null&&n!=lastFlagNode; n = n.nextNode) {
				if(o.equals(n.data)) {
					//删除本节点
					n.prevNode.nextNode = n.nextNode;
					n.nextNode.prevNode = n.prevNode;
					//清空旧节点的数据域与指针域，方便GC工作
					n.data = null;
					n.nextNode = null;
					n.prevNode = null;
					n = null;
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
		//检查index的边界
		checkIndexValidation(index);
		//获取index位置的节点
		Node targetNode = getPrevNodeByIndex(index).nextNode;
		E oldElement = targetNode.data;
		//旧节点的前驱节点指向旧节点的后继节点，旧节点的后继节点指向旧节点的前驱节点
		targetNode.prevNode.nextNode = targetNode.nextNode;
		targetNode.nextNode.prevNode = targetNode.prevNode;
		//清空旧节点的数据域与指针域，方便GC工作
		targetNode.data = null;
		targetNode.nextNode = null;
		targetNode.prevNode = null;
		targetNode = null;
		this.size--;
		return oldElement;
	}
	
	private void checkIndexValidation(int index) {
		if(index<0 || index>=size())
			throw new ArrayIndexOutOfBoundsException();
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(Node n = firstFlagNode.nextNode; n!=null&&n!=lastFlagNode; ) {
			Node next = n.nextNode;
			n.data = null;
			n.nextNode = null;
			n.prevNode = null;
			n = next;
		}
		firstFlagNode.nextNode = lastFlagNode;
		lastFlagNode.prevNode = firstFlagNode;
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
		E data = targetNode.data;
		targetNode.data = element;
		return data;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(Node n= firstFlagNode.nextNode; n!=null&&n!=lastFlagNode; n = n.nextNode) {
			sb.append(n.data);
			if(n.nextNode!=lastFlagNode)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

}
