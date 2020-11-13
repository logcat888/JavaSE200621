package com.atguigu.java4;

//@HelloAnnotation(count=20, value="bbb")
public class Person2 {

    //@HelloAnnotation("ccc") // 当注解的属性名为value时, 可以省略, 其他都不能省.
    private int id;
    private String name;
    private int age;

    @HelloAnnotation(value = "zz")
    public Person2() {
    }

    public Person2(/*@HelloAnnotation*/ int id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }

    @HelloAnnotation public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @HelloAnnotation
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
