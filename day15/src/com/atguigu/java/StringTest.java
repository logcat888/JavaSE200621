package com.atguigu.java;

import org.junit.Test;

/**
 * String : 内容不可改变的Unicode字符序列, 对象一旦创建, 内容不能改变.
 * 对于字符串的内容的任何修改都会产生新对象.
 * 字符串内部就是使用一个char[] 来保存所有字符的.
 *
 * Customer cu = new Cutomer();
 * cu.setAge(20); // 内容可以改变的对象
 * cu.setAge(50);
 *
 *                  0 2       10       15       21        27   32 34
 * String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
 *
 * public int length(). string.length() => 35 获取字符串长度(字符数)
 * public char charAt(int index) 获取指定下标位置处的字符 string.charAt(12) => '欢', string.charAt(18) => '我';
 * public char[] toCharArray() 获取内部的char[]
 *       char result[] = new char[value.length]; // 创建一个新数组, 容量和内部的value一样大.
 *
 *       for (int i = 0; i < value.length; i++) {
 *           result[i] = value[i];
 *       }
 *
 *       System.arraycopy(value, 0, result, 0, value.length);
 *       // 第一个参数是源数组对象, 第二个参数是源数组的开始下标, 第三个参数是目标数组对象, 第四个参数是目标数组的开始下标
 *       // 第五个参数是要复制的元素个数.
 * public boolean equals(Object anObject)
 * public int compareTo(String anotherString)
 * public int indexOf(String s)
 * public int indexOf(String s ,int startpoint)
 * public int lastIndexOf(String s)
 * public int lastIndexOf(String s ,int startpoint)
 * public boolean startsWith(String prefix)
 * public boolean endsWith(String suffix)
 * public String substring(int start,int end)
 * public String substring(int startpoint)
 * public String replace(char oldChar,char newChar)
 * public String replaceAll(String old,String new)
 * public String trim()
 * public String concat(String str)
 * public String toUpperCase()
 * public String toLowerCase()
 * public String[] split(String regex)
 */
public class StringTest {

    // 练习 : 把字符串反转一下
    @Test
    public void exer13() {
        String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        char[] arr = string.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            // 首尾交换, i和length - 1 - i
            char tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        String string2 = new String(arr);
        System.out.println(string2);
    }

    @Test
    public void exer12() {
        String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        String string2 = "";
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            string2 = ch + string2;
        }
        System.out.println(string2);
    }

    @Test
    public void exer1() {
        String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        String string2 = "";
        for (int i = string.length() - 1; i >= 0 ; i--) {
            char ch = string.charAt(i);
            string2 += ch;
        }
        System.out.println(string2);
    }

    @Test
    public void test5() {
        String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        System.out.println(string.length());
        System.out.println(string.charAt(13));
        System.out.println(string.charAt(0));
        System.out.println(string.charAt(32));
        //System.out.println(string.charAt(500));
        System.out.println("**************************");
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            System.out.println(ch);
        }
        System.out.println("***************************");
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    @Test
    public void test4() {
        char[] arr = {'a', '1', 'q', '我', '3', '好', 'o'};
        String s1 = new String(arr); // 制作一个副本
        arr[1] = '大';
        System.out.println(s1);

        String s2 = new String(arr, 2, 3);// 第2个参数是开始下标, 第3个参数是长度
        System.out.println(s2);
        String s3 = new String(arr, 0, arr.length);
        System.out.println(s3);
    }

    @Test
    public void test3() {
        String s1 = "atguigu";
        String s2 = "java";
        String s4 = "java";
        String s3 = new String("java");
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        System.out.println(s2.equals(s3));

        String s5 = "atguigujava";
        // 字符串拼接时, 如果有变量参与, 结果一定是新字符串对象, 并且在堆.
        String s6 = (s1 + s2).intern(); // intern() 作用是把字符串塞入常量区中, 如果常量区中已经有此对象了,则返回常量对象的地址.
        System.out.println(s5 == s6); // true
        System.out.println(s5.equals(s6));

    }

    @Test
    public void test2() {
        String s1 = new String();
        String s2 = "";
        String s3 = null;

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s4 = new String("qqq");


    }

    @Test
    public void test1() {
        String s1 = "abc";
        s1 += "yyy";
        System.out.println(s1);
    }
}
