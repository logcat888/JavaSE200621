package com.atguigu.myexer2;

/**
 * 写一个名为Account的类模拟账户。该类的属性和方法如下图所示。该类包括的属性：账号id，余额balance，年利率annualInterestRate；
 * 包含的方法：访问器方法（getter和setter方法），返回月利率的方法getMonthlyInterest()，取款方法withdraw()，存款方法deposit()。
 * <p>
 * 写一个用户程序测试Account类。在用户程序中，创建一个账号为1122、余额为20000、年利率4.5%的Account对象。
 * 使用withdraw方法提款30000元，并打印余额。
 * 再使用withdraw方法提款2500元，使用deposit方法存款3000元，然后打印余额和月利率。
 * <p>
 * 提示：在提款方法withdraw中，需要判断用户余额是否能够满足提款数额的要求，如果不能，应给出提示。
 * 运行结果如图所示：
 *
 * @author chenhuiup
 * @create 2020-07-04 下午 7:02
 */
public class Account {

    private int id;//账号
    protected double balance;//余额
    private double annualInterestRate;//年利率

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * @return 返回月利率
     */
    public double getMonthlyInterest() {
        return annualInterestRate / 12;
    }

    /**
     * 取款操作
     *
     * @param amount 取款数
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("余额不足！");
        } else {
            balance -= amount;
        }
    }

    /**
     * 存款操作
     *
     * @param amount 存款数
     */
    public void deposit(double amount) {
        if (amount <= 0)
            return;
        balance += amount;
    }

    /**
     * 显示账户余额
     */
    public void showBalance(){
        System.out.println("您的账户余额为： " + balance);
    }
}
