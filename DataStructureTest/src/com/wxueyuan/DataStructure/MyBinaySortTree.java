package com.wxueyuan.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinaySortTree<E extends Comparable<E>> {
	private BSTNode root;
	int size;
	
	public MyBinaySortTree() {
		
	}
	
	public BSTNode recursionSearch(E v) {
		if(v==null) return root;
		return getBSTNodeByValue(root,v);
	}
	private BSTNode getBSTNodeByValue(BSTNode parent, E v) {
		BSTNode n = parent;
		if(n == null) return null;
		int cmp = v.compareTo(n.data);
		if(cmp<0) return getBSTNodeByValue(n.left,v);
		else if(cmp>0) return getBSTNodeByValue(n.right, v);
		else return n;
	}
	
	public BSTNode nonRecursionSearch(E v) {
		if(v==null) return root;
		BSTNode n = root;
		while(n!=null) {
			int cmp = v.compareTo(n.data);
			if(cmp<0) n=n.left;
			else if(cmp>0) n=n.right;
			else break;
		}
		return n;
	}
	
	public boolean insert(E v) {
		if(v==null) throw new IllegalArgumentException();
		BSTNode newBSTNode = new BSTNode(null,null,v);
		BSTNode current = root;
		if(root==null) {
			root = newBSTNode;
		}else {
			while(current!=null) {
				int cmp = v.compareTo(current.data);
				if(cmp<0) {
					if(current.left==null) {
						current.left = newBSTNode;
						break;
					}
						
					else
						current = current.left;
				}else if(cmp>0) {
					if(current.right==null) {
						current.right = newBSTNode;
						break;
					}
					else
						current = current.right;
				}else {
					newBSTNode.left = current.left;
					current.left = newBSTNode;
					break;
				}
			}
		}
		return true;
	}
	
	public boolean remove(E v) {
		BSTNode parent = root;
		BSTNode current = root;
		return true;
	}
	
	public List<E> preOrder(){
		List<E> list = new ArrayList<>();
		preOrder(root,list);
		return list;
	}
	private void preOrder(BSTNode n,List<E> list) {
		if(n==null) return;
		list.add(n.data);
		preOrder(n.left,list);
		preOrder(n.right,list);
	}
	
	public List<E> inOrder(){
		List<E> list = new ArrayList<>();
		inOrder(root,list);
		return list;
	}
	private void inOrder(BSTNode n,List<E> list) {
		if(n==null) return;
		inOrder(n.left,list);
		list.add(n.data);
		inOrder(n.right,list);
	}
	
	public List<E> postOrder(){
		List<E> list = new ArrayList<>();
		postOrder(root,list);
		return list;
	}
	private void postOrder(BSTNode n,List<E> list) {
		if(n==null) return;
		postOrder(n.left,list);
		postOrder(n.right,list);
		list.add(n.data);
	}
	
	public List<E> levelOrder(){
		List<E> list = new ArrayList<>();
		BSTNode n = root;
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(n);
		while(!queue.isEmpty()) {
			n = queue.poll();
			list.add(n.data);
			if(n.left!=null) queue.add(n.left);
			if(n.right!=null) queue.add(n.right);
		}
		return list;
	}
	
	class BSTNode{
		E data;
		BSTNode left;
		BSTNode right;
		BSTNode(BSTNode left, BSTNode right, E data){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
}
	

