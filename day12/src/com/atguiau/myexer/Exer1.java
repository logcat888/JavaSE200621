package com.atguiau.myexer;

/**
 *
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，
 * 定义封装这些属性的方法。账号要自动生成。
 * 编写主类，使用银行账户类，输入、输出3个储户的上述信息。
 * 考虑：哪些属性可以设计成static属性。
 * @author chenhuiup
 * @create 2020-07-08 下午 2:41
 */
public class Exer1 {
    public static void main(String[] args) {
        BankAcouunt acct1 = new BankAcouunt("777777",10000);
        BankAcouunt acct2 = new BankAcouunt("888888",20000);
        BankAcouunt acct3 = new BankAcouunt("999999",30000);
        BankAcouunt.setRate(0.0025);
        System.out.println(acct1.toString());
        System.out.println(acct2);
    }
}

class BankAcouunt{
    private final int id;//账号
    private String password;//密码
    private double balance;//余额
    private static double rate;//利息
    private static double minBalance;//最小余额
    private static int number = 1000;//记录账号


    public BankAcouunt(String password, double balance) {
        id = number ++;
        this.password = password;
        this.balance = balance;
    }

    public static void setRate(double rate) {
        BankAcouunt.rate = rate;
    }

    public static void setMinBalance(double minBalance) {
        BankAcouunt.minBalance = minBalance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public static double getRate() {
        return rate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BankAcouunt{" +
                "id=" + id +
                ", balance=" + balance + ", rate" + rate +
                '}';
    }
}