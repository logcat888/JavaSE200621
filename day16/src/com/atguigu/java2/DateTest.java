package com.atguigu.java2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

// 当无法创建对象时, 有2种做法
// 1) 找当前类的静态方法, 看有没有能返回对象的方法
// 2) 找它的工厂类, 通过工厂获取对象.

/**
 * Date : 年有1900, 月也是少1, toString()不友好
 * Calendar : 内部用数组, 增加复杂度, 内容可以改变, 不好, 月份少1.
 *
 * java8 一步到位.
 * LocalDate 日期
 * LocalTime 时间
 * LocalDateTime 日期时间
 *
 */

public class DateTest {

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now(); //new LocalTime();
        System.out.println(localTime);

        LocalTime localTime1 = localTime.withHour(20);
        System.out.println(localTime1);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        // 如何一步到位创建日期
        // 2008, 8, 8
        //new LocalDate(2008,8,8);
        LocalDateTime of = LocalDateTime.of(2008, 8, 8, 20, 30, 40);
        System.out.println(of);

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String format = sdf.format(of);
        //System.out.println(format);

        //new DateTimeFormatter();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(of);
        System.out.println(format);
    }

    public static void main6(String[] args) {
        LocalDate date = LocalDate.now(); //new LocalDate();
        System.out.println(date);
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);

        //date.setYear(2008);
        // 伴随新的年会产生新对象
        LocalDate date2 = date.withYear(2008).withMonth(8).withDayOfMonth(8);
        System.out.println(date2);

        LocalDate date3 = date2.plusYears(5);

        System.out.println(date3);
        // 创建一个LocalDate对象, 把它变成你的生日. 然后再获取你的百日.
    }


    public static void main5(String[] args) {
        // 创建一个Calendar对象, 把它变成你的生日. 然后再获取你的百日.
        Calendar instance = Calendar.getInstance();
        // 1978, 6, 9
        instance.set(Calendar.YEAR, 1978);
        instance.set(Calendar.MONTH, 5);
        instance.set(Calendar.DAY_OF_MONTH, 9);

        System.out.println(instance.getTime());

        instance.add(Calendar.DAY_OF_MONTH, 100);

        System.out.println(instance.getTime());
    }

    public static void main4(String[] args) {
        // Calendar日历.
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        // 获取年
        int year = calendar.get(Calendar.YEAR); // 没有单独的获取方法
        int month = calendar.get(Calendar.MONTH); // 内部保存的月比实际小1.
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("year = " + year);;
        System.out.println("month = " + month);
        System.out.println("day = " + day);

        // 设置. 2008, 8, 8
        //calendar.setYear(2008);
        calendar.set(Calendar.YEAR, 2008); // 没有单独的设置方法
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DAY_OF_MONTH, 8);

        Date time = calendar.getTime();
        System.out.println(time);

        // 加减
        calendar.add(Calendar.MONTH, 5); // 5个月后

        System.out.println(calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, -500);
        System.out.println(calendar.getTime());

    }

    public static void main3(String[] args) {
        // 北京奥运会 2008, 8, 8
        Date date = new Date(2008, 8, 8); // 直接创建对象会有问题
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }

    public static void main2(String[] args) {
        long millis = System.currentTimeMillis();
        System.out.println(millis);

        Date date = new Date();
        System.out.println(date);

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S E");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date); // 把日期对象格式化成和模式一致的串
        System.out.println(format);

        String str = "2018-05-02 11:20:30";
        try {
            Date parse = sdf.parse(str); // 把字符串解析成日期对象
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String format1 = sdf.format(millis); // 格式化毫秒
        System.out.println(format1);

    }
}
