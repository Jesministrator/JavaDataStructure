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
	
	public Node root(){
		return this.root;
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
		return depth(current);
	}
	
	private int depth(Node n) {
		if(n==null) return 0;
		return Math.max(depth(n.left),depth(n.right))+1;
	}
	
	public int minDepth(E v){
		Node current = getNodeByValue(v);
		return minDepth(current);
	}
	
	private int minDepth(Node n){
		if(n==null) return Integer.MAX_VALUE;
		if(n.left==null && n.right==null){
			return 1;
		}
		return Math.min(minDepth(n.left),minDepth(n.right))+1;
	}
	
	public int numOfNodes(E v){
		Node current = getNodeByValue(v);
		return numOfNodes(current);
	}
	
	private int numOfNodes(Node n){
		if(n==null) return 0;
		return numOfNodes(n.left)+numOfNodes(n.right)+1;
	}
	
	public int numOfLeafNodes(){
		return leafNodes(root);
	}
	
	private int leafNodes(Node n){
		if(n==null) return 0;
		if(n.left==null && n.right==null) return 1;
		return leafNodes(n.left)+leafNodes(n.right);
	}
	
	public int numOfLevelNodes(int level){
		if(level<=0) throw new IllegalArgumentException();
		return numOfLevelNodes(root,level);
	}
	
	private int numOfLevelNodes(Node n, int level){
		if(n==null) return 0;
		if(level==1) return 1;
		return numOfLevelNodes(n.left,level-1)+numOfLevelNodes(n.right,level-1);
	}
	
	public boolean isCompleteBinaryTree(){
		if(root==null) return false;
		Queue<Node> queue = new LinkedList<MyBinaryTree<E>.Node>();
		boolean result = true;
		boolean noChild = false;
		queue.add(root);
		while(!queue.isEmpty()){
			//取出队列的第一个元素
			Node current = queue.remove();
			//如果当前元素没有子节点
			if(noChild){
				//如果队列中的下一个节点有孩子则说明不是完全二叉树
				if(current.left!=null || current.right!=null){
					result = false;
					break;
				}
			}else{
				//左右子节点均不为空
				if(current.left!=null && current.right!=null){
					queue.add(current.left);
					queue.add(current.right);
				}else if(current.left!=null && current.right==null){
					//如果左节点不为空但右节点为空，则将noChild标识置为true，由此来检查队列中下一个元素是否有孩子
					queue.add(current.left);
					noChild = true;
				}else if(current.left==null && current.right!=null){
					//如果左节点为空但右节点不为空，则跳出循环，该树一定不是完全二叉树
					result = false;
					break;
				}else{
					//如果左右节点都为空，则将noChild标识置为true
					noChild = true;
				}
			}
		}
		return result;
	}
	
	public boolean isSameTree(MyBinaryTree<E> tree){
		return isSameTree(root(),tree.root());
	}
	
	private boolean isSameTree(Node root1, Node root2){
		if(root1==null && root2==null) return true;
		else if(root1==null || root2==null) return false;
		if(!root1.data.equals(root2.data)) return false;
		boolean leftResult = isSameTree(root1.left,root2.left);
		boolean rightResult = isSameTree(root1.right,root2.right);
		return leftResult&&rightResult;
	}
	
	public boolean isMirror(MyBinaryTree<E> tree){
		return isMirror(root,tree.root);
	}
	
	private boolean isMirror(Node root1,Node root2){
		if(root1==null && root2==null) return true;
		else if(root1==null || root2==null) return false;
		if(!root1.data.equals(root2.data)) return false;
		boolean leftResult = isMirror(root1.left,root2.right);
		boolean rightResult = isMirror(root1.right, root2.left);
		return leftResult&&rightResult;
	}
	
	public void mirrorTheTree() {
		mirrorTheTree(root);
	}
	
	private Node mirrorTheTree(Node n) {
		if(n==null) return null;
		Node left = mirrorTheTree(n.left);
		Node right = mirrorTheTree(n.right);
		n.left = right;
		n.right = left;
		return n;
	}
	
	public E lowestPublicParent(E v1, E v2) {
		Node n1 = getNodeByValue(v1);
		Node n2 = getNodeByValue(v2);
		return lowestPublicParent(root,n1, n2).data;
	}
	
	private Node lowestPublicParent(Node root, Node t1, Node t2) {
		if(findNode(root.left,t1)){
            if(findNode(root.right,t2)){
                return root;
            }else{
                return lowestPublicParent(root.left,t1,t2);
            }
        }else{
            if(findNode(root.left,t2)){
                return root;
            }else{
                return lowestPublicParent(root.right,t1,t2);
            }
        }
	}
	
	private boolean findNode(Node root,Node node){
        if(root == null || node == null){
            return false;
        }
        if(root == node){
            return true;
        }
        boolean found = findNode(root.left,node);
        if(!found){
            found = findNode(root.right,node);
        }
        return found;
    }

	
	
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

