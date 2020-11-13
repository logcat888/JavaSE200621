package com.atguigu.java;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型 : 解决类型安全问题. 在集合中用的多
 * 集合中使用了泛型 : 添加时只能添加指定类型的对象, 获取时直接获取指定类型的对象.
 * 自定义泛型类, 在类名<泛型类型参数>
 */

class Person<X> { // X代表了某种类型, 是什么具体的类型不知道. 既然是类型, 就可以用于声明变量或表达方法的返回值.
    // X会在这个类的使用时进一步具体化. X类型是隶属于对象的非静态成员.

    private String name;
    private X info; // info属性的类型就是泛型化的X类型, 会由使用者来决定具体的类型.

    public Person() {}

    public Person(String name, X info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public X getInfo() {
        return info;
    }

    public void setInfo(X info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", info=" + info +
                '}';
    }

    /* 在静态方法或属性中不可以使用泛型类型, 因为它隶属于对象
    public static void test(X x) {
    }*/
}

// 泛型和继承的关系
class Base<W> {

    protected W field;

    public W getField() {
        return field;
    }
}

class Sub1 extends Base {} // 子类继承有泛型的父类时, 直接忽略, 会导致父类中的泛型类型只能是Object类型

class Sub2 extends Base<String> {} // 子类在继承泛型父类时, 直接写死, 子类继承的泛型类型永远不变

class Sub3 extends Base<Boolean> {} // 这样的写法使用最多. 因为对于使用者最简单.

class Sub4<P> extends Base<P> {} // 最灵活的写法, 父类中的泛型在子类继续泛型, 这样的写法最灵活

// 泛型方法. 在方法声明中使用泛型.
class GenericMethod {

    // 在方法的返回值类型左面加上<泛型类型参数>, 泛型方法必须要使用泛型类型 作为参数的.
    // 是一个局部泛型, Q类型和方法的某次调用相关.
    public static <Q> Q get(Q q) {
        return null;
    }

    public <Y> Y get2(Y y) {
        return null;
    }

    /*
    public static void test2(Q q) {
    }*/
}

public class GenericTest {

    @Test
    public void test6() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 20));
        }
        Object[] objects = list.toArray();
        Integer[] arr = new Integer[0];
        Integer[] integers = list.toArray(arr); // 参数的作用最好就是让泛型方法感知到类型即可.
        for (int i = 0; i < integers.length; i++) {
            System.out.println(integers[i]);
        }

        System.out.println(arr);
        System.out.println(integers);
    }

    @Test
    public void test5() {
        //Object obj = GenericMethod.get();
        String ret1 = GenericMethod.get("abc");
        Boolean ret2 = GenericMethod.get(false);
        Object ret3 = GenericMethod.get(null); // null表示没有对象, 没有对象什么也确定不了, 什么也做了.
    }

    @Test
    public void test4() {
        Sub1 sub1 = new Sub1();
        Object field1 = sub1.getField();
        Sub2 sub2 = new Sub2();
        String field2 = sub2.getField();
        Sub3 sub3 = new Sub3();
        Boolean field3 = sub3.getField();

        Sub4<Double> sub4 = new Sub4<>();
        Double field = sub4.getField();
        Object field4 = new Sub4().getField();
    }

    @Test
    public void test3() {
        Person<Integer> p1 = new Person<Integer>();
        Integer info1 = p1.getInfo();
        p1.setInfo(40);

        Person<Boolean> p2 = new Person<Boolean>("李四", true);
        Boolean info2 = p2.getInfo();
        p2.setInfo(false);

        Person p3 = new Person("王五", false);
        Object info3 = p3.getInfo();

    }

    @Test
    public void test2() {
        Person p1 = new Person("张三", 30);
        Person p2 = new Person("李四", "女");

        Object info1 = p1.getInfo();
        p1.setInfo(false);

        Object info2 = p2.getInfo();
    }

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 20));
        }
        //list.add("ccc");
        //list.add(false);
        System.out.println(list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("sum = " + sum);
    }
}
