package com.atguigu.exception;

/*声明异常类IlleagalNumberException，用来表示无效数字异常
写一个TestException2类，在其中声明int divide(int m, int n)方法，该方法可抛出IlleagalNumberException异常。
方法的两个参数分别为被除数和除数，返回值为商
如果除数为0，则方法抛出IlleagalNumberException异常
改写main方法，调用divide方法计算商值打印输出，并捕获可能出现的异常。*/

public class IlleagalNumberException extends Exception {

    public IlleagalNumberException(String message) {
        super(message);
    }

    public IlleagalNumberException(Throwable cause) {
        super(cause);
    }
}
