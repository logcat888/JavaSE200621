package com.atguigu.java;

import java.util.*;
/*
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    // 数组的缺省容量是 10
    private static final int DEFAULT_CAPACITY = 10;

    // 空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    // 空数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    // 最重要的内部的数组, 它用于保存批量的对象.
    transient Object[] elementData; // non-private to simplify nested class access

    // 元素个数, 计数器
    private int size;

    // 修改次数, 只要添加元素或插入或删除元素都会导致这个数+1
    protected transient int modCount = 0;

    // 内部数组是空的, 不能保存元素
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // 添加方法
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e; // 元素插入, 最重要的语句1#########################################
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) { // 1
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }
    // 计算容量
    private static int calculateCapacity(Object[] elementData, int minCapacity) { // 1
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) { // 第一次添加元素时进入
            return Math.max(DEFAULT_CAPACITY, minCapacity); // max(10, 1)
        }
        return minCapacity;
    }
    private void ensureExplicitCapacity(int minCapacity) { // 10
        modCount++; // 修改次数+1

        // overflow-conscious code
        if (minCapacity - elementData.length > 0) // 10 - 0
            grow(minCapacity); // 第一次就要扩容
    }

    private void grow(int minCapacity) { // 10
        // overflow-conscious code
        int oldCapacity = elementData.length; // 老容量
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 新容量 = 老容量*1.5
        if (newCapacity - minCapacity < 0) // 第一次会进入
            newCapacity = minCapacity; // 新容量 = 10
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // [5, 11, 22, 44, 55, 50, 70, 20]
    // [5, 11, 22, 44, 55, 50, 70, 20]
    // [5, 11, 44, 55, 50, 70, 20, 20]
    // [5, 11, 44, 55, 50, 70, 20, null]
    public E remove(int index) { // 2
        rangeCheck(index); // 检索是否在范围内

        modCount++; // 修改次数+1
        E oldValue = elementData(index); // 获取老值
        // 移动多少元素
        int numMoved = size - index - 1; // 8 - 2 - 1 = 5
        if (numMoved > 0) {
            // 把右侧的元素依次左移.
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);// 元素插入, 最重要的语句2#########################################
        }
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    // 内部类的迭代器
    private class Itr implements Iterator<E> {
        int cursor;       // 游标
        int expectedModCount = modCount; // 当前的modCount值写入期望的modCount = 8

        public E next() { // 获取元素方法
            checkForComodification(); // 检查同步
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) // 当期望的修改次数 和 实际的修改次数不一样时, 抛出异常.
                throw new ConcurrentModificationException();
        }
    }

}
*/