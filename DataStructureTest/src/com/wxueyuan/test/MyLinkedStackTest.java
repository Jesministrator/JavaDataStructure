package com.wxueyuan.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wxueyuan.DataStructure.MyLinkedStack;

public class MyLinkedStackTest {

	@Test
	public void testPush() {
		MyLinkedStack<Integer> stack = new MyLinkedStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertEquals("[4, 3, 2, 1]", stack.toString());
		assertEquals(new Integer(4), stack.peek());
	}

	@Test
	public void testPop() {
		MyLinkedStack<Integer> stack = new MyLinkedStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		assertEquals("[3, 2, 1]", stack.toString());
		assertEquals(new Integer(3), stack.peek());
	}

	@Test
	public void testPeek() {
		MyLinkedStack<Integer> stack = new MyLinkedStack<>();
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
		MyLinkedStack<Integer> stack = new MyLinkedStack<>();
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
		MyLinkedStack<Integer> stack = new MyLinkedStack<>();
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
		MyLinkedStack<Integer> stack = new MyLinkedStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(null);
		System.out.println(stack);
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
