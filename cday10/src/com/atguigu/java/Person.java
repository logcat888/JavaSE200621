package com.atguigu.java;

import javax.security.auth.login.AccountException;
import java.io.Serializable;
import java.util.Objects;

/**
 * Person需要满足如下的要求，方可序列化
 * 1.需要实现接口:Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的。(默认情况下，基本数据类型可序列化)
 *
 * 补充点：
 *  *    ObjectInputStream和ObjectOutputStream不能序列化static和transient修饰的成员变量。
 *          因为static归类所有，transient声明不想被序列化的属性。
 *
 * @author chenhuiup
 * @create 2020-07-18 上午 7:19
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 4786584845648L;
    private String name;
    private int age;
    private int id;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Person(String name, int age, int id, Account account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class Account implements Serializable{
    public static final long serialVersionUID = 56556566145984L;
    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }
}