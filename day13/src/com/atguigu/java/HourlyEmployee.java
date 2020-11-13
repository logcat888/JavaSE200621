package com.atguigu.java;

/**
 * @author chenhuiup
 * @create 2020-07-10 下午 2:14
 */
public class HourlyEmployee extends Employee{
    private double wage;
    private int hour;

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "wage=" + wage +
                ", hour=" + hour +
                "} " + super.toString();
    }
}
