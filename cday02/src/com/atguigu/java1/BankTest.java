package com.atguigu.java1;

/**
 * 使用同步机制将单利模式种懒汉式改写为线程安全的
 *
 * @author chenhuiup
 * @create 2020-07-19 下午 8:48
 */
public class BankTest {
}


class Bank {


    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
//    public static synchronized Bank getInstance() {//效率低
        //方式一：效率稍差
////        synchronized (Bank.class) {
//            if (instance == null) {
//
//                instance = new Bank();
//            }
////        }
//        return instance;
        //方式二：效率更高
        if (instance == null){
            synchronized (Bank.class) {
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}