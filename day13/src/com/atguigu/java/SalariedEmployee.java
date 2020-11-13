package com.atguigu.java;

/**
 * @author chenhuiup
 * @create 2020-07-10 下午 2:14
 */
public class SalariedEmployee extends Employee{
    private double monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }


    @Override
    public double earnings() {
        return monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String toString(){
        return "SalariedEmployee: " + super.toString();
    }
}
