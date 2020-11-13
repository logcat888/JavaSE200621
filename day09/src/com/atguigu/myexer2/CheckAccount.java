package com.atguigu.myexer2;

/**
 * 创建Account类的一个子类CheckAccount代表可透支的账户，该账户中定义一个属性overdraft代表可透支限额。
 * 在CheckAccount类中重写withdraw方法，其算法如下：
 * 如果（取款金额<账户余额），
 * 可直接取款
 * 如果（取款金额>账户余额），
 * 计算需要透支的额度
 * 判断可透支额overdraft是否足够支付本次透支需要，如果可以
 * 	将账户余额修改为0，冲减可透支金额
 * 如果不可以
 * 	提示用户超过可透支额的限额
 *
 * 	提示：
 * （1）子类CheckAccount的构造方法需要将从父类继承的3个属性和子类自己的属性全部初始化。
 * （2）父类Account的属性balance被设置为private，但在子类CheckAccount的withdraw方法中需要修改它的值，
 * 因此应修改父类的balance属性，定义其为protected。
 * @author chenhuiup
 * @create 2020-07-04 下午 7:18
 */
public class CheckAccount extends Account{
    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    /**
     * 取款操作
     * @param amount 取款数
     */
    @Override
    public void withdraw(double amount) {
        if (amount < balance){
            super.withdraw(amount);
        }else if (amount > balance + overdraft){
            System.out.println("超过可透支限额！\n");
        }else {
            overdraft -= amount - balance;
            setBalance(0);
        }
    }

    /**
     * 打印账户余额和可透支额
     */
    @Override
    public void showBalance() {
        System.out.println("您的账户余额： " + balance);
        System.out.println("您的可透支额： " + overdraft + '\n');
    }
}
