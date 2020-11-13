package com.atguigu.myexer1;

/** * 请根据以下代码自行定义能满足需要的MyDate类,
 * 在MyDate类中覆盖equals方法，使其判断当两个MyDate类型对象的年月日都相同时，
 * 结果为true，否则为false。    public boolean equals(Object o)
 * @author chenhuiup
 * @create 2020-07-07 下午 6:10
 */
public class MyDateTest {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate(77777,7,7);
        MyDate myDate2 = new MyDate(77777,7,7);
        MyDate myDate3 = new MyDate(77777,7,8);
        System.out.println(myDate1.equals(myDate2));
        System.out.println(myDate1.equals(myDate3));

    }
}
