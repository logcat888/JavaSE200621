package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8 之前日期和时间的API测试
 *
 * @author chenhuiup
 * @create 2020-07-12 上午 10:18
 */
public class DateTimeTest {

    /*
    java.util.Date类
            |---java.sql.Date类

    1.两个构造器的使用
           >构造器一：Date()：创建一个对应当前时间的Date对象
           构造器二：创建指定毫秒数的Date对象

    2.两个方法的使用
        >toString()：显示当前的年、月、日、时、分、秒
        >getTime():获取当前Date对象对应的毫秒数。（时间戳）

    3.java.sql.Date对应着数据库中的日期类型的变量
          >如何实例化
          >如何将java.util.Date对象转换为java.sql.Date对象:先通过getTime()获取时间戳，再通过java.sql.Date的构造器把时间戳放进去
          >sql.Date ---> util.Date对象
     */
    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sun Jul 12 10:28:54 CST 2020
        System.out.println(date1);//Sun Jul 12 10:28:54 CST 2020

        System.out.println(date1.getTime());//1594520934991

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(159534991L);
        System.out.println(date2.toString());//Sat Jan 03 04:18:54 CST 1970

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1594520934991L);
        System.out.println(date3);//2020-07-12

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(1594520934991L);//多态性
//        java.sql.Date date5 = (java.sql.Date)date4;//向下转型
        //情况二：
        Date date6 = new Date();
//        java.sql.Date date7 = (java.sql.Date)date6;//报错：ClassCastException
        java.sql.Date date7 = new java.sql.Date(date6.getTime());


    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }
}
