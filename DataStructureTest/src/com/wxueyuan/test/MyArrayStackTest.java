package com.wxueyuan.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wxueyuan.DataStructure.MyArrayStack;

public class MyArrayStackTest {

	@Test
	public void testPush() {
		MyArrayStack<Integer> stack = new MyArrayStack<>(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertEquals("[1, 2, 3, 4]", stack.toString());
		assertEquals(new Integer(4), stack.peek());
	}

	@Test
	public void testPop() {
		MyArrayStack<Integer> stack = new MyArrayStack<>(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		assertEquals("[1, 2, 3, null]", stack.toString());
		assertEquals(new Integer(3), stack.peek());
	}

	@Test
	public void testPeek() {
		MyArrayStack<Integer> stack = new MyArrayStack<>(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		assertEquals(new Integer(3), stack.peek());
		stack.pop();
		assertEquals(new Integer(2), stack.peek());
		stack.pop();
		assertEquals(new Integer(1), stack.peek());
		stack.pop();
		assertEquals(true, stack.empty());
		
	}

	@Test
	public void testEmpty() {
		MyArrayStack<Integer> stack = new MyArrayStack<>(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		assertEquals(new Integer(3), stack.peek());
		stack.pop();
		assertEquals(new Integer(2), stack.peek());
		stack.pop();
		assertEquals(new Integer(1), stack.peek());
		stack.pop();
		assertEquals(true, stack.empty());
		stack.push(4);
		assertEquals(false, stack.empty());
	}

	@Test
	public void testSearch() {
		MyArrayStack<Integer> stack = new MyArrayStack<>(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(null);
		assertEquals(1, stack.search(null));
		stack.pop();
		assertEquals(-1, stack.search(null));
		assertEquals(3, stack.search(new Integer(1)));
	}

	@Test
	public void testClear() {
		MyArrayStack<Integer> stack = new MyArrayStack<>(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(null);
		assertEquals(1, stack.search(null));
		stack.pop();
		assertEquals(-1, stack.search(null));
		assertEquals(3, stack.search(new Integer(1)));
		stack.clear();
		assertEquals(-1, stack.search(null));
		assertEquals(-1, stack.search(new Integer(1)));
		assertEquals(true, stack.empty());
	}

}
