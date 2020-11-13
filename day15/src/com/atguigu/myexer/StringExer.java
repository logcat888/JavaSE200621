package com.atguigu.myexer;

import org.junit.Test;

/**
 * // 练习 : 把字符串反转一下
 * @Test
 * public void test6() {
 *     String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
 * }
 * @author chenhuiup
 * @create 2020-07-13 下午 4:34
 */
public class StringExer {

    @Test
    public void test6() {
     String string = "  abcAQQY 我喜欢你,你喜欢我吗?我不喜欢你 zzz123  ";
     for (int i = string.length() -1;i >= 0 ;i--){
         System.out.print(string.charAt(i));
     }

        System.out.println();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length/2 ; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length- 1 - i];
            chars[chars.length- 1 - i] = temp;
        }
        string = new String(chars);
        System.out.println(string);
    }
}
