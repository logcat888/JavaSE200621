package com.atguigu.java2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Map : 保存具有映射关系的键对象和值对象们
 * 键到值是单向一对一的映射, 根据键对象可以定位唯一的值对象.
 * Map中暗含两个子集合一个是Set子集合, 保存所有的键对象, 另一个Collection子集体, 保存所有的值.
 *
 * Map也可以看成是一个保存多个Entry对象(里面有键又有值) 的Set集合
 *
 * 实现子类 :
 *      HashMap : 使用哈希算法实现的Map集合,使用频率最高的
 *      TreeMap : 基于二叉搜索树实现的Map集合.
 *
 * 方法
 * Object put(Object key, Object value); // 放入键对象和值对象, 像写入词条
 * Object get(Object key); // 根据键对象, 获取值对象, 像查词典
 * Object remove(Object key); // 删除键和值对象
 * Set keySet() 返回保存所有键对象的Set子集合.
 * Set entrySet(); 返回保存所有条目对象的Set集合.
 *
 * Hashtable 和 HashMap几乎完全一样, Hashtable线程安全, 效率低, HashMap效率高, 线程不安全.
 */
public class MapTest {

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties(); // 推荐使用它的默认类型String
        properties.load(new FileInputStream("test.properties")); // 自动读取文件中的键值对, 并保存在其中
        String user = properties.getProperty("user");
        System.out.println(user);
        String password = properties.getProperty("password");
        System.out.println(password);
    }

    /*编写程序，在main方法中创建Map集合（使用泛型），用来存放圆的半径（key）和面积（value）；
    以半径为key，面积为value，将半径1-50的圆面积数据(直接取整)保存其中；
    将Map中的半径数据取至Set集合中；
    遍历Set集合的半径，逐一从Map中取出对应的面积值，并将半径和面积打印出来。*/
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i < 51; i++) {
            int area = (int)(Math.PI * i * i);
            map.put(i, area);
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer value = map.get(key);
            System.out.println(key + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + value);
        }
    }


    @Test
    public void test1() {
        Map<Integer, String> map = new HashMap<Integer, String>(); // 空词典
        // 写入词条
        map.put(8, "eight");
        map.put(2, "two");
        map.put(7, "seven");
        map.put(3, "three");
        map.put(4, "four");
        map.put(2, "TWO"); // 相同的键会导致 新值覆盖老值.

        System.out.println(map.size());

        System.out.println(map);

        String value = map.get(70); // 获取值是, 如果键不存在, 返回null
        System.out.println(value);

        System.out.println("**************************************");

        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value2 = map.get(key);
            System.out.println(key + " >>>>>>>>>>>>>>>>>>>>>>>>> " + value2);
        }

        // 获取所有条目
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> next = iterator1.next();
            System.out.println(next.getKey() + "............." + next.getValue());
        }


    }
}
