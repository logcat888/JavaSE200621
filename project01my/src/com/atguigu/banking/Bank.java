package com.atguigu.banking;

/**
 * @author chenhuiup
 * @create 2020-07-08 下午 6:22
 */
public class Bank {
    private Customer[] customers;//存储客户的对象数组
    private int numberOfCustomer;//记录客户数量

    public Bank(){

    }

    public Bank(int total){
        customers = new Customer[total];
    }

    /**
     * 添加客户到客户数组中，并记录客户总数量
     * @param f 客户的姓
     * @param l 客户的名
     */
    public void addCustomer(String f,String l){
        customers[numberOfCustomer++] = new Customer(f,l);
    }

    /**
     * 获取银行的总客户数量
     * @return 客户数量
     */
    public int getNumberOfCustomer(){
        return numberOfCustomer;
    }

    /**
     * 获取指定位置的客户
     * @param index 客户编号
     * @return 指定客户
     */
    public Customer getCustomer(int index){
        return customers[index - 1];
    }
}
