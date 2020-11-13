package com.atguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * forEach(System.out::println)循环
 *
 * @author chenhuiup
 * @create 2020-07-14 下午 8:56
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(556);

        coll.forEach(System.out::println);
    }

    @Test
    public void test2(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);

        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);//{1001,CC}{1002,BB}
        set.add(new Person(1001,"CC"));
        System.out.println(set);//{1001,CC}{1002,BB}{1001,CC}
        set.add(new Person(1001,"AA"));
        System.out.println(set);//{1001,CC}{1001,AA}{1002,BB}{1001,CC}


    }
}
