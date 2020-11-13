package com.atguigi.myexer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenhuiup
 * @create 2020-07-21 下午 2:33
 *
 * 银行有一个账户Account包含属性name, balance
 * 写一个普通 类Deposit实现Runnable, 在run方法中存钱
 * 有两个柜台(线程)分别同时向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。睡眠10毫秒
 *
 * 问题：该程序是否有安全问题，如果有，如何解决？
 */
public class exer5 {
    public static void main(String[] args) {
        Account account = new Account("李二狗", 3000);
        Deposit deposit = new Deposit(account);
        Thread thread1 = new Thread(deposit);
        Thread thread2 = new Thread(deposit);
        thread1.setName("柜台一");
        thread2.setName("柜台二");
        thread1.start();
        thread2.start();
    }
}


class Deposit implements Runnable{
    private Account account;
   private ReentrantLock lock = new ReentrantLock();

    public Deposit(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

//方式三：同步锁
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

                lock.lock();
                account.deposit();
                lock.unlock();
            System.out.println(Thread.currentThread().getName() + ":存钱,余额" + account.getBalance());
        }
    }
//方式一：同步代码块
//    @Override
//    public void run() {
//        for (int i = 0; i < 3; i++) {
//            synchronized (""){
//
//                account.deposit();
//            }
//            System.out.println(Thread.currentThread().getName() + ":存钱,余额" + account.getBalance());
//        }
//    }
}


class Account{
    private String name;
    private static double balance;
//方式二：同步方法
//    public synchronized void deposit(){
//        balance += 1000;
//    }

    public  static synchronized void deposit(){
        balance += 1000;
    }
    public static synchronized void withdraw(){
        balance -= 1000;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
}