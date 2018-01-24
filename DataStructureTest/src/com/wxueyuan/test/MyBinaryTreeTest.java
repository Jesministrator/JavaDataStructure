package com.wxueyuan.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.wxueyuan.DataStructure.Child;
import com.wxueyuan.DataStructure.MyBinaryTree;

public class MyBinaryTreeTest {



	@Test
	public void testContains() {
		MyBinaryTree<String> t = new MyBinaryTree<>();
		t.insert(null, "A", null);
		t.insert("A", "B", Child.LEFT);
		t.insert("A", "C", Child.RIGHT);
		t.insert("B", "D", Child.LEFT);
		t.insert("D", "G", Child.LEFT);
		t.insert("D", "H", Child.RIGHT);
		t.insert("C", "E", Child.LEFT);
		t.insert("C", "F", Child.RIGHT);
		t.insert("E", "I", Child.RIGHT);
		/*assertEquals(true,t.contains("A"));
		assertEquals(true,t.contains("B"));
		assertEquals(true,t.contains("C"));
		assertEquals(true,t.contains("D"));*/
		System.out.println("preOrder+Recursion"+Arrays.toString(t.preOrderTraverse(null).toArray()));
		System.out.println("preOrder+NonRecursion"+Arrays.toString(t.preOrderNonRecursion(null).toArray()));
		System.out.println("Moris+NonRecursion"+Arrays.toString(t.Morris_PreOrder(null).toArray()));
		assertEquals(Arrays.toString(t.preOrderNonRecursion(null).toArray()),Arrays.toString(t.preOrderNonRecursion2(null).toArray()));
		assertEquals(Arrays.toString(t.preOrderNonRecursion(null).toArray()),Arrays.toString(t.Morris_PreOrder(null).toArray()));
		System.out.println("inOrder+Recursion"+Arrays.toString(t.inOrderRecursion(null).toArray()));
		System.out.println("inOrder+NonRecursion"+Arrays.toString(t.inOrderNonRecursion(null).toArray()));
		System.out.println("postOrder+Recursion"+Arrays.toString(t.postOrderTraverse(null).toArray()));
		System.out.println("postOrder+NonRecursion"+Arrays.toString(t.postOrderNonRecursion(null).toArray()));
		System.out.println("levelOrder+Recursion"+Arrays.toString(t.levelOrderTraverse(null).toArray()));
		System.out.println("levelOrder+NonRecursion"+Arrays.toString(t.levelOrderNonRecursion(null).toArray()));
		assertEquals(Arrays.toString(t.levelOrderTraverse(null).toArray()),Arrays.toString(t.levelOrderNonRecursion(null).toArray()));
		System.out.println(t.depth(null));
		System.out.println(t.minDepth(null));
		System.out.println(t.getLevel("B"));
		assertEquals(9, t.numOfNodes(null));
		assertEquals(4, t.numOfLeafNodes());
		assertEquals(3, t.numOfLevelNodes(3));
		assertEquals(3, t.numOfLevelNodes(4));
		assertEquals(2, t.numOfLevelNodes(2));
		assertEquals(1, t.numOfLevelNodes(1));
		MyBinaryTree<String> t2 = new MyBinaryTree<>();
		t2.insert(null, "A", null);
		t2.insert("A", "B", Child.LEFT);
		t2.insert("A", "C", Child.RIGHT);
		t2.insert("B", "D", Child.LEFT);
		t2.insert("D", "G", Child.LEFT);
		t2.insert("D", "H", Child.RIGHT);
		t2.insert("C", "E", Child.LEFT);
		t2.insert("C", "F", Child.RIGHT);
		t2.insert("E", "I", Child.RIGHT);
		
		MyBinaryTree<String> t3 = new MyBinaryTree<>();
		t3.insert(null, "A", null);
		t3.insert("A", "B", Child.RIGHT);
		t3.insert("A", "C", Child.LEFT);
		t3.insert("B", "D", Child.RIGHT);
		t3.insert("D", "G", Child.RIGHT);
		t3.insert("D", "H", Child.LEFT);
		t3.insert("C", "E", Child.RIGHT);
		t3.insert("C", "F", Child.LEFT);
		t3.insert("E", "I", Child.LEFT);
		assertEquals(true, t.isSameTree(t2));
		assertEquals(false, t.isMirror(t2));
		assertEquals(true, t2.isMirror(t3));
		//assertEquals(false, t.sameTree(t3));
		
		t.mirrorTheTree();
		System.out.println("after the mirror operation");
		System.out.println("preOrder+Recursion"+Arrays.toString(t.preOrderTraverse(null).toArray()));
		System.out.println("preOrder+NonRecursion"+Arrays.toString(t.preOrderNonRecursion(null).toArray()));
		System.out.println("inOrder+Recursion"+Arrays.toString(t.inOrderRecursion(null).toArray()));
		System.out.println("inOrder+NonRecursion"+Arrays.toString(t.inOrderNonRecursion(null).toArray()));
		System.out.println("postOrder+Recursion"+Arrays.toString(t.postOrderTraverse(null).toArray()));
		System.out.println("postOrder+NonRecursion"+Arrays.toString(t.postOrderNonRecursion(null).toArray()));
		System.out.println("levelOrder+Recursion"+Arrays.toString(t.levelOrderTraverse(null).toArray()));
		System.out.println("levelOrder+NonRecursion"+Arrays.toString(t.levelOrderNonRecursion(null).toArray()));
		
		t.mirrorTheTree();
		
		assertEquals("A", t.lowestPublicParent("H", "I"));
		assertEquals("D", t.lowestPublicParent("G", "H"));
		assertEquals("C", t.lowestPublicParent("E", "F"));
		assertEquals("A", t.lowestPublicParent("D", "E"));
	}

	

}
