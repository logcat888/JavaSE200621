package com.atguigu.project;

/**
 * @author chenhuiup
 * @create 2020-07-06 下午 2:30
 */
public class CustomerList {
    Customer[] customers;//用来保存客户对象的数组
    int total = 0;//记录已保存客户对象的数量

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 添加客户
     * @param customer
     * @return
     */
    public boolean addCustomer(Customer customer){
        if (total < customers.length){
            customers[total++] = customer;
            return true;
        }
        return false;
    }

    /**
     * 修改客户信息
     * @param index 客户编号
     * @param cust  客户
     * @return
     */
    public boolean replaceCustomer(int index, Customer cust){
        if (index <= total && index > 0){
            customers[index - 1] = cust;
            return true;
        }
        return false;
    }

    /**
     * 删除客户
     * @param index 客户编号
     * @return
     */
    public boolean deleteCustomer(int index){
        if (index <= total && index > 0){
            customers[index - 1] = null;
            for (int i = index - 1; i < total - 1; i++) {
                Customer temp = customers[i];
                customers[i] = customers[i + 1];
                customers[i + 1] = temp;
            }
            total--;
            return true;
        }
        return false;
    }

    /**
     * 获取客户列表
     * @return 返回客户列表
     */
    public Customer[] getAllCustomers() {
        Customer[] cust = new Customer[total];
        for (int i = 0; i < cust.length; i++) {
            cust[i] = customers[i];
        }
        return cust;
    }

    /**
     * 返回指定客户
     * @param index
     * @return
     */
    public Customer getCustomer(int index){
        if (index <= total && index > 0){
            return customers[index - 1];
        }
        return null;
    }
    public int getTotal(){
        return total;
    }
}
