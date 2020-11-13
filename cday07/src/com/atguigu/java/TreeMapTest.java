package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author chenhuiup
 * @create 2020-07-15 下午 6:49
 */
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序 、 定制排序

    //自然排序
    @Test
    public void test(){
        TreeMap map = new TreeMap();
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 32);
        User u3 = new User("Jack", 20);
        User u4 = new User("ROse", 18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            Object value = map.get(key);
            System.out.println(key + ",成绩为" + value);
        }
    }

    //定制排序
    @Test
    public void test1() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return u1.getAge() - u2.getAge();
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 32);
        User u3 = new User("Jack", 20);
        User u4 = new User("ROse", 18);
        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object entry = iterator.next();
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey() + "--->" + entry1.getValue());
        }
    }

}
