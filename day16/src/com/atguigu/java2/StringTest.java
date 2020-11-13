package com.atguigu.java2;

import org.junit.Test;

import javax.swing.*;

/**
 * String : 是内容不可改变的Unicode字符序列(CharSequence).
 * 可以简单地理解为是一个char[]
 *                  0 2       10       15       21        27   32 34
 * String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
 *
 * ###public int length(). string.length() => 35 获取字符串长度(字符数)
 * ###public char charAt(int index) 获取指定下标位置处的字符 string.charAt(12) => '欢', string.charAt(18) => '我';
 * ##public char[] toCharArray() 获取内部的char[]
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
 * public boolean equalsIgnoreCase(String anotherString) 比较字符串内容, 忽略大小写
 * public int compareTo(String anotherString)
 *
 *                  0 2       10       15       21        27   32 34
 * String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
 *
 * #####
 * public int indexOf(String s), 获取参数中的子串在当前字符串中首次出现的下标. 如果不存在返回-1
 *              string.indexOf("喜欢") => 11
 *              string.indexOf("讨厌")
 * public int indexOf(String s ,int startpoint)获取参数中的子串在当前字符串中首次出现的下标. 从startPoint位置开始搜索
 *              string.indexOf("喜欢", 12) => 16, string.indexOf("喜欢", 17) => 23
 *
 * public int lastIndexOf(String s)
 *              string.lastIndexOf("喜欢") => 23
 * public int lastIndexOf(String s ,int startpoint)
 *              string.lastIndexOf("喜欢", 22) => 16, string.lastIndexOf("喜欢", 15) => 11
 *
 * public boolean startsWith(String prefix) 判断当前串是否以参数中的子串为开始
 * public boolean endsWith(String suffix)判断当前串是否以参数中的子串为结束
 *
 *                  0 2       10       15       21        27   32 34
 * String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
 *
 * #####
 * public String substring(int start,int end) 从当前字符串中取子串, 从start开始(包含),到end结束(不包含)
 *              string.substring(10, 14) => "我喜欢你";
 * public String substring(int startpoint) 从当前字符串中取子串, 从start开始(包含),到最后
 *
 * public String replace(char oldChar,char newChar) 替换字符串中的所有oldChar为newChar
 *              string.replace(' ', '#') =>
 *
 * // 参数中的字符串符合 正则表达式.
 * public String replaceAll(String old,String new) 替换字符串中的所有old子串为new子串.
 *
 * public String trim() 修剪字符串首尾的空白字符. 空白字符就是码值小于等于32的字符
 *
 * public String concat(String str) 字符串连接
 * public String toUpperCase() 变成大写
 * public String toLowerCase() 变成小写
 * String s = "abc,yy,123,qq,我和你,zzz";
 * String[] arr = s.split(",");
 * public String[] split(String regex) 以参数 中的子串为切割器,把字符串切割成多个部分.
 */
public class StringTest {

    @Test
    public void test8() {
        String s1 = "abc";
        String s2 = "ABC";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        System.out.println(s1.toLowerCase().equals(s2.toLowerCase()));
    }

    @Test
    public void test7() {
        String s = "abc,yy,123,qq,我和你,zzz";
        String[] arr = s.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test6() {
        class A {};
        String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        String s = string.toUpperCase();
        System.out.println(s);
        String s1 = string.toLowerCase();
        System.out.println(s1);
    }

    @Test
    public void test5() {
        String string = "  \r\n\t \b abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123 \r\n\t\t\t   \b ";
        System.out.println(string);
        String trim = string.trim();
        System.out.println("trim = " + trim);
    }

    @Test
    public void test4() {
        String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        String replace = string.replace(' ', '#');
        System.out.println(replace);

        String replace1 = string.replace("喜欢", "爱慕");
        System.out.println(replace1);

        String s2 = string.replaceAll("喜欢", "特别讨厌,真的讨厌");
        System.out.println(s2);

        // 消除字符串中的所有空格
        String s = string.replaceAll(" ", "");
        System.out.println(s);

        String s3 = string.replaceAll("", "@");
        System.out.println(s3);
    }

    //将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
    @Test
    public void exer3() {
        String string = "abcdefg";
        int begin = 2;
        int end = 6;

        // 切成3段, 只反转中间部分.
        String s1 = string.substring(0, begin);
        String s2 = string.substring(begin, end);
        String s3 = string.substring(end);

        char[] chars = s2.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i]; //
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        String result = s1 + new String(chars) + s3;
        System.out.println("result = " + result);
    }

    @Test
    public void test3() {
        String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        String substring = string.substring(10, 14);
        System.out.println("substring = " + substring);
        String substring2 = string.substring(10, string.length());
        System.out.println("substring2 = " + substring2);
    }

    @Test
    public void test2() {
        String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        boolean b = string.startsWith("  abc");
        System.out.println(b);
        boolean b2 = string.endsWith("zzz123");
        System.out.println(b2);
    }

    /*获取一个字符串在另一个字符串中出现的次数。
    比如：获取"ab"在 "abkkcadkabkebfkabkskab"
    中出现的次数*/
    @Test
    public void exer2() {
        String s1 = "ababa";
        String s2 = "aba";
        int count = 0;
        int index = 0;
        while (true) {
            index = s1.indexOf(s2, index);
            //if (从长串中检索短串的下标时, 返回-1) {
            if (index == -1) {
                //结束这个过程
                break;
            }
            count++;
            index++;
        }
        System.out.println(count);
    }

    @Test
    public void test1() {
        String string = new String();
        String s1 = new String("abc");
        String s2 = new String("abC");
        System.out.println(s1 == s2);

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1.compareTo(s2));
        String string2 = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
        int indexOf = string2.indexOf("讨厌");
        System.out.println(indexOf);
    }
}
