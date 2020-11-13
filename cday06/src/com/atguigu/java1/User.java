package com.atguigu.java1;

import java.util.Objects;

/**
 * @author chenhuiup
 * @create 2020-07-14 下午 1:40
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
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

    @Override
    public boolean equals(Object o) {
        System.out.println("User的equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //按照名字从大到小排序,年龄按照从小到大排列。
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User o1 = (User) o;
            int compare = -name.compareTo(o1.name);
            if (compare != 0 ){
                return compare;
            }else{
                return Integer.compare(age,o1.age);
            }
        }else{
            throw new RuntimeException("输入的数据类型不一致");
        }

    }
}
