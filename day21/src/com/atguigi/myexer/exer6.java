package com.atguigi.myexer;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @author chenhuiup
 * @create 2020-07-21 下午 3:07
 */
public class exer6 {
    public static void main(String[] args) {
        Account account = new Account("张三", 3000);
        Deposit1 deposit1 = new Deposit1(account);
        Withdraw withdraw = new Withdraw(account);

        Thread thread = new Thread(withdraw);
        Thread thread1 = new Thread(deposit1);

        thread.setName("我是取钱柜台");
        thread1.setName("我是存钱柜台");

        thread.start();
        thread1.start();
    }
}

class Deposit1 implements Runnable {
    private Account account;


    public Deposit1(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.deposit();

            System.out.println(Thread.currentThread().getName() + ":存钱,余额" + account);
        }
    }
}

class Withdraw implements Runnable {
    private Account account;


    public Withdraw(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw();

            System.out.println(Thread.currentThread().getName() + ":取钱,余额" + account);
        }
    }
}