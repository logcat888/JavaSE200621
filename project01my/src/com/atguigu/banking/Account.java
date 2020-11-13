package com.atguigu.banking;

/**
 * @author chenhuiup
 * @create 2020-07-08 下午 5:46
 */
public class Account {
    protected double balance;

    public Account(double init_balance){
        balance = init_balance;
    }

    public Account() {
    }

    public double getBalance(){
        return balance;
    }

    /**
     * 存钱操作
     * @param amt 存款数
     */
    public boolean deposit(double amt){
        if(amt <= 0 ){
            System.out.println("输入有误，请重新存款！");
        }
        balance += amt;
        return true;
    }

    public boolean withdraw(double amt){
        if (amt > balance){
            System.out.println("余额不足！");
            return false;
        }
        if (amt <= 0){
            System.out.println("输入有误，请重新取款！");
            return false;
        }
        balance -= amt;
        return true;
    }
}
