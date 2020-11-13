package com.atguigu.java1;

class Node {
    int value;
    Node next;
}

class Link {

    private Node head;
    private Node tail;

    public void add(int n) {
        Node newNode = new Node();
        newNode.value = n; // 携带数据, 此时它的next指针是null
        if (head == null) { // 链表为空
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // 让老尾的next指向新结点
            tail = newNode; // 刷新尾引用, 让它指向最新的结点.
        }
    }

    public void travel() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    /**
     * 删除
     * @param n
     * @return 如果成功返回true, 如果删除失败返回false
     */
    public boolean remove(int n) {
        /*
        Node prev = ?;
        while () {
            if (prev.next.value == n) {
                // 真正的删除
                // 让前一个结点的next指向 删除目标的 下一个结点.
                return true;
            }
            prev = prev.next;
        }   */
        return false;


    }

    /**
     * 返回链表中的元素个数
     * @return
     */
    public int size() {
        return 0;
    }
}

public class LinkTest {

    public static void main(String[] args) {
        Link link = new Link();
        link.add(10);

        link.add(2);
        link.add(5);
        link.add(8);
        link.add(20);
        link.add(5);

        link.travel();

        link.remove(8);
    }
}
