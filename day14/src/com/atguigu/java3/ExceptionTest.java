package com.atguigu.java3;

/**
 * 异常 : 程序在运行时出现的非正常状况, 如果不处理会导致程序崩溃.
 *
 * 异常分类 :
 *  1) 按照程度来分 :
 *      1) Error 严重错误
 *      2) Exception 一般问题
 *  2) 按照处理方式来分 :
 *      1) 受检异常(checked) 编译时异常 : 在程序中必须接受检查和处理的异常
 *          Exception及其子类, RuntimeException及其子类除外.
 *
 *      2) 非受检异常(unchecked) 运行时异常 : 在程序中不是必须接受检查和处理的异常.
 *          Error及其子类 太严重了
 *          RuntimeException及其子类 太轻微太常见
 *
 *  无论是受检异常还是非受检异常都会导致程序崩溃.
 *
 *  异常必须处理 : 异常的处理方式适用于所有异常, 包括Error
 *      1) 捕获
     *      try {
     *          可能抛出异常的语句;
     *      } catch (可能的异常类型1 引用) {
     *          对异常对象1进行处理. 引用就指向了异常对象.
     *      }
 *      2)
 *      3)
 *
 */
public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println("main begin");

        try {
            int n1 = Integer.parseInt(args[0]); // 如果此语句出现异常, 整个try废掉.
            // 如果命令行参数未传入任何内容, 会出现ArrayIndexOutOfBoundsException
            // 如果命令行参数的内容是无法转换成整数的字符串, 会出现NumberFormatException
            //int n2 = Integer.parseInt(args[1]);
            System.out.println(n1);
            int[] arr = null;
            System.out.println(arr.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(); // 打印栈踪迹
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage()); // 获取异常对象的消息
        } catch (Exception e) { // 捕获任何可能的其他的异常
            System.out.println("其他异常 : " + e);
        }

        // 被保护的语句
        System.out.println("main end"); // 这是核心代码...
    }

}



