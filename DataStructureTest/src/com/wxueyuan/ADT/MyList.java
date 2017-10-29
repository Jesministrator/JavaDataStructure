package com.wxueyuan.ADT;

public interface MyList<E> {
	int size();                        //返回线性表中元素的个数
	boolean isEmpty();                 //检查线性表是否为空
	boolean contains(Object o);        //检查线性表是否包含某个元素
	boolean add(E e);                  //在线性表的结尾插入一个元素
	void add(int  index, E element);   //在线性表指定位置插入一个元素
	boolean remove(Object o);          //在线性表中删除指定元素
	E remove(int index);               //删除线性表上指定位置的元素
	void clear();                      //清空整个线性表
	E get(int index);                  //返回指定位置上的元素
	E set(int index, E element);       //替换指定位置上的元素
}
