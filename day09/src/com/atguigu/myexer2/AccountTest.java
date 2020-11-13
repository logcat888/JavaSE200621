package com.atguigu.myexer2;

/**
 *
 *  * 写一个用户程序测试Account类。在用户程序中，创建一个账号为1122、余额为20000、年利率4.5%的Account对象。
 *  * 使用withdraw方法提款30000元，并打印余额。
 *  * 再使用withdraw方法提款2500元，使用deposit方法存款3000元，然后打印余额和月利率。
 * @author chenhuiup
 * @create 2020-07-04 下午 7:11
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122,20000,0.045);
        //提款30000元
        account.withdraw(30000);
        //打印余额
        account.showBalance();
        //使用withdraw方法提款2500元，使用deposit方法存款3000元
        account.withdraw(2500);
        account.deposit(3000);
        //打印余额和月利率
        account.showBalance();
        System.out.println("月利率为： " + account.getMonthlyInterest());
    }
}
