package com.atguigu.java;

/**
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,
 * 以及该对象生日。当键盘输入本月月份值时，如果本月是某个Employee对象的生日，
 * 还要输出增加工资信息。
 * @author chenhuiup
 * @create 2020-07-10 下午 2:14
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Employee[]  employees = new Employee[2];
        employees[0] = new SalariedEmployee("李四",1010,new MyDate(2000,3,3),20000);
        employees[1] = new HourlyEmployee("李四",1010,new MyDate(2000,3,3),200,240);

        for (int i = 0; i < employees.length; i++) {
            
        }
        
    }






}
