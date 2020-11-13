package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-03 下午 4:19
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {

    }

    /**
     * 银行账户容量为20
     * @param x 银行账户容量
     */
    public Bank(int x) {
        customers = new Customer[x];
    }
    /**
     * 添加客户
     * @param f 客户姓
     * @param l 客户名
     */
    //
    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
        customers[numberOfCustomer++] = customer;
       // customers[numberOfCustomer] = new Customer(f, l);
       // numberOfCustomer++;
    }

    /**
     *
     * @return 获取客户的数量
     */
    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    //获取客户
    public Customer getCustomer(int index) {
        if(index >= 0 && index < numberOfCustomer){
            return customers[index];
        }

        return null;
    }
}
