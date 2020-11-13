package com.atguigu.java;

class A {
    int n;
    static {
        System.out.println("A static"); // 1
    }
    {
        System.out.println("A {}"); // 2
    }
    A() {
        super();
        System.out.println("A()"); // 3
    }
}
class B extends A {
    int n;
    static {
        System.out.println("B static"); // 4
    }
    {
        System.out.println("B {}"); // 5
    }
    B() {
        super();
        System.out.println("B()"); // 6
    }
}
class C extends B {
    int n;
    static {
        System.out.println("C static"); // 7
    }
    {
        System.out.println("C {}"); // 8
    }
    C() {
        super();
        System.out.println("C()"); // 9
    }
}

public class ObjectTest {

    public static void main(String[] args) {
        new C();
        // 先静后动, 先父后子
        // 加载A, 再加载B, 再加载C.
    }

}
