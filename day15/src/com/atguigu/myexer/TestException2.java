package com.atguigu.myexer;

/**
 * 声明异常类IlleagalNumberException，用来表示无效数字异常
 *         写一个TestException2类，在其中声明int divide(int m, int n)方法，该方法可抛出IlleagalNumberException异常。
 *         方法的两个参数分别为被除数和除数，返回值为商
 *         如果除数为0，则方法抛出IlleagalNumberException异常
 *         改写main方法，调用divide方法计算商值打印输出，并捕获可能出现的异常。
 * @author chenhuiup
 * @create 2020-07-13 下午 12:00
 */
public class TestException2 {

//    public static int divide(int m, int n) throws TestException{
//        if (n == 0){
//            throw new TestException("IlleagalNumberException");
//        }
//        return m / n;
//    }

    public static int divide(int m, int n) throws TestException { // 异常包装： 先捕获，再抛出
        try{
            return m / n;
        }catch (ArithmeticException e){
            throw new TestException(e);//异常对象关联   包装：自定义异常对象内部包含一个其他异常对象。
        }
    }

    public static void main(String[] args) {
        try {
//            int m = Integer.parseInt(args[0]);
//            int n = Integer.parseInt(args[0]);
            int num = divide(10, 0);
        }catch (TestException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("我一定会被执行");
        }

        System.out.println("我一会被执行");
    }

}

class TestException extends Exception{

    public TestException(String message){
        super(message);
    }

    public TestException(Throwable throwable){
        super(throwable);
    }
}
