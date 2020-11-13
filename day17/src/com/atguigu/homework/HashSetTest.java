package com.atguigu.homework;

import org.junit.Test;

import java.util.*;

/**
 * @author chenhuiup
 * @create 2020-07-15 下午 3:20
 */
public class HashSetTest {

    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(new Person("jerry",12,"man"));
        set.add(new Person("jerry",13,"man"));
        set.add(new Person("jerry",14,"man"));

        System.out.println(set);
    }

    @Test
    public void test2(){
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person person1 = (Person) o1;
                    Person person2 = (Person) o2;
                    if (person1.getName().equals(person2.getName())){
                        return person1.getAge() - person2.getAge();
                    }else {
                        return person1.getName().compareTo(person2.getName());
                    }
                }
                throw new RuntimeException("类型不一致！");
            }
        });
        set.add(new Person("Jerry",12,"man"));
        set.add(new Person("Tom",13,"man"));
        set.add(new Person("Bob",14,"man"));
        set.add(new Person("Bob",15,"man"));

        System.out.println(set);
        System.out.println("*************");

        Iterator iterator = set.iterator();
//        set.remove(new Person("Bob",15,"man"));  获取迭代器后，不能删除集合内容，否则游标会缺失。
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*************");
        set.forEach(System.out::println);


    }

}

class Person {
   private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}