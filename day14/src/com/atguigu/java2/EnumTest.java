package com.atguigu.java2;

/**
 * 枚举 : 对象可数的类型, 不能再创建新对象.
 */
enum Season { // public static final 修饰的量. 称为全局常量

    // 给Week枚举加上属性, String feel. 添加构造器. 改造toString().

    SPRING("绿色"), SUMMER("红色"), AUTUMN, WINTER;

    {
        color = "白色"; // 非静态语句块和显式赋值的顺序是按照写的顺序来执行的 并且它们都是先于构造器
    }

    private String color = "黑色";

    private Season() {}

    private Season(String color) { // 构造器必须是私有的
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " Season{" +
                "color='" + color + '\'' +
                '}';
    }
}

public class EnumTest {

    public static void main(String... args) {
        int n = Integer.parseInt(args[0]); // 把命令行参数的第一个字符串转换成真的整数.
        //new Season();
        Season s1 = Season.SPRING; // 直接通过类.常量对象, 最直接的方式
        System.out.println(s1); // s1.toString();
        s1 = Season.valueOf("AUTUMN"); // 根据枚举对象名获取枚举对象, 大小写敏感
        System.out.println(s1);
        Season[] values = Season.values(); // 获取保存所有枚举对象的对象数组.
        s1 = values[n];
        System.out.println("****************************");
        System.out.println(s1);
        // s1中指向的对象是谁不确定... 枚举 : 可以列举, 穷举
        switch (s1) { // switch(变量) 变量的类型:非long整数, 字符串, 枚举
            case SPRING: // 常量 : 字面量, 被final修饰的量
                System.out.println("春季");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}
