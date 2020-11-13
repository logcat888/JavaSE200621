package com.atguigu.java;

import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.util.*;

/**
 * Collection :
 *
 *      Set : 无序不可重复
 *          HashSet : 基于数组使用哈希算法实现 : 内部使用了HashMap, 只用到键的部分.
 *              优点 : 全是优点
 *              缺点 : 对内存要求高
 *          TreeSet : 基于红黑树实现 : 内部使用了TreeMap, 只用到键的对象.
 *              优点 : 对内存要求低, 搜索速度极快
 *              缺点 : 插入删除元素速度慢
 *      List : 有序可重复
 *          ArrayList : 基于数组实现
 *              优点 : 末端数据处理快, 检索速度快
 *              缺点 : 对内存要求高, 非末端数据的插入或删除最慢
 *          LinkedList : 基于链表实现
 *              优点 : 对内存要求低, 插入删除元素的速度非常快
 *              缺点 : 检索速度慢
 *
 * Map :
 *      HashMap
 *      TreeMap
 *      Hashtable
 */
public class MapTest {

    public static void main(String[] args) {
        Integer[] datas = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(datas); // list是不可以改变容量的.
        list.add(5);
        System.out.println(list.size());

    }

    @Test
    public void test1() {
        //Set set = new HashSet();
        //set.add(10);
        HashMap<Integer, String> map = new HashMap<>();
        map.put(5, "five");
        map.put(2, "two");

        map.put(80, "eight");

        map.put(800, "eight");


        map.put(8000, "eight");
        map.put(8016, "eight");
        map.put(8032, "eight");
        map.put(8064, "eight");
        map.put(8128, "eight");
        map.put(8256, "eight");
        map.put(816, "eight");

        System.out.println(map);

    }
}
