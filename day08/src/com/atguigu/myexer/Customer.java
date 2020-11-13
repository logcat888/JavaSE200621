package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-03 下午 3:56
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f,String l){
        firstName = f;
        lastName = l;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Account getAccount(){
        return account;
    }
    public void setAccount(Account account){
        this.account = account;
    }

    public void showInfo(){
        System.out.println("Customer [ "  + getLastName() + ", " + getFirstName() + " ] has a account: id is "
                +account.getId() + ", annualInterestRate is "  + account.getAnnualInterestRate()*100 +
                "%, balance is " + account.getBalance());
    }

}
