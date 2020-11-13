package com.atguigu.homework;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chenhuiup
 * @create 2020-07-15 上午 8:43
 */
public class homework {
    /*
    刘优老师 08:41:52 (多人发送)
1.	描述equals方法和hashCode方法的作用

    equals():比较对象的实体内容是否相等
    hashCode():又称特征码、散列码，根据equals方法中使用的实体内容，经过哈希算法（散列函数），得到的数值。相同的实体内容对应着相同的散列码，
                目的就是为了在Set接口（HashSet，LinkedHashSet，TreeSet）和Map接口中，根据散列码迅速算出所放元素在底层数组中所处的位置，
                到达一种无序，快速存放元素的目的。

2.	String和StringBuilder的区别是什么? StringBuilder和StringBuffer的区别又是什么?
    String：不可变的Unicode字符序列，底层使用char[] value存储
    StringBuffer：可变的Unicode字符序列，线程安全的，效率低，底层使用char[] value存储
    StringBuilder:jdk 5.0 新增的，可变的Unicode字符序列，线程不安全的，效率高，底层使用char[] value存储，
    建议开发中使用StringBuilder，由于StringBuffer和StringBuilder默认长度是16，
    所以创建对象时设置初始化数组长度（尽量大些），避免扩容问题。StringBuilder扩容是原有长度*2 + 2.

3.	问答:
	String类中的方法 :
		length() 作用是什么?  //字符串长度
		获取指定的下标处的字符的方法是哪个? //charAt()
		indexOf(String child, int start)的作用是什么, 其中参数是什么含义?//child是所要查找的子串，返回值是子串出现的位置
		获取字符串的子串的方法是哪些? 分别描述参数的含义. //substring(int start,end start),获取索引[start,end)的子串
		startsWith(String str)和endsWith(String str)的作用是什么?  //判断字符串是否是以str开始，或str结束的，返回值是布尔型
		比较字符串对象并忽略大小写的方法是? //equalsIgnoreCase()
		trim()方法的作用是什么? // 去掉字符串首尾的空白字符(码值小于等于32的字符)
		把字符串中的所有大写字母变小写, 小写字母变大写的方法是什么? //toUpperCase //toLowerCase
		replace(char ch1, char ch2)作用是什么? 和replaceAll有什么区别?
		把字符串以某个子串为切割器切割的方法是什么?  //split()
		获取字符串对应的字符数组方法是什么?  //toCharArray()
	StringBuilder类中的方法:
		在字符串后面追加内容的方法是? 可以是什么类型的参数?  //append(任意内容),返回值是StringBuilder，可以链式操作
		在字符串的指定位置处插入新内容的方法是? 可以是什么类型的参数?  // insert(int index，...),返回值是StringBuilder，可以链式操作
4.	分别使用Calendar和LocalDateTime把时间显示成 2017年05月19日 08时50分?

        Calendar c1 = Calendar.getInstance()

     */

    @Test
    public void test() throws ParseException {
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1);
        System.out.println(c1.getTime());
        c1.set(Calendar.YEAR,2017);
        c1.set(Calendar.MONTH,4);
        c1.set(Calendar.DAY_OF_MONTH,19);
        c1.set(Calendar.HOUR,8);
        c1.set(Calendar.MINUTE,50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        System.out.println(simpleDateFormat.format(c1.getTime()));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime of = now.of(2017, 5, 19, 8, 50);
        LocalDateTime localDateTime = of.withYear(2017).withMonth(5).withDayOfMonth(19).withHour(8).withMinute(50);
        System.out.println(of);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分");
        String format = dtf.format(of);
        System.out.println(format);

    }
}
