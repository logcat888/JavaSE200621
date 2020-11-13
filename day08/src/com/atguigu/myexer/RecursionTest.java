package com.atguigu.myexer;

import java.io.File;

/**
 * 递归方法的使用
 *
 * 1. 递归方法：一个方法体内调用它自身。
 * 2. 方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制。
 * 3. 递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环。
 *    死循环是我们开发中要避免出现的。进而递归方法也必须满足执行的有限性。否则的话，会报StackOverflowError
 * @author shkstart
 * @create 2020-07-03 10:14
 */
public class RecursionTest {
    public static void main(String[] args) {
        RecursionTest test = new RecursionTest();
        int sum = test.sum1(100);
        System.out.println("总和为：" + sum);

        int result = test.f(10);
        System.out.println("结果为：" + result);
    }

    //计算1-num所有自然数的和
    public int sum(int num){
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    //递归实现：1-100所有自然数的和
    public int sum1(int num){
        if(num == 1){
            return 1;
        }else{
            return sum1(num - 1) + num;
        }
    }

    //递归实现1：计算n!
    public int multiply(int num){
        if(num == 1){
            return 1;
        }else{
            return multiply(num - 1) * num;
        }
    }

    //递归实现2：已知有一个数列：f(0) = 1,f(1) = 4,f(n+2)=2*f(n+1) + f(n),
    // 其中n是大于0的整数，求f(10)的值。
    public int f(int num){
        if(num == 0){
            return 1;
        }else if(num == 1){
            return 4;
        }else{
            //错误的
//            return f(num + 2) - 2 * f(num + 1);
            //正确的
            return 2 * f(num - 1) + f(num - 2);
        }
    }

    //递归实现3：已知一个数列：f(20) = 1,f(21) = 4,f(n+2) = 2*f(n+1)+f(n),
    //其中n是大于0的整数，求f(10)的值。
    public int func(int num){
        if(num == 20){
            return 1;
        }else if(num == 21){
            return 4;
        }else{
            return func(num + 2) - 2 * func(num + 1);
        }
    }

    //递归实现4：斐波那契数列： 1 1 2 3 5 8 13 21 34 55
    //f(1) = 1;f(2) = 1;f(n + 2) = f(n + 1) + f(n)

    //递归实现5：汉诺塔

    //递归实现6：IO流时File类的使用：遍历指定文件目录下的所有文件名
    public void printFileName(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i = 0;i < files.length;i++){
                printFileName(files[i]);
            }

        }else{
            System.out.println(file.getAbsolutePath());
        }
    }

    //递归实现7：快排

}
