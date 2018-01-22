package com.wxueyuan.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyBinaryTree<E> {
	
	private int size;
	private Node root;
	
	public MyBinaryTree() {
		
	}
	
	//在整个二叉树中不允许插入空值
	private void checkValueNull(E v) {
		if(v==null) throw new IllegalArgumentException();
	}
	//对于使用数据结构的人来说，他们没法传入node类型的参数，因此需要提供方法根据值来获得Node
	private Node getNodeByValue(E v) {
		if(v==null) return this.root;
		Node n=preOrderTraverseNode(this.root,v);
		return n;
	}
	//以前序遍历返回一个带有v值的Node
	private Node preOrderTraverseNode(Node root,E v) {
		Stack<Node> s = new Stack<>();
		s.push(root);
		Node n = null;
		while(!s.isEmpty()) {
			//弹出root
			 n = s.pop();
			 if(n.data.equals(v))
				 break;
			//先压入右节点再压入左节点，这样下次左节点后就开始对左节点的左右儿子进行操作了 
			if(n.right!=null) {
				s.push(n.right);
			}
			if(n.left!=null) {
				s.push(n.left);
			}
		}
		return n;
	}
	
	public boolean insert(E parentValue,E newValue,Child c) {
		//插入的值不能为空
		checkValueNull(newValue);
		Node newNode = new Node(null, null, newValue);
		//在root元素位置插入新节点
		if(parentValue==null) {
			if(this.root!=null)
				newNode.left = this.root;   //newNode指向原来的root
			this.root = newNode;
		}else {
			Node parent = getNodeByValue(parentValue);
			if(!contains(parentValue)) return false;
			if(Child.LEFT.equals(c)) {
				newNode.left = parent.left;
				parent.left = newNode;
			}else {
				newNode.right = parent.right;
				parent.right = newNode;
			}
		}
		size++;
		return true;
	}
	
	public boolean contains (E v) {
		checkValueNull(v);
		return preOrderTraverse(null).contains(v);
	}
	
	public List<E> preOrderTraverse(E v){
		Node parent = getNodeByValue(v);
		List<E> list = new ArrayList<>();
		preOrderRecursion(parent, list);
		return list;
	}
	private void preOrderRecursion(Node parent,List<E> list) {
		if(parent==null) return;
		list.add(parent.data);
		preOrderRecursion(parent.left, list);
		preOrderRecursion(parent.right, list);
	}
	public List<E> preOrderNonRecursion(E parentValue) {
		List<E> list = new ArrayList<>();
		Node parent = getNodeByValue(parentValue);
		if(parent==null) return list;
		
		Stack<Node> s = new Stack<>();
		s.push(parent);
		while(!s.isEmpty()) {
			//弹出root
			Node n = s.pop();
			list.add(n.data);
			//先压入右节点再压入左节点，这样下次左节点后就开始对左节点的左右儿子进行操作了 
			if(n.right!=null) {
				s.push(n.right);
			}
			if(n.left!=null) {
				s.push(n.left);
			}
		}
		return list;
	}
	public List<E> inOrderRecursion(E v){
		Node parent = getNodeByValue(v);
		List<E> list = new ArrayList<>();
		inOrderRecursion(parent,list);
		return list;
	}
	
	private void inOrderRecursion(MyBinaryTree<E>.Node parent, List<E> list) {
		// TODO Auto-generated method stub
		if(parent == null) return;
		inOrderRecursion(parent.left,list);
		list.add(parent.data);
		inOrderRecursion(parent.right, list);
	}
	
	public List<E> inOrderNonRecursion(E parentValue) {
		Node current = getNodeByValue(parentValue);
		List<E> list = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		while(current !=null || !stack.isEmpty()) {
			//将current节点的左孩子循环放入到栈中
			while(current!=null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			list.add(current.data);
			current = current.right;
		}
		return list;
	}
	
	public List<E> postOrderTraverse(E currentValue){
		List<E> list = new ArrayList<>();
		Node current = getNodeByValue(currentValue);
		postOrderRecursion(current,list);
		return list;
	}


	private void postOrderRecursion(MyBinaryTree<E>.Node current, List<E> list) {
		// TODO Auto-generated method stub
		if(current==null) return;
		postOrderRecursion(current.left, list);
		postOrderRecursion(current.right,list);
		list.add(current.data);
	}
	
	public List<E> postOrderNonRecursion(E currentValue){
		List<E> list = new ArrayList<>();
		Node current = getNodeByValue(currentValue);
		Node lastVisitedNode = null;
		Stack<Node> stack = new Stack<>();
		while(current!=null){  
            stack.push(current);  
            current = current.left;  
        }  
        while(!stack.empty()){  
        	current = stack.pop();  //弹出栈顶元素  
            //一个根节点被访问的前提是：无右子树或右子树已被访问过  
            if(current.right!=null&&current.right!=lastVisitedNode){  
                //根节点再次入栈  
                stack.push(current);  
                //进入右子树，且可肯定右子树一定不为空  
                current = current.right;  
                while(current!=null){  
                    //再走到右子树的最左边  
                    stack.push(current);  
                    current = current.left;  
                }  
            }else{  
                list.add(current.data);
                //修改最近被访问的节点  
                lastVisitedNode = current;  
            }  
        }
		return list;
	}
	
	public int depth(E v) {
		Node current = getNodeByValue(v);
		if(current==null) return 0;
		return Math.max(depth(current.left.data),depth(current.right.data)) + 1;
	}
	
	/*private int depth(Node n) {
		
	}*/
	
	public List<E> levelOrderTraverse(E v) {
        List<E> list = new ArrayList<>();
		Node current = getNodeByValue(v);
        if (current == null) {
            return list;
        }

        int depth = depth(v);

        for (int i = 1; i <= depth; i++) {
            levelOrder(current, i, list);
        }
        
        return list;
    }

    private void levelOrder(Node n, int level, List<E> list) {
        if (n == null || level < 1) {
            return;
        }

        if (level == 1) {
            list.add(n.data);
            return;
        }

        // 左子树
        levelOrder(n.left, level - 1,list);

        // 右子树
        levelOrder(n.right, level - 1,list);
    }
	
	public List<E> levelOrderNonRecursion(E currentValue){
		List<E> list = new ArrayList<>();
		Node current = getNodeByValue(currentValue);
		Queue<Node> q=new LinkedList<Node>();  
        q.add(current);  
        while(!q.isEmpty()){  
            Node temp =  q.poll();  
            list.add(temp.data);  
            if(temp.left!=null) q.add(temp.left);  
            if(temp.right!=null) q.add(temp.right);  
        } 
		return list;
	}
	
	public int getLevel(E v) {
		if(!contains(v)) return -1;
		Node target = getNodeByValue(v);
		Node current = root;
		Stack<Node> stack = new Stack<>();
		Node lastVisitedNode = null;
		while(current!=null){  
            stack.push(current);  
            current = current.left;  
        }  
        while(!stack.empty()){  
        	current = stack.pop();  //弹出栈顶元素  
            //一个根节点被访问的前提是：无右子树或右子树已被访问过  
            if(current.right!=null&&current.right!=lastVisitedNode){  
                //根节点再次入栈  
                stack.push(current);  
                //进入右子树，且可肯定右子树一定不为空  
                current = current.right;  
                while(current!=null){  
                    //再走到右子树的最左边  
                    stack.push(current);  
                    current = current.left;  
                }  
            }else{  
                if(current == target) break;
                //修改最近被访问的节点  
                lastVisitedNode = current;  
            }  
        }
		return stack.size()+1;
	}
	
	
	class Node{
		E data;
		Node left;
		Node right;
		Node(Node left,Node right, E data){
			this.left = left;
			this.right = right;
			this.data = data;
		}
	} 
	
}

