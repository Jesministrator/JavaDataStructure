package com.wxueyuan.DataStructure;

import com.wxueyuan.ADT.MyList;

public class MySinglyLinkedList<E> implements MyList<E> {
	
	//单链表中的首节点,此节点不存放元素，只用来指向单链表中的第一个节点
	private Node firstNode;
	//单链表的元素数量
	private int size;
	
	public MySinglyLinkedList() {
		firstNode = new Node(null, null);
		this.size = 0;
	}
	//内部类Node，用来表示单链表中每一个数据元素
	class Node{
		//数据域
		E data;
		//后继指针域，指向下一个数据元素
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
		//在单链表的结尾插入一个元素，就相当于在index为size的位置处插入元素
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
		//需要插入的元素
		Node newNode = new Node(element, null);
		//由于单链表只能从前往后遍历，因此要想在某个位置插入元素，必须先获得它前一个位置上的元素节点
		//私有方法getPrevNodeByIndex可以用来获取该元素节点
		Node posNode = getPrevNodeByIndex(index);
		//需要被插入元素的后继元素指向索引位置的原节点
		newNode.nextNode = posNode.nextNode;
		//前一个位置的节点的后继元素指向被插入的节点
		posNode.nextNode = newNode;
		this.size++;
	}
	//私有方法getPrevNodeByIndex获取index前一个位置的节点
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
		//如果需要被删除的元素为null
		if(o == null) {
			for(Node n = firstNode; n.nextNode!=null; n = n.nextNode) {
				if(n.nextNode.data == null) {
					Node targetNode = n.nextNode;
					n.nextNode = targetNode.nextNode;
					//让被删除节点的数据域，指针域和它的引用变量都指向null，方便GC工作
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
					//让被删除节点的数据域，指针域和它的引用变量都指向null，方便GC工作
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
		//一旦要插入元素的位置为负或大于目前的元素数量就抛出异常
        //此处不允许index等于size
		checkIndexValidation(index);
		//获取要被删除节点的前驱节点
		Node prevNode = getPrevNodeByIndex(index);
		//获取要被删除的节点
		Node targetNode = prevNode.nextNode;
		//取出要被删除节点的数据域
		E data = targetNode.data;
		//要被删除节点的前驱节点的后继节点指向要被删除节点的后继节点
		prevNode.nextNode = targetNode.nextNode;
		//让被删除节点的数据域，指针域和它的引用变量都指向null，方便GC工作
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
		for(Node n = firstNode.nextNode; n !=null;) {
			Node next = n.nextNode;
			n.data = null;
			n.nextNode = null;
			n = next;
		}
		firstNode.nextNode = null;
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
