package com.atguigu.java;
/*
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable {

    private static class Node<E> { // 节点类
        E item; // 数据域
        Node<E> next; // 下一个
        Node<E> prev; // 上一下

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    // 计数器
    transient int size = 0;

    // 头引用
    transient Node<E> first;

    // 尾引用
    transient Node<E> last;

    // 修改次数, 用于控制迭代器的同步
    protected transient int modCount = 0;

    public LinkedList() {
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    void linkLast(E e) {
        final Node<E> l = last; // 老尾, @838
        final Node<E> newNode = new Node<>(l, e, null); // 第1个参数是上一个指针, 第2个参数是数据, 第3个参数是 下一个指针
        last = newNode; // 刷新尾, 变成新尾.
        if (l == null) // 老尾为空,说明链表为空
            first = newNode; // 第一个元素
        else
            l.next = newNode; // 让老尾指向新结点
        size++; // 调整计数器
        modCount++; // 调整修改次数
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    E unlink(Node<E> x) { // x是删除目标节点 @846
        // assert x != null;
        final E element = x.item; // 获取老数据
        final Node<E> next = x.next; // 下一个结点
        final Node<E> prev = x.prev; // 上一个结点

        if (prev == null) { // 判断是否删除头结点
            first = next; // 刷新头
        } else { // 不是删除头
            prev.next = next; // 让上一个结点的 next指针  指向目标的下一个结点对象, 不再指向目标
            x.prev = null; // 删除目标结点的prev指针置空
        }

        if (next == null) { // 判断是否删除尾结点
            last = prev; // 刷新尾, 让它指向上一个.
        } else { // 不是删除尾
            next.prev = prev; // 让下一个结点的 prev指针 指向目标的上一个结点对象,不再指向目标
            x.next = null; // 删除目标的next置空
        }

        x.item = null; // 目标结点的数据域也置空.
        size--; // 调整计数器
        modCount++; // 修改次数
        return element;
    }

}

 */