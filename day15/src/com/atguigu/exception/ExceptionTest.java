package com.atguigu.exception;

import com.sun.org.apache.xpath.internal.operations.Div;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 异常 : 程序在运行时出现的非正常状况. 异常会导致程序崩溃
 * 异常的分类 :
 * 1) 按照程度来分
 *      1) Error 严重错误.
 *      2) Exception 一般问题.
 * 2) 按照处理方式来分
 *      1) 受检异常(checked) 在程序中必须接受检查和处理的异常. 如果不处理编译错误,也称为编译时异常
 *          Exception及其子类(RuntimeException及其子类除外)
 *      2) 非受检异常(unchecked) 在程序中不是必须接受检查和处理的异常, 如果不处理不生编译错误, 但是运行时仍会出问题, 也称为运行时异常
 *          Error及其子类.
 *          RuntimeException及其子类.
 *
 * 异常必须处理 : 适用于所有异常, 包括Error
 *      1) 捕获
 *          try {
 *             可能抛出异常的语句;
 *          } catch (可能的异常类型1 引用) {
 *              对异常处理.
 *          } catch (可能的异常类型2 引用) {
 *              对异常处理.
 *          } .....
 *          catch (Exception e) {
 *              确保万无一失
 *          } finally { // final 修饰符, 修饰类, 方法, 变量
 *              释放不在GC区中资源, 而是由OS管理的资源. 比如文件,网络等硬件资源.
 *          }
 *
 *          try catch
 *          try catch finally
 *          try finally
 *
 *      2) 抛出 : 使用throws体现异常的抛出.
 *
 *          在方法声明中的throws 异常类型列表, 作用是警告调用者, 此方法有风险.
 *          在方法体中使用throw语句, 在方法中真的抛出异常对象.
 *
 *          可以只有throws而没有throw
 *          只要有throw必须要有throws
 *
 *          throws 是警告
 *          throw 是玩真的.
 *
 *      方法覆盖条件中对于异常的描述 :
 *      要求如下 :
 *          1) 方法签名一致, 子类方法的返回值的对象类型可以小于等于父类方法返回的对象类型.
 *          2) 子类方法的访问控制修饰符的范围要大于等于父类的.
 *          3) 被覆盖方法不可以被private, static, final.
 *          4) 子类方法抛出的受检异常范围要小于等于父类方法抛出的受检异常.
 *
 *      3) 先捕获, 再抛出.
 *          先
 *          try {
 *              可能抛出异常的语句;
 *          } catch(任意异常类型 引用) {
 *              throw new 自定义异常(引用);
 *          }
 *
 *  处理方式的选择 :
 *      1) 入口方法尽量捕获.
 *      2) 功能方法尽量抛出.
 *
 */

// 自定义异常 : 1) 继承Exception 表明它是一个异常, 2) 提供2个构造器一个String,一个是Throwable 创建自定义异常对象方便
class DividedByZeroException extends Exception { // 这是受检异常, 必须要处理

    public DividedByZeroException(String message) {
        super(message); // 间接调用到父类构造, 完成私有的detailMessage的初始化.
    }
    public DividedByZeroException(Throwable cause) { // 对象关联专用
        super(cause);
    }
}

public class ExceptionTest {

    public static int divide(int x, int y) throws DividedByZeroException {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new DividedByZeroException(e); // 包装 : 自定义异常对象内部包含一个其他异常对象.
        }
    }

    public static void main(String[] args) {
        try {
            try {
                System.out.println(divide(10, 2));
                System.out.println(divide(10, 0));
            } catch (DividedByZeroException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(divide(20, 5));
        } catch (DividedByZeroException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}

class ExceptionTest3 {
    // throws的作用是警告调用者, 调用此方法有风险!!!
    public static int divide(int x, int y) throws DividedByZeroException { // throws和throw最好要一致, 显得诚实
        if (y == 0) {
            // 真的抛出一个异常对象, 当前方法就会提前弹栈返回结束, 并给调用者产生破坏.
            throw new DividedByZeroException("除数不可以为0错误!!!!");
        }
        return x / y;
    }

    //public static void main(String[] args) throws DividedByZeroException { main方法虽然可以抛出异常, 但是不要抛.
    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 2));
            System.out.println(divide(10, 0));
        } catch (DividedByZeroException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("end");
    }
}

class ExceptionTest2 {

    public static int divide(int x, int y) {
        if (y == 0) {
            RuntimeException re = new RuntimeException("除数不可以为0"); // throw和return效果一样, 都是让方法返回的
            throw re;
            // return 是和平返回, throw 带有破坏性的返回.
        }
        return x / y;
    }

    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 2));
            System.out.println(divide(10, 0));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("end...");
    }
}


class ExceptionTest1 {

    public static void main(String[] args) {
        System.out.println("main begin");

        boolean b = true;
        if (b) {
            //return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            System.out.println(n);
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("其他可能的异常 : " + e);
        } finally {
            // 无论前面try catch中发生什么, 我都要执行....
            System.out.println("finally");
        }

        System.out.println("main end");
    }
}
