package com.atguigu.java;

import javax.xml.ws.spi.WebServiceFeatureAnnotation;

/**枚举类：
 * 1.定义：对象可数的类型，不能再创建新对象。
 * 2.格式： enum 类名{ }
 * 3.枚举类的创建：
 *      >枚举类的首行声明枚举类对象，中间通过“，”分开，以“;”结束，其是全局常量，通过public static final修饰，但可省略。
 *      >枚举类的父类是Enum，其构造器是私有的，属性声明了对象数组，构造器中有两个参数分别传递对象名和对象数组的索引
 *      >枚举类的构造器是私有的，通过静态代码块（反编译源码），创建对象，意味着枚举类不能通过new的方式再创建新的对象。
 *      >当枚举类有私有属性时，若没有显式初始化，必须提供带有形参列表的构造器，通过声明对象时显式赋值（其实是在静态代码块中创建对象）
 *      >枚举类的父类Enum类重写了toString()和equals()，toString()返回的是对象名
 *      >若枚举类没有重写toString(),则调用父类的toString方法，也返回对象名，当方法类有其它属性时，可以考虑重写toString。
 * 4.枚举类的使用
 *      4.1枚举类对象获取的三种方式:
 *              >通过  "类名.常量对象"的方式获取
 *              >根据枚举对象名获取枚举对象，“类名.valueOf("对象名")”
 *              >通过获取保存所有枚举对象的对象数组的方式获取。 “类名.values()”
 *      4.2枚举类Enum类的方法
 *              >toString()是输出对象名
 *              >valueOf()根据枚举对象名获取枚举对象
 *              >values()获取保存所有枚举对象的对象数组
 *              >equals()比较两个枚举常量是否相等
 *              >compareTo()比较两个枚举常量的大小，按照声明的先后顺序
 * 5.注意点：
 *  1.非静态代码块和显式赋值的顺序是按照写的顺序来执行的，并且他们都是优先于构造器的。
 *  2.常量分类：
 *          >字面量
 *          >被final修饰的量
 *  3.switch(变量) 中变量的类型：非long整数，字符串，枚举
 * @author chenhuiup
 * @create 2020-07-11 下午 6:16
 */
public class EnumTest {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        //new Season();
        Season s1 = Season.AUTUMN;//直接通过类.常量对象, 最直接的方式
        System.out.println(s1); //toString()
        s1 = Season.valueOf("SUMMER");//根据枚举对象名获取枚举对象
        System.out.println(s1);
        Season[] values = Season.values();//获取保存所有枚举对象的对象数组.
        s1 = values[n];

        System.out.println("***************************");
        System.out.println(s1);
        // s1中指向的对象是谁不确定... 枚举 : 可以列举, 穷举
        switch (s1){ //switch(变量) 变量的类型:非long整数, 字符串, 枚举
            case SPRING: //常量 : 字面量, 被final修饰的量
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

enum Season{
    SPRING,SUMMER,AUTUMN,WINTER;

    private String color = "黑色";
    {
        color = "白色"; //非静态代码块和显式赋值的顺序是按照写的顺序来执行的，并且他们都是优先于构造器的。
    }
    private Season(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private Season(String color){//构造器必须是私有的
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ",color" + color;
    }
}
