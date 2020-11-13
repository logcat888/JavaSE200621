package com.atguigu.myexer1;

/**
 * 请根据以下代码自行定义能满足需要的MyDate类,
 * 在MyDate类中覆盖equals方法，使其判断当两个MyDate类型对象的年月日都相同时，
 * 结果为true，否则为false。    public boolean equals(Object o)
 * @author chenhuiup
 * @create 2020-07-07 下午 1:57
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return false;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyDate other = (MyDate)obj;
        return year == other.year && month == other.month && day == other.day;
    }
}
