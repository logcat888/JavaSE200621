package com.atguigu.java2;

import org.junit.Test;

/**
 * StringBuilder : 是内容可以改变的Unicode字符序列.
 * <p>
 * 1. StringBuffer()初始容量为16的字符串缓冲区
 * 2．StringBuffer(int size)构造指定容量的字符串缓冲区
 * 3．StringBuffer(String str)将内容初始化为指定字符串内容
 * <p>
 * StringBuilder append(...) 追加任意数据到当前串末尾.
 * StringBuilder insert(int index, ...) 在指定位置处插入任意内容
 * StringBuilder delete(int beginIndex, int endIndex) 删除一个区间
 * StringBuilder setCharAt(int index, char ch) 替换指定下标处的字符为ch
 * <p>
 * private int newCapacity(int minCapacity) {
 * // overflow-conscious code
 * int newCapacity = (value.length << 1) + 2;
 * if (newCapacity - minCapacity < 0) {
 * newCapacity = minCapacity;
 * }
 * return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
 * ? hugeCapacity(minCapacity)
 * : newCapacity;
 * }
 * <p>
 * StringBuffer : 古老的类 速度慢 线程安全, 不使用
 * StringBuilder  : 新的类 速度快 线程不安全.
 */
public class StringBuilderTest {

    @Test
    public void test5() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str); // "abc" + null
        String str2 = "abc";
        str2 += null;

        System.out.println(str2);
        System.out.println(sb);

        //String s = new String(str);
        //System.out.println(s);
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer);

    }

    @Test
    public void test4() {
        String text = "";
        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }

    @Test
    public void test3() {
        StringBuilder stringBuilder = new StringBuilder(); // 内部容量为16
        stringBuilder.append(123);
        stringBuilder.append("abc");
        stringBuilder.append(3.14);
        stringBuilder.append(true);
        stringBuilder.append('我');
        stringBuilder.append('你');

        stringBuilder.append('A');
    }

    // 声明3个字符串, 赋值一些内容, 把第一个直接变成StringBuffer对象, 把第2个串追加在末尾, 把第3个串插入到最前面.
    // 打印输出.
    @Test
    public void exer1() {
        String s1 = "abclkjafd";
        String s2 = "234239487234";
        String s3 = "我是一些汉字";
        StringBuilder insert = new StringBuilder(s1).append(s2).insert(0, s3);
        System.out.println(insert);
    }

    @Test
    public void test2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(123).append("abc").append(3.14).append(true).append('A').insert(3, "我和你").delete(6, 10).setCharAt(3, '好');
        System.out.println(stringBuilder);
    }

    @Test
    public void test1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(123);
        stringBuilder.append("abc");
        stringBuilder.append(3.14);
        stringBuilder.append(true);
        stringBuilder.append('A'); //123abc3.14trueA

        stringBuilder.insert(3, "我和你"); //123我和你abc3.14trueA

        System.out.println(stringBuilder);

        stringBuilder.delete(6, 10);

        System.out.println(stringBuilder); //123我和你.14trueA

        stringBuilder.setCharAt(3, '好');

        System.out.println(stringBuilder);

        //StringBuilder stringBuilder2 = new StringBuilder(1024);
        //System.out.println(stringBuilder2.length());

    }

}
