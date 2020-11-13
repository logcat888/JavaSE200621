package com.atguigi.java1;

public class Withdraw implements Runnable {

    private Account account;

    public Withdraw(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        // 取钱
        for (int i = 0; i < 3; i++) {
            synchronized ("") {
                if (account.getBalance() < 1000) {
                    System.out.println("钱不够, 等待....");
                    try {
                        "".wait(); // 必须通过锁对象调用wait和nofity
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                account.setBalance(account.getBalance() - 1000);
                System.out.println(Thread.currentThread().getName() + " 取完钱后 : " + account);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
