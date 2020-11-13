package com.atguigu.myexer1;

/**
 * 编写TestException类，在main方法中接收两个命令行参数，将它们转换为整数，并用第一个数除以第二个数，打印结果。
 *         在命令行运行程序，给出两个参数，测试以下情况，观察运行结果：
 *         其中某个参数不是数字
 *         什么都不传入
 *         第二个参数为0
 * @author chenhuiup
 * @create 2020-07-11 下午 3:56
 */
public class TestException {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);

            int num = maintest(i, j);
        }catch (NumberFormatException e){
            System.out.println("数据类型不一致");
            e.printStackTrace();
        }catch (ArithmeticException e){
            System.out.println("除0了");
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
            System.out.println(e.getMessage());
        }catch (MyException e){
            System.out.println("有负数");
            e.getMessage();
        }
        finally {
            System.out.println("我一定会被执行");
        }
    }

    static int maintest(int i,int j) throws RuntimeException{
        if (i < 0 || j < 0){
            throw new MyException("你输入负数了，请重新输入");
        }else{
            return i / j;
        }

    }
}

class MyException extends RuntimeException{

    static final long serialVersionUID = -70348971788996939L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

