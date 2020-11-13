package com.atguigu.java;

import org.junit.Test;

/**
 * @author chenhuiup
 * @create 2020-07-14 上午 9:35
 */
public class StringTest {
    /*获取一个字符串在另一个字符串中出现的次数。
比如：获取"ab"在 "abkkcadkabkebfkabkskab"
中出现的次数*/

    @Test
    public void test1(){
        String s1 = "abkkcadkabkebfkabkskab";
        String s2 = "ab";
        int count = 0;
        int n = 0;
        while (true) {
            n = s1.indexOf(s2, n);
            if (n == -1) {
                break;
            }
            count++;
            n += 2;
        }
        System.out.println(count);//4
        System.out.println("************");

        count = 0;
        n = s1.length();
        while (true) {
            n = s1.lastIndexOf(s2, n);
            if (n == -1) {
                break;
            }
            count++;
            n -= 2;
        }
        System.out.println(count);//4

        System.out.println("************");
        count = 0;
        n = s1.length();
        for (;;) {
            n = s1.lastIndexOf(s2, n);
            if (n == -1) {
                break;
            }
            count++;
            n -= 2;
        }
        System.out.println(count);
        System.out.println("************");//4
    }

    /*
    //将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
@Test
public void exer3() {
    String string = "abcdefg";
    int begin = 2;
    int end = 6;

    // 切成3段, 只反转中间部分.
}

     */
    @Test
    public void test2(){
        String string = "abcdefg";
        int begin = 2;
        int end = 6;
        char[] chars= string.substring(begin,end).toCharArray();
        String string1 = string.substring(0,begin);
        String string2 = string.substring(end,string.length());
        for (int i = 0; i < chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        System.out.println(chars);//fedc
        System.out.println(chars.toString());//[C@22927a81
        string = string1 + new String(chars) + string2;
        System.out.println(string);//abfedcg
//        string = string1 + chars + string2;
//        System.out.println(string);
//        string = string1 + chars.toString() + string2;
//        System.out.println(string.toString());

        System.out.println("**************");
        char[] chars1 = string.toCharArray();
        for (int i = begin; i < (end + begin) / 2; i++) {
            char temp = chars1[i];
            chars1[i] = chars1[end - 1 -i];
            chars1[end - 1 -i] = temp;
        }
        System.out.println(new String(chars1));
    }

    @Test
    public void test3(){
        String string1 = new String("【我是第1个】");
        String string2 = new String("【我是第2个】");
        String string3 = new String("【我是第3个】");
        StringBuilder stringBuilder = new StringBuilder(string1);
        stringBuilder.append(string2).insert(0,string3);
        System.out.println(stringBuilder);
    }
}
