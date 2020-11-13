package com.atguigu.myexer1;

/**
 * //声明Week枚举类，其中包含星期一至星期日的定义；
 * // 在main方法中从命令行接收一个1-7的整数(使用Integer.parseInt方法转换)，
 * // 分别代表星期一至星期日，打印该值对应的枚举值，
 * <p>
 * <p>
 * 在TestWeek类中声明方法void printWeek(Week week)，根据参数值打印相应的中文星期字符串。
 * 然后以第2步中的枚举值调用printWeek方法，输出中文星期。
 *
 * 在Week枚举类中添加  属性feel，重载的构造器,改造toString方法
 *
 * @author chenhuiup
 * @create 2020-07-11 上午 10:40
 */

enum Week {
    MON("吃得饱饱的"), TUE("开心"), WED("出门遇见赵丽颖"), THU("中了一千万"), FRI("马云为我打工"), SAT, SUN;

    String feel = "没有感情";

    private Week(){}

    private Week(String feel){
        this.feel = feel;
    }

    {
        feel = "自我感觉良好";
    }

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    @Override
    public String toString() {
        return super.toString() + ",感觉：" + feel;
    }

}


public class Enum {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        Week[] weeks = Week.values();//获取枚举类的数组

        printWeek(weeks[num - 1]);
        System.out.println(weeks[num - 1]);
    }

    static void printWeek(Week week) {
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
                System.out.println("星期七");
                break;
        }
    }
}
