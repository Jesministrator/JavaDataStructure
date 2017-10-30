package com.wxueyuan.DataStructure;

import java.util.Arrays;

import com.wxueyuan.ADT.MyList;

public class MyArrayList<E> implements MyList<E>{

	//在声明MyArrayList时，如不指明大小，则初始大小为10
    private static final int DEFAULT_CAPACITY = 10;
    private E[] contents;
    private int size = 0;

    //两种构造函数，允许用户创建指定大小或者默认大小的线性表
    public MyArrayList(){
        init(DEFAULT_CAPACITY);
    }
    public MyArrayList(int initCapacity){
        init(initCapacity);
    }
    //私有化方法init帮助构造函数来初始化数组contents
    @SuppressWarnings("unchecked")
	private void init(int capacity){
        //注意不能建立泛型数组，因此我们强行转换一个Object数组
        contents = (E[]) new Object[capacity];
    }
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if(o == null) {
			for(int i=0 ;i<size(); i++) {
				if(contents[i] == null)
					return true;
			}
			return false;
		}else {
			for(int i=0 ;i<size(); i++) {
				if(o.equals(contents[i]))
					return true;
			}
			return false;
		}
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		//在插入元素之前，检查数组是否有足够的空间放置新的元素，若没有，则对数组进行扩容
		ensureCapacity();
		contents[size++] = e;
		return true;
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if(size()>=contents.length) {
			//此处新数组的容量是旧数组的2倍加1，你可以自己选择扩容的多少
			E[] newContents = (E[]) new Object[2*contents.length+1];
			//将就数组中的值全部拷于新数组中
			System.arraycopy(contents, 0, newContents, 0, size());
			//再让contents指向新的数组
			contents = newContents;
		}
	}
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		//一旦要插入元素的位置为负或大于目前的元素数量就抛出异常
        //此处允许index等于size，相当于在列表末尾插入元素
		if(index<0 || index>size())
			throw new ArrayIndexOutOfBoundsException();
		//在插入元素之前，检查数组是否有足够的空间放置新的元素，若没有，则对数组进行扩容
		ensureCapacity();
		//将数组中从index位置开始的size－index个元素复制到数组从index＋1开始的位置去
		//相当于将数组中index位置之后的元素顺次向后移动一位
		System.arraycopy(contents, index, contents, index+1, size() - index);
		//将要插入的元素放置到index位置上去
		contents[index] = element;
		this.size++;
	}
	/*
	 * 等价与上面的add(int index, E element)方法
	 * 
	 * System.arraycopy(contents, index, contents, index+1, size() - index);
	 * 等价于:
	 * for(int i=size(); i>index; i--){ 
			contents[i] = contents[i-1];
	   }
	 * 
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		//一旦要插入元素的位置为负或大于目前的元素数量就抛出异常
        //此处允许index等于size，相当于在列表末尾插入元素
		if(index<0 || index>size())
			throw new ArrayIndexOutOfBoundsException();
		//在插入元素之前，检查数组是否有足够的空间放置新的元素，若没有，则对数组进行扩容
		ensureCapacity();
		for(int i=size(); i>index; i--) 
			contents[i] = contents[i-1];
		//将要插入的元素放置到index位置上去
		contents[index] = element;
		this.size++;
	}*/

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(o == null) {
			for(int i=0; i<size(); i++) {
				if(contents[i] == null) {
					//如果找到元素为null，就使用私有方法fastRemove将该位置元素删除
					fastRemove(i);
					return true;
				}
			}
			return false;
		}else {
			for(int i=0; i<size();i++) {
				if(contents[i].equals(o)) {
					//如果找到元素为o，就使用私有方法fastRemove将该位置元素删除
					fastRemove(i);
					return true;
				}
			}
			return false;
		}
	}
	private void fastRemove(int index) {
		// TODO Auto-generated method stub
		//需要从后向前移动的元素数目
        int numMoved = size() - index -1;
        if(numMoved > 0){
            //将数组i+1位置开始的numMoved个元素移动到数组i的位置
            //相当于将i位置上的元素删除，并将后面的元素向前移一位
            System.arraycopy(contents,index+1,contents,index,numMoved);
        }
        //将元素数目减一并释放原来最后一位的内存
        contents[--size] = null;
	}
	
	/*
	 * 等价与上面的fastRemove(int index)方法
	 * 
	 * System.arraycopy(contents,index+1,contents,index,numMoved);
	 * 等价于:
	 * for(int i=index; i<size()-1; i++){
			contents[i] = contents[i+1];
	   }
	 * 
	private void fastRemove(int index) {
		// TODO Auto-generated method stub
		for(int i=index; i<size()-1; i++)
			contents[i] = contents[i+1];
        //将元素数目减一并释放原来最后一位的内存
        contents[--size] = null;
	}*/
	
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		//一旦要插入元素的位置为负或大于目前的元素数量就抛出异常
        //此处不允许index等于size
		checkIndexValidation(index);
		E element = contents[index];
		fastRemove(index);
		return element;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i=0; i<size(); i++) {
			contents[i] = null;
		}
		size = 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkIndexValidation(index);
		return contents[index];
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		checkIndexValidation(index);
		E old = contents[index];
		contents[index] = element;
		return old;
	}
	
	private void checkIndexValidation(int index) {
		if(index<0 || index>=size())
			throw new ArrayIndexOutOfBoundsException();
	}
	
	@Override
	public String toString() {
		return Arrays.toString(contents);
	}
}
