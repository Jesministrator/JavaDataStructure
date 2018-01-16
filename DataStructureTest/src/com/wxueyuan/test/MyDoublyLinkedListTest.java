package com.wxueyuan.test;

import static org.junit.Assert.*;

import org.junit.Test;


import com.wxueyuan.DataStructure.MyDoublyLinkedList;

public class MyDoublyLinkedListTest {

	@Test
	public void testSize() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.remove(new Integer(100));
		assertEquals(list.size(), 1);
	}

	@Test
	public void testIsEmpty() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.remove(new Integer(100));
		list.remove(0);
		assertEquals(list.isEmpty(), true);
	}

	@Test
	public void testContains() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.add(1, 300);
		list.add(400);
		list.remove(new Integer(100));
		assertEquals(list.contains(new Integer(200)), true);
		assertEquals(list.contains(new Integer(100)), false);
		assertEquals(list.contains(null), false);
	}

	@Test
	public void testAddE() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(2,600);
		list.add(400);
		list.add(500);
		
		assertEquals("[100, 200, 600, 300, 400, 500]", list.toString());
	}

	@Test
	public void testAddIntE() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.add(1,300);
		list.add(3,400);
		list.add(500);
		list.add(2,700);
		
		assertEquals("[200, 300, 700, 100, 400, 500]", list.toString());
	}

	@Test
	public void testRemoveObject() {

		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.add(1, 300);
		list.add(400);
		list.add(500);
		list.add(3,600);
		list.remove(new Integer(600));
		list.remove(new Integer(500));
		assertEquals("[200, 300, 100, 400]", list.toString());
	
	}

	@Test
	public void testRemoveInt() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.add(1, 300);
		list.add(400);
		list.add(500);
		list.add(3,600);
		list.remove(0);
		list.remove(1);
		assertEquals("[300, 600, 400, 500]", list.toString());
	}

	@Test
	public void testClear() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.add(1, 300);
		list.add(400);
		list.add(500);
		list.add(3,600);
		list.clear();
		assertEquals("[]", list.toString());
		assertEquals(0, list.size());
	}

	@Test
	public void testGet() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.add(1, 300);
		list.add(400);
		list.add(500);
		list.add(3,600);
		assertEquals(list.get(3),new Integer(600));
	}

	@Test
	public void testSet() {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
		list.add(100);
		list.add(0,200);
		list.add(1, 300);
		list.add(400);
		list.add(500);
		list.add(3,600);
		list.set(2, new Integer(1000));
		assertEquals("[200, 300, 1000, 600, 400, 500]",list.toString());
	}

}
