package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author chenhuiup
 * @create 2020-07-12 上午 12:01
 */
public class StringTest1 {
    /*
    String 与 byte[] 之间的转换
    编码：String ---->byte[]:调用String的getBytes()
    解码：byte[] --->String：调用String的构造器

    编码：字符串---> 字节（看得懂--->看不懂的二进制数据）
    解码：编码的逆过程，字节----> 字符串(看不懂的二进制数据--->看得懂)

    说明：解码时，要求解码使用的解码集必须与编码是使用的字符集一致，否则会出现乱码。
     */

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码，汉字占三个字节
        System.out.println(Arrays.toString(bytes));//[97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67]

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码，汉字占两个字节,gbk大小写都行
        System.out.println(Arrays.toString(gbks));//[97, 98, 99, 49, 50, 51, -42, -48, -71, -6]

        System.out.println("**********解码***********");
        String str2 = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(str2);//abc123中国


        String str3 = new String(gbks);
        System.out.println(str3);//abc123�й�  出现乱码。原因：编码集和解码集不一致。

        String str4 = new String(gbks, "gbk");
        System.out.println(str4);//没有出现乱码，原因：编码集和解码集一致。


    }
    /*
    String 与 char[] 之间的转换

    String ---> char[]:调用String的toCharArray()
    char[] ---> String :调用String的构造器
     */


    @Test
    public void test2(){
        String str1 = "abc123";//题目： a21cb3

        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);

        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String s = new String(arr);
        System.out.println(s);
    }

    /*
    复习：
    String 与基本数据类型、包装类之间的转换

    String---> 基本数据类型、包装类：调用包装类的静态方法：parseXxx（str）
    基本数据类型、包装类--->String：调用String重载的valueOf（xxx）
     */
    @Test
    public void test1(){
        String str1 = "123";
        // int num = (int)num//错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);
        String str3 = num + "";//有变量参与，str3执行堆空间

        System.out.println(str1 == str3);//false
    }
}
