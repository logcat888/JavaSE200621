package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 结论：
 *  向Collection接口的实现类的对象中添加obj时，要求obj所在类重写equals().
 * @author chenhuiup
 * @create 2020-07-13 下午 7:20
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        Person p = new Person("Jeery", 20);
//        coll.add(p);
        coll.add(new Person("Jeery", 20));

        //1.contain(Object obj):判断当前集合中是否包含obj
        //我在判断是会调用obj对象所在类的equals()。
        boolean contains = coll.contains(123);
        System.out.println(contains);//true
        System.out.println(coll.contains(new String("Tom")));//true
//        System.out.println(coll.contains(p)));//true
        System.out.println(coll.contains(new Person("Jeery", 20)));//true

        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));//true
    }

    @Test
    public void test2(){
        //3.remove(Object obj):从当前集合中移除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jeery", 20));

        boolean remove = coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("Jeery", 20));
        System.out.println(coll);

        //4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jeery", 20));

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合。
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):要想返回true,需要当前集合和形参集合的元素都相同。
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Jeery", 20));

        System.out.println(coll.equals(coll1));//false,主要是因为ArrayList是有序的。

    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jeery", 20));

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 ---> 数组：toArray():
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //扩展：数组 ---> 集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);//[AA, BB, CC]
        System.out.println(list.size());//3
        System.out.println(list.getClass());//class java.util.Arrays$ArrayList
//        list.add("ss");//不能添加元素，汇报UnsupportedOperationException异常
//        System.out.println(list);


        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1);//[[I@22927a81]
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr2.size());//1

        List arr3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr3.size());//2

        //9.iterator()：返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试。

    }
}
