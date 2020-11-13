package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 如何自定义泛型结构：泛型类、泛型接口、泛型方法:见GenericTest1.java
 *
 * 1.关于自定义泛型类、泛型接口：
 *
 * //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型为Object类型
 *         //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
 * //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象是，不再需要指明泛型。
 *结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型。
 *
 * 2.关于自定义泛型方法：
 * *  //静态方法中不能使用类的泛型。 因为泛型只有在创建对象时才能指定，而静态方法随着类的加载而加载。
 *  *  //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
 *  *     //换句话说，泛型方法所属的类是不是泛型类都没有关系。
 *  *     //泛型方法，可以被static修饰，原因：泛型参数是在调用方法时确定。并非在实例化类时确定。
 * @author chenhuiup
 * @create 2020-07-16 上午 10:45
 */
public class GenericTest1 {

    @Test
    public void test1(){

        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");


        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<String>("orderAA",1001,"AA:hi");

        order1.setOrderT("AA:hello");
    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();

        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象是，不再需要指明泛型。
        sub1.setOrderT(11122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2...");
    }

    @Test
    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<>();
        //泛型不同的引用不能相互赋值。
//        list1 = list2;

        Person p1 = null;
        Person p2 = null;

        p1 = p2;
    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}

//结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型。
class Father<T1,T2>{

}
//子类不保留父类的泛型
//1)没有类型 擦除
class Son1 extends Father{
    //等于于class Son extends Father<Object,Object>{}
}
//2)具体类型
class Son2 extends Father<String,Integer>{}
//子类保留父类的泛型
//1）全部保留
class Son3<T1,T2> extends Father<T1,T2>{}
//2)部分保留
class Son4<T2> extends Father<Integer,T2>{}

//子类不保留父类的泛型
//1)没有类型 擦除
class Son5<A,B> extends Father{
    ////等于于class Son extends Father<Object,Object>{}
}
//具体类型
class Son6<A,B> extends Father<String,Integer>{}
//子类保留父类的泛型
//1）全部保留
class Son7<T1,T2,A,B> extends Father<T1,T2>{}
//2）部分保留
class Son8<T2,A,B> extends Father<Integer,T2>{}