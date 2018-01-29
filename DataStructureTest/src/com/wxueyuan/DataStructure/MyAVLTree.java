package com.wxueyuan.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyAVLTree<E extends Comparable<E>> {
	private AVLNode root;
	private int size;
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public MyAVLTree() {
		
	}
	
	public AVLNode root() {
		return root;
	}
	
	//由于需要计算高度差，所以实现一个获得高度的方法
	private int height(AVLNode n) {
		return n==null?-1:n.height;
	}
	public void insert(E v){  
        root = insert(root, v);             
	} 
	private AVLNode insert(AVLNode current, E v) {
		if(current==null)
			return new AVLNode(null,null,v);
		int cmp = v.compareTo(current.data);
		if(cmp<0) {
			current.left=insert(current.left, v);
			if(height(current.left)-height(current.right)==2) {
				//左左
				if(v.compareTo(current.left.data)<0) {
					current = rotateWithLeftChild(current);
				}
				//左右
				else {
					current = doubleWithLeftChild(current); 
				}
			}
		}else if(cmp>0){
			current.right = insert(current.right,v);
			if(height(current.right)-height(current.left)==2) {
				//右左
				if(v.compareTo(current.right.data)<0) {
					current = doubleWithRightChild(current);
				}else {
				//右右
					current = rotateWithRightChild(current);
				}
			}
		}
		current.height = Math.max(height(current.left),height(current.right))+1;
		return current;
	}
	
	public void remove(E v){  
        root = remove(root,v);  
    }
	private AVLNode remove(AVLNode n,E v) {
		if(n == null)  return null;
		int cmp = v.compareTo(n.data);
		if(cmp<0) {
			n.left = remove(n.left,v);
			
		}
		return n;
	}
	
	
	private AVLNode rotateWithLeftChild(AVLNode k2) {
		AVLNode k1 = k2.left;  
        k2.left = k1.right;       
        k1.right = k2;        
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;  
        k1.height = Math.max(height(k1.left), k2.height) + 1;         
        return k1;
	}
	
	private AVLNode rotateWithRightChild(AVLNode k2){  
		AVLNode k1 = k2.right;  
        k2.right = k1.left;  
        k1.left = k2;         
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;  
        k1.height = Math.max(height(k1.right), k2.height) + 1;        
        return k1;      //返回新的根   
    } 
	
	 private AVLNode doubleWithLeftChild(AVLNode k3){        
        try{  
            k3.left = rotateWithRightChild(k3.left);  
        }catch(NullPointerException e){  
            System.out.println("k.left.right为："+k3.left.right);  
            throw e;  
        }  
        return rotateWithLeftChild(k3);       
	 }
	 
	 private AVLNode doubleWithRightChild(AVLNode k3){  
        try{  
            k3.right = rotateWithLeftChild(k3.right);  
        }catch(NullPointerException e){  
            System.out.println("k.right.left为："+k3.right.left);  
            throw e;  
        }         
        return rotateWithRightChild(k3);  
	 }  
	 
	 public List<E> preOrder(){
			List<E> list = new ArrayList<>();
			preOrder(root,list);
			return list;
		}
		private void preOrder(AVLNode n,List<E> list) {
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
		private void inOrder(AVLNode n,List<E> list) {
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
		private void postOrder(AVLNode n,List<E> list) {
			if(n==null) return;
			postOrder(n.left,list);
			postOrder(n.right,list);
			list.add(n.data);
		}
		
		public List<E> levelOrder(){
			List<E> list = new ArrayList<>();
			AVLNode n = root;
			Queue<AVLNode> queue = new LinkedList<>();
			queue.add(n);
			while(!queue.isEmpty()) {
				n = queue.poll();
				list.add(n.data);
				if(n.left!=null) queue.add(n.left);
				if(n.right!=null) queue.add(n.right);
			}
			return list;
		}

	class AVLNode{
		E data;
		AVLNode left;
		AVLNode right;
		int height; //height字段用来表示每一个Node的高度
		public AVLNode(AVLNode left, AVLNode right,E data) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
		@Override
		public String toString() {
			return data.toString();
		}
	}
}
