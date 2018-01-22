package com.wxueyuan.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.wxueyuan.DataStructure.Child;
import com.wxueyuan.DataStructure.MyBinaryTree;

public class MyBinaryTreeTest {

	@Test
	public void testInsert() {
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
	}

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
		System.out.println(Arrays.toString(t.preOrderTraverse(null).toArray()));
		System.out.println(Arrays.toString(t.preOrderNonRecursion(null).toArray()));
		System.out.println(Arrays.toString(t.inOrderRecursion(null).toArray()));
		System.out.println(Arrays.toString(t.inOrderNonRecursion(null).toArray()));
		System.out.println(Arrays.toString(t.postOrderTraverse(null).toArray()));
		System.out.println(Arrays.toString(t.postOrderNonRecursion(null).toArray()));
		System.out.println(t.depth(null));
		System.out.println(t.getLevel("G"));
	}

	@Test
	public void testPreOrderTraverse() {
		fail("Not yet implemented");
	}

	@Test
	public void testPreOrderNonRecursion() {
		fail("Not yet implemented");
	}

	@Test
	public void testInOrderRecursion() {
		fail("Not yet implemented");
	}

	@Test
	public void testInOrderNonRecursion() {
		fail("Not yet implemented");
	}

	@Test
	public void testPostOrderTraverse() {
		fail("Not yet implemented");
	}

	@Test
	public void testPostOrderNonRecursion() {
		fail("Not yet implemented");
	}

}
