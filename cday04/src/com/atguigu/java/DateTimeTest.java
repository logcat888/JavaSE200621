package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * jdk 8 之前的日期时间的API测试
 *
 * 1.System类中的currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @author chenhuiup
 * @create 2020-07-12 下午 1:46
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用:SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作
    1.1 格式化：日期 ---> 字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2.2 SimpleDateFormat的实例化
     */

    @Test
    public void test1() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);//Sun Jul 12 13:56:15 CST 2020

        String format = sdf.format(date);
        System.out.println(format);//20-7-12 下午1:56

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "20-7-12 下午1:56";
        Date date1 = sdf.parse(str);
        System.out.println(date1);//Sun Jul 12 13:56:00 CST 2020

        //***************按照指定的方式格式化和解析：调用带参的构造器******************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2020-07-12 02:07:59

        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现），否则抛异常
        Date date2 = sdf1.parse("2021-07-12 02:07:59");
        System.out.println(date2); //Mon Jul 12 02:07:59 CST 2021
    }
    /*
    练习一：字符串“2020-09-08”转换为java.sql.Date

    练习二：“三天打鱼两天晒网” 1990-01-01 xxxx-xx-xx打渔？ 晒网？

    举例：2020-09-08

     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(birth);

        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }

    /*
    Calendar日历类（抽象类）的使用

    注意点：
        获取月份时：一月是0，二月是1，以此类推，12月是11.
        获取星期时：周日是1，周一是2，....，周六是7
     */

    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二： 调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());//class java.util.GregorianCalendar

        //2.常用方法
        //get(),获取Calendar常用的属性信息
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date);


        //setTime():Date --->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

}
