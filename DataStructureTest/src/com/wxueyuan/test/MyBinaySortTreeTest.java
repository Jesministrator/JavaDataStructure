package com.wxueyuan.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.wxueyuan.DataStructure.MyBinaySortTree;

public class MyBinaySortTreeTest {

	

	@Test
	public void testInsert() {
		MyBinaySortTree<Integer> bst = new MyBinaySortTree<>();
		bst.insert(5);
		bst.insert(8);
		bst.insert(12);
		bst.insert(18);
		bst.insert(7);
		bst.insert(4);
		bst.insert(3);
		bst.insert(5);
		System.out.println(Arrays.toString(bst.preOrder().toArray()));
		System.out.println(Arrays.toString(bst.inOrder().toArray()));
		System.out.println(Arrays.toString(bst.postOrder().toArray()));
		System.out.println(Arrays.toString(bst.levelOrder().toArray()));
		bst.remove(8);
		assertEquals("[5, 5, 7, 4, 12, 3, 18]",Arrays.toString(bst.levelOrder().toArray()));
		bst.remove(5);
		assertEquals("[5, 4, 7, 3, 12, 18]",Arrays.toString(bst.levelOrder().toArray()));
		bst.remove(7);
		assertEquals("[5, 4, 12, 3, 18]",Arrays.toString(bst.levelOrder().toArray()));
	}

}
