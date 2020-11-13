package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8 中日期时间API的测试
 *
 * @author chenhuiup
 * @create 2020-07-12 下午 2:56
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2020-1900,7 - 1,8);
        System.out.println(date1);//Wed Jul 08 00:00:00 CST 2020


    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明：
        1.LocalDateTime相较于LocalDate、LoaclTime,使用频率要高
        2.类似于Calendar
     */
    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);//2020-07-12
        System.out.println(localTime);//15:24:35.938
        System.out.println(localDateTime);//2020-07-12T15:24:35.938

        //of():设置指定的年、月、日、时、分、秒。没有偏移量。
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 7, 12, 3, 20, 45);
        System.out.println(localDateTime1);//2020-07-12T03:20:45

        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());//12
        System.out.println(localDateTime.getDayOfWeek());//SUNDAY
        System.out.println(localDateTime.getMonth());//JULY
        System.out.println(localDateTime.getMonthValue());//7
        System.out.println(localDateTime.getMinute());//24

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//2020-07-12
        System.out.println(localDate1);//2020-07-22

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);//2020-07-12T15:32:00.215
        System.out.println(localDateTime2);//2020-07-12T04:32:00.215

        //体现不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /*
    Instant的使用
    类似于 java.util.Date类
     */

    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();//实例化
        System.out.println(instant);//2020-07-12T07:41:52.680Z


        //atOffset():添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-07-12T15:44:44.750+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数 --->Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 ---> Date(Long millis)
        Instant instant1 = Instant.ofEpochMilli(1566165165161L);
        System.out.println(instant1);

    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3(){
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期 ---> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);//2020-07-12T16:03:38.954
        System.out.println(str1);//2020-07-12T16:03:38.954

        //解析：字符串 ---> 日期
        TemporalAccessor parse = formatter.parse("2020-07-12T16:03:38.954");
        System.out.println(parse);//{},ISO resolved to 2020-07-12T16:03:38.954


//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2020年7月12日 下午04时09分15秒

        //      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2020年7月12日 星期日

//      重点：  方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2020-07-12 04:15:32

        //解析
        TemporalAccessor parse1 = formatter3.parse("2020-07-12 04:15:32");
        System.out.println(parse1);
        //{NanoOfSecond=0, MicroOfSecond=0, HourOfAmPm=4, MinuteOfHour=15, MilliOfSecond=0, SecondOfMinute=32},ISO resolved to 2020-07-

    }

}
