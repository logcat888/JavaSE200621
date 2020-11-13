package com.atguigu.banking;

/**
 * @author chenhuiup
 * @create 2020-07-08 下午 6:00
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account[] account = new Account[2];
    private int numOfAccounts;

    public Customer(String f,String l){
        firstName = f;
        lastName = l;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * 添加银行卡
     * @param account 银行卡类型
     */
    public void addAccount(Account account){
        this.account[numOfAccounts++] = account;
    }

    /**
     * 统计Saving卡的个数
     * @return
     */
    public int getSaving(){
        int number = 0;//统计Saving卡的个数
        for (int i = 0; i < numOfAccounts; i++) {
            if (account[i] instanceof SavingAccount)
                number++;
        }
        return number;
    }

    /**
     * 统计Checking卡的个数
     * @return
     */
    public int getChecking(){
        int number = 0;//统计Checking卡的个数
        for (int i = 0; i < numOfAccounts; i++) {
            if (account[i] instanceof CheckingAccount)
                number++;
        }
        return number;
    }

    public void SetSaving(){
        if (numOfAccounts == 2){
            if (getSaving() == 1){
                if (account[0] instanceof SavingAccount){
                    CheckingAccount other = (CheckingAccount)account[1];
                    other.setProtectBy(account[0]);
                }
            }
        }
    }
    /**
     * 返回银行卡个数
     * @return 返回银行卡个数
     */
    public int getNumOfAccounts(){
        return numOfAccounts;
    }

    public Account getAccount(int index) {
        return account[index - 1];
    }

    public void showInfo(){
        System.out.println("CUSTOMERS REPORT");
        System.out.println("===========================");
        System.out.println("Customer:" + firstName + ", " + lastName);
        for (int i = 0; i < numOfAccounts; i++) {
            if (account[i] instanceof SavingAccount)
                System.out.println("Saving Account: current balance is ￥ " + account[i].getBalance());
            System.out.println("Checking Account: current balance is ￥ " + account[i].getBalance());
        }
    }
}
