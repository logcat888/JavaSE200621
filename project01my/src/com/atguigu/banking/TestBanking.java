package com.atguigu.banking;

import java.text.NumberFormat;

/**
 * @author chenhuiup
 * @create 2020-07-08 下午 5:58
 */
public class TestBanking {
    public static void main(String[] args) {
        NumberFormat currency_format = NumberFormat.getCurrencyInstance();
        Bank bank = new Bank(5);
        Customer customer;

        // Create several customers and their accounts
        bank.addCustomer("Jane", "Simms");
        customer = bank.getCustomer(1);
        customer.addAccount(new SavingAccount(500.00, 0.05));
        customer.addAccount(new CheckingAccount(200.00, 400.00));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustomer(2);
        customer.addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustomer(3);
        customer.addAccount(new SavingAccount(1500.00, 0.05));
        customer.addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Maria", "Soley");
        customer = bank.getCustomer(4);
        // Maria and Tim have a shared checking account
        customer.addAccount(bank.getCustomer(3).getAccount(2));
        customer.addAccount(new SavingAccount(150.00, 0.05));

        // Generate a report
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        for (int i = 0; i < bank.getNumberOfCustomer(); i++) {
                bank.getCustomer(i + 1).showInfo();

        }
    }
}


