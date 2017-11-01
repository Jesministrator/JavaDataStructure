package com.wxueyuan.ADT;

public interface MyStack<E> {
	public E push(E item);                    //将新的元素压入栈顶
	public E pop();                            //弹出栈顶的元素
	public E peek();                           //返回栈顶的元素，但不从栈中删除
	public boolean empty();                    //检查栈是否为空
	public int search(Object o);               //返回某个元素在栈中基于1的位置，也就是该元素到栈顶的距离,比如栈顶元素的值应该为1
	public void clear();                      //清空整个栈
}
