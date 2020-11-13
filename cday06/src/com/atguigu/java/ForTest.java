package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组。
 *
 * @author chenhuiup
 * @create 2020-07-13 下午 9:15
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jeery", 20));

        //for(集合元素的类型  局部变量 ： 集合对象)
        //内部仍然调用了迭代器。
        for (Object obj:coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //for(数组元素的类型  局部变量 ： 数组对象)
        for (int i : arr){
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM"};

        //方式一：普通for赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "GG";
        }

        //方式二：增强for循环
        for (String s: arr) {
            s = "GG"; //因为是通过迭代器的方式将数组中的元素返回给形参，故无法修改数组中的元素,操作数组更加安全。
//            s = arr[i];将数组中的元素取出来给临时变量s。
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
