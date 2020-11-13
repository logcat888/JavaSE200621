package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 *  1. 内部的方法：hasNext() 和 next()
 *  hasNext():判断是否还有下一个元素
 *  next():①指针下移；②将下移以后集合位置上的元素返回
 *
 *  2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一元素之前。
 *
 *  3.内部定义了remove()，可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove().
 *
 *
 *  注意点：
 *  1.Iterator iterator = coll.iterator();  并不是将集合对象coll赋值给iterator，而通过在coll前加指针的方式遍历集合。
 *  2.iterator可以删除集合中的元素，但是是遍历过程中通过迭代器对象的remove方法，不是集合对象的remove方法。
 *  3.如果还未调用next()或在上一次调用next方法之后已经调用了remove方法，再调用remove都会报illegalStateException。
 *
 * @author chenhuiup
 * @create 2020-07-13 下午 8:28
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jeery", 20));

        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：不推荐
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }

        //方式三：推荐
        //hasNext():判断是否还有下一个元素
        while(iterator.hasNext()){
            //next():①指针下移；②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jeery", 20));

        Iterator iterator = coll.iterator();

        //错误方式一：
//        while((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一元素之前。
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }


    //测试Iterator中的remove()
    //iterator可以删除集合中的元素，但是是遍历过程中通过迭代器对象的remove方法，不是集合对象的remove方法。
    //如果还未调用next()或在上一次调用next方法之后已经调用了remove方法，再调用remove都会报illegalStateException。

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jeery", 20));

        Iterator iterator = coll.iterator();

        //删除集合中“Tom”
        while(iterator.hasNext()){
//            iterator.remove();
            Object obj = iterator.next();
            if ("Tom".equals(obj)){//obj放在形参中代码的健壮性更好，因为若obj为null且用obj.equals()，会报空指针异常
                iterator.remove();
//                iterator.remove();
            }
        }
        //iterator可以删除集合中的元素，但是是遍历过程中通过迭代器对象的remove方法，不是集合对象的remove方法。
        //如果还未调用next()或在上一次调用next方法之后已经调用了remove方法，再调用remove都会报illegalStateException。
        //遍历集合
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }


}
