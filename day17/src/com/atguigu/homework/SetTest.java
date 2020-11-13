package com.atguigu.homework;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author chenhuiup
 * @create 2020-07-15 下午 1:24
 */
public class SetTest {

    /*
    创建一个Set集合，保存10个20以内的随机整数
     */
    @Test
    public void test1(){
        Set set = new HashSet();

        while(set.size() != 10){
            int i = (int) (Math.random() * 20 + 1);
            set.add(i);
        }

        //方式一：iterator循环
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println("***********");
        //方式二：foreach循环
        for (Object obj:set ){
            System.out.print(obj + " ");
        }

        System.out.println("***********");
        //方式三：forEach循环
//        set.forEach(System.out::print);
        set.forEach(System.out::println);

        System.out.println("***********");
        //方式四：经典for循环
        Object[] objects = set.toArray();
        for (int i = 0; i < set.size(); i++) {
            System.out.print(objects[i] + " ");
        }
    }
}
