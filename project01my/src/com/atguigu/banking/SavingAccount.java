package com.atguigu.banking;

/**
 * @author chenhuiup
 * @create 2020-07-08 下午 6:42
 */
public class SavingAccount extends Account{
    private double interestRate;

    public SavingAccount(double balance,double interest_rate){
        super(balance);
        interestRate = interest_rate;
    }
    public SavingAccount(){

    }
    public SavingAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}


