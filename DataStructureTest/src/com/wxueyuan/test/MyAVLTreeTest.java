package com.wxueyuan.test;

import java.util.Arrays;

import org.junit.Test;

import com.wxueyuan.DataStructure.MyAVLTree;

public class MyAVLTreeTest {

	@Test
	public void testInsert() {
		MyAVLTree<Integer> avlTree = new MyAVLTree<>();
		avlTree.insert(100);  
        avlTree.insert(120);  
        avlTree.insert(300);  
        avlTree.insert(500);  
        avlTree.insert(111);  
        avlTree.insert(92);  
        avlTree.insert(77);  
        avlTree.insert(125);  
        avlTree.insert(80);  
        avlTree.insert(85); 
        System.out.println(Arrays.toString(avlTree.preOrder().toArray()));
		System.out.println(Arrays.toString(avlTree.inOrder().toArray()));
		System.out.println(Arrays.toString(avlTree.postOrder().toArray()));
		System.out.println(Arrays.toString(avlTree.levelOrder().toArray()));
		System.out.println(avlTree.root());
	}

}
