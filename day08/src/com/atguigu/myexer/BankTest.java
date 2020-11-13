package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-03 下午 6:40
 */
public class BankTest {
    public static void main(String[] args) {
        //创建银行账户容量为20
        Bank test = new Bank(20);
        //添加第一个客户
        test.addCustomer("李","蛋");
        test.getCustomer(0).setAccount(new Account(7777,2000,0.02));
        //李蛋存500
        test.getCustomer(0).getAccount().deposit(500);
        //李蛋取100
        test.getCustomer(0).getAccount().withdraw(1000);
        //显示李蛋资料
        test.getCustomer(0).showInfo();

        //添加第二个银行账户
        test.addCustomer("狗","三");
        System.out.println("银行的客户数为：" + test.getNumberOfCustomer());
    }
}
