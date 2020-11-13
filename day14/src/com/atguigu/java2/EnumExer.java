package com.atguigu.java2;

// 给Week枚举加上属性, String feel. 添加构造器. 改造toString().
enum Week {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

//声明Week枚举类，其中包含星期一至星期日的定义；
// 在main方法中从命令行接收一个1-7的整数(使用Integer.parseInt方法转换)，
// 分别代表星期一至星期日，打印该值对应的枚举值，

public class EnumExer {

     /*
    在TestWeek类中声明方法void printWeek(Week week)，根据参数值打印相应的中文星期字符串。
    然后以第2步中的枚举值调用printWeek方法，输出中文星期。*/
    public void printWeek(Week week) {
        switch (week) {
            case MON:
                System.out.println("星期一");
                break;
            case TUE:
                System.out.println("星期二");
                break;
            case WED:
                System.out.println("星期三");
                break;
            case THU:
                System.out.println("星期四");
                break;
            case FRI:
                System.out.println("星期五");
                break;
            case SAT:
                System.out.println("星期六");
                break;
            case SUN:
                System.out.println("星期日");
                break;
        }
    }

    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        if (i > 7 || i < 1) {
            System.out.println("输入的参数不合法, 请输入[1~7]");
            return;
        }
        Week[] values = Week.values();
        Week value = values[i - 1];
        System.out.println(value);

        EnumExer exer = new EnumExer();
        exer.printWeek(value); // 非静态方法 它必须依赖对象!!!!!
    }

}
