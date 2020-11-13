package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *      总结：
 *      ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *      ② 在实例化集合类时，可以指明具体的泛型类型
 *      ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *          比如：add(E e) --->实例化以后：add(Integer e)
 *      ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换。
 *      ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 *  3.如何自定义泛型结构：泛型类、泛型接口、泛型方法:见GenericTest1.java
 *

 *
 *
 * @author chenhuiup
 * @create 2020-07-15 下午 11:39
 */
public class GenericTest {

    //在集合中使用泛型之前的情况,以ArrayList为例
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(88);
        list.add(76);
        list.add(56);
        list.add(91);
        //问题一：类型不安全
        list.add("Tom");

        for(Object obj:list){
            //问题二：强转时，可能出现ClassCastException
            int score = (int)obj;

            System.out.println(score);
        }
    }

    //在集合中使用泛型的情况
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(56);
        list.add(36);
        list.add(91);
        //编译时，就会进行类型检测，保证数据的安全
//        list.add("Tom");

        //方式一：
        for(Integer score:list){
            //避免了强转操作
            int stuScore = score;

            System.out.println(stuScore);
        }

        //方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        //标准写法
        // Map<String,Integer> map = new HashMap<String,Integer>();
        //jdk7新特性 ： 类型推断
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",15);
         map.put("Jerry",15);
         map.put("Jack",15);

         //map.put(15,"abc");
        //泛型的嵌套
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        //Set<Entry<String,Integer>> set1 = map.entrySet();
        //import java.util.map.*;直接使用内部类，必须导入外部类的包

        Iterator<Map.Entry<String,Integer>> iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry<String,Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "------>" + value);
        }
    }
}

