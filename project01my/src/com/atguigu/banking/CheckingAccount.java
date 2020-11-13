package com.atguigu.banking;

/**
 * @author chenhuiup
 * @create 2020-07-08 下午 6:46
 */
public class CheckingAccount extends Account{
//    private double overdraftProtection;//透支限额
//    private SavingAccount protectBy;//透支保护
//    public CheckingAccount(){
//        super();
//    }
//    public CheckingAccount(double balance){
//        super(balance);
//    }
//
//    public CheckingAccount(double balance,double protect){
//        super(balance);
//        overdraftProtection = protect;
//    }
//
//    public void setProtectBy(Account protectBy) {
//        this.protectBy = protectBy;
//    }
//
//    public CheckingAccount(double balance, SavingAccount protectBy){
//        super(balance);
//        this.protectBy = protectBy;
//    }
//
//    @Override
//    public boolean withdraw(double amt) {
//        if (amt > balance + protectBy.getBalance()){
//            System.out.println("超过可透支限额！");
//            return false;
//        }else if (amt < balance){
//            super.withdraw(amt);
//            return true;
//        }else {
//           protectBy.withdraw(amt - balance);
//            balance = 0;
//            return true;
//        }
//    }
}
