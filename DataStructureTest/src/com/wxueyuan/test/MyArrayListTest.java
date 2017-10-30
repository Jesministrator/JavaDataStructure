package com.wxueyuan.test;

import  static org.junit.Assert.*;

import org.junit.Test;

import com.wxueyuan.DataStructure.MyArrayList;



public class MyArrayListTest {
	
	
	
	@Test
	public void testSize() {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.remove(new Integer(300));
		list.remove(1);
		assertEquals(list.size(), 1);
	}

	@Test
	public void testIsEmpty() {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.remove(new Integer(300));
		list.remove(1);
		list.remove(0);
		assertEquals(list.isEmpty(), true);
	}

	@Test
	public void testContains() {

		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.remove(new Integer(300));
		list.remove(1);
		assertEquals(list.contains(100), true);
	
	}

	@Test
	public void testAddE() {
		MyArrayList<Integer> list = new MyArrayList<Integer>(4);
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.add(1, 500);
		assertEquals("[300, 500, 100, 200]", list.toString());
	}

	@Test
	public void testAddIntE() {
		MyArrayList<Integer> list = new MyArrayList<Integer>(5);
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.add(1, 500);
		list.add(4, 1000);
		assertEquals("[300, 500, 100, 200, 1000]", list.toString());
	}

	@Test
	public void testRemoveObject() {
		MyArrayList<Integer> list = new MyArrayList<Integer>(5);
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.add(1, 500);
		list.add(4, 1000);
		list.remove(new Integer(1000));
		list.remove(new Integer(300));
		assertEquals("[500, 100, 200, null, null]", list.toString());
	}

	@Test
	public void testRemoveInt() {
		MyArrayList<Integer> list = new MyArrayList<Integer>(5);
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.add(1, 500);
		list.add(4, 1000);
		list.remove(0);
		list.remove(1);
		assertEquals("[500, 200, 1000, null, null]", list.toString());
	}

	@Test
	public void testClear() {
		MyArrayList<Integer> list = new MyArrayList<Integer>(5);
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.add(1, 500);
		list.add(4, 1000);
		list.clear();
		assertEquals("[null, null, null, null, null]", list.toString());
		assertEquals(list.size(), 0);
	}

	@Test
	public void testGet() {
		MyArrayList<Integer> list = new MyArrayList<Integer>(5);
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.add(1, 500);
		list.add(4, 1000);
		assertEquals(list.get(0),new Integer(300));
	
	}

	@Test
	public void testSet() {

		MyArrayList<Integer> list = new MyArrayList<Integer>(5);
		list.add(100);
		list.add(200);
		list.add(0, 300);
		list.add(1, 500);
		list.add(4, 1000);
		assertEquals(list.set(0,10000),new Integer(300));
	
	
	}

}
