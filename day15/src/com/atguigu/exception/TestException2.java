package com.atguigu.exception;

import org.junit.Test;

/*声明异常类IlleagalNumberException，用来表示无效数字异常
写一个TestException2类，在其中声明int divide(int m, int n)方法，该方法可抛出IlleagalNumberException异常。
方法的两个参数分别为被除数和除数，返回值为商
如果除数为0，则方法抛出IlleagalNumberException异常
改写main方法，调用divide方法计算商值打印输出，并捕获可能出现的异常。*/
public class TestException2 {

    Customer[] customers = new Customer[5];
    int realCount = 0;

    public void addCustomer(Object customer) throws Exception {
        if (customers.length == realCount) {
            throw new Exception("数组已满, 无法添加");
        }
        if (!(customer instanceof Customer)) {
            throw new Exception("参数中的对象不合法");
        }
        customers[realCount++] = (Customer)customer;
    }

    @Test
    public void test1() {
        try {
            addCustomer(new Customer(1, "张三", "男"));
            addCustomer(new Customer(2, "张三", "男"));
            addCustomer(new Customer(3, "张三", "男"));

            addCustomer("abc");

            addCustomer(new Customer(4, "张三", "男"));
            addCustomer(new Customer(5, "张三", "男"));

            addCustomer(new Customer(6, "张三", "男"));
        } catch (Exception e) {
            System.out.println("失败 : " + e.getMessage());
        }
    }

    public static int divide(int m, int n) throws IlleagalNumberException {
        if (n == 0) {
            throw new IlleagalNumberException("除数不可以为0");
        }
        return m / n;
    }

    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 2));
            System.out.println(divide(10, 0));
        } catch (IlleagalNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
