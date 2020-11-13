package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhuiup
 * @create 2020-07-16 上午 10:40
 */
public class Order<T> {

    String ordername;
    int orderId;

    //类的内部结构就可以使用类的泛型

    T orderT;

    public Order(){
        //编译不通过
//        T[] arr = new T[10];
        //编译通过
        T[] arr = (T[]) new Object[10];
    }

    public Order(String name,int orderId,T orderT){
        this.ordername = name;
        this.orderId = orderId;
        this.orderT = orderT;
    }


    //如下的三个方法都不是泛型方法
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;
    }

    //静态方法中不能使用类的泛型。 因为泛型只有在创建对象时才能指定，而静态方法随着类的加载而加载。
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    public void show(){
        //编译不通过
//        try{
//
//        }catch (T t){
//
//        }
    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以被static修饰，原因：泛型参数是在调用方法时确定。并非在实例化类时确定。

    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e: arr) {
            list.add(e);
        }
        return list;
    }
}
