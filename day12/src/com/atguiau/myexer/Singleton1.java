package com.atguiau.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-08 下午 2:29
 */
public class Singleton1 {


}

class Bank{

    //1.私有化构造器
    private Bank(){

    }


    //2.内部创建私有对象
    private static Bank bank = new Bank();

    //3.外部通过获方法取对象
    public static Bank getBank(){
        return bank;
    }
}

class Account{


    //1.私有化构造器
    private Account(){

    }
    //静态属性（类变量）便于静态方法调用
    //2.内部声明私有对象
    private static Account account = null;

    //3.外部通过静态方法获取对象
    public static Account getAccount(){
        if (account == null)
            return account = new Account();
        return account;
    }


}