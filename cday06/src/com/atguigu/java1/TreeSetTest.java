package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author chenhuiup
 * @create 2020-07-14 下午 7:22
 */
public class TreeSetTest {

    /*
    1. 向TreeSet中添加的数据，要求是相同类的对象。添加的元素必须实现Comparable(compareTo())或Comparator(compare())
    2. 两种排序方式：自然排序(实现Comparable接口) 和 定制排序(Comparator)。

    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
     */

    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象。
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

        //举例一：
        set.add(34);
        set.add(-34);
        set.add(43);
        set.add(53);
        set.add(8);

        //举例二:
        set.add(new User("Tom",12));
        set.add(new User("Jerry",52));
        set.add(new User("Bob",19));
        set.add(new User("Ace",33));
        set.add(new User("Joker",45));
        set.add(new User("Joker",55));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    return Integer.compare(((User) o1).getAge(),((User) o2).getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不一致");
                }
            }
        };
        TreeSet set = new TreeSet(com);

        set.add(new User("Tom",12));
        set.add(new User("Jerry",52));
        set.add(new User("Bob",19));
        set.add(new User("Ace",33));
        set.add(new User("Joker",45));
        set.add(new User("Joker",55));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

