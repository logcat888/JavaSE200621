package com.atguigu.java1;

/**
 * @author dexter
 * @create 2020-07-15
 */
public class Linked {
    private class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(int obj) {
        Node newNode = new Node(obj);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(int value) {
        if (head.value == value) {
            head = head.next;
            size--;
            return true;
        }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.value == value) {
                if (prev.next == tail) {
                    tail = prev;
                }
                prev.next = prev.next.next;
                size--;
                return true;
            }
            prev = prev.next;
        }
        return false;
    }

    public void trave() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public int getSize(){
        return size;
    }

    public void quickSort(){
        subSort(head, tail);
    }

    public void subSort(Node low, Node high){
        if (low == null || low.next == null || low == high) return;
        int pivot = low.value;
        Node i = low.next;
        Node i_pre = low;//一直指向i的前一个Node，因为将来要和low做交换
        Node j = low.next;

        while (j != high.next){
            if(j.value < pivot){
                swapNode(i, j);
                i_pre = i;//让i的前一个指针先指向i，再让i往下指
                i = i.next;
            }
            j = j.next;
        }
        swapNode(low, i_pre);
        subSort(low, i_pre);
        subSort(i, high);
    }

    public void swapNode(Node a, Node b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
}

















