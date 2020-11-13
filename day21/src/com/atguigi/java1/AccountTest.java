package com.atguigi.java1;

public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account("张三", 0);

        Runnable runner2 = new Withdraw(account);
        Thread thread3 = new Thread(runner2);
        thread3.setName("取钱柜台1");
        thread3.start();

        Runnable runner1 = new Deposit(account);
        Thread thread1 = new Thread(runner1);
        thread1.setName("存钱柜台1");
        thread1.start();

        //Thread thread2 = new Thread(runner1);
        //thread2.setName("存钱柜台2");
        //thread2.start();
    }
}
