package com.atguigu.homework;

/**
 * @author chenhuiup
 * @create 2020-07-17 上午 8:45
 */
public class homework {
    /*
1.	Collection接口表示的集合, 存储数据有什么特点? 它的两个子接口分别是什么? 分别的存储数据的特点又是什么?
	Collection接口存储单列集合，无序的，可重复的
	|-----Collection：存储单列集合，无序的，可重复的，存储一个一个的对象
        |-----List接口：存储有序，可重复的对象，存储的对象需要重写equals方法
            |----ArrayList：底层使用数组，存储有序可重复的对象，“动态”数组；线程不安全的，效率高，适合遍历，查找操作
            |----LinkedList：以双向链表的形式存储数据，对于频繁的插入、删除操作，效率高
            |----Vector：jdk1.0，线程安全的，效率低
        |-----Set接口：存储无序不可重复的对象，对于（HashSet和LinkedHashSet）存储的对象需要重写equals()和hashCode(),对于TreeSet，存储的对象需要实现Comparabale接口或定制排序
            |----HashSet：存储无序，不可重复的对象，底层使用HashMap，只不过entry中的value是Object。
                |----LinkedHashSet，采用双向链表的形参存储数据
            |----TreeSet：底层使用红黑二叉树存储

2.	ArrayList和LinkedList有区别吗? 区别是什么? 为什么能用链表实现List集合?



3.	HashSet集合中是如何判断两个对象重复的? 要想让两个自定义对象重复, 如何才能做到?



4.	如何使用迭代器遍历一个集合? 写出代码. 并加上注释, 说明注意点.

     */
}
