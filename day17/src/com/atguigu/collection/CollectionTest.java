package com.atguigu.collection;

import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.util.*;

/**
 * 集合 : 解决批量对象的存储问题.
 * 简单地看作是一个可变长度的Object[]. 是一个长度可变的容器.
 * Collection : 保存一个一个的对象
 *      无序可重复. 无序 : 不按添加顺序保存元素, 可重复 : 重复的对象可以多次添加.
 *      boolean add(Object obj) 添加元素, 返回值表示添加成功或失败
 *      boolean contains(Object obj) 判断当前集合中是否包含参数中的对象
 *      boolean remove(Object obj) 删除指定的元素
 *      int size() 返回元素个数
 *
 *      Set : 保存一个一个的对象, 无序不可重复
 *          HashSet : 使用哈希算法实现的Set集合.
 *              去重规则 : 两个对象的equals为true, 两个对象的hashCode也必须相等.
 *
 *          TreeSet : 基于二叉搜索树实现的Set集合. 内部要实现自然排序, 如果提供了比较器,它就会定制排序.
 *              去重规则 : 两个对象的compare为0.
 *
 *      List : 保存一个一个的对象, 有序可重复
 *          void add(int index, Object ele). 在指定下标位置处插入新元素
 *          Object get(int index) 返回指定下标处的元素
 *          Object remove(int index) 删除指定下标处的元素
 *          Object set(int index, Object ele) 替换指定下标处的元素为参数ele. 旧元素作为返回值.
 *
 *          ArrayList : 基于数组实现的List集合
 *          Vector : 和ArrayList等价.
 *          LinkedList : 基于链表实现的List集合.
 *
 * Map : 保存一对一对的对象
 *
 */

class Student implements Comparable {

    private int id;
    private String name;
    private int grade;
    private double score;

    public Student() {}

    public Student(int id, String name, int grade, double score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public int getId() {
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                grade == student.grade &&
                Double.compare(student.score, score) == 0 &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grade, score);
    }

    @Override
    public int compareTo(Object o) throws RuntimeException {
        if (!(o instanceof Student)) {
            throw new RuntimeException("对象不可比");
        }
        int n = (int)(this.score - ((Student)o).score);
        if (n == 0) {
            n = 1;
        }
        return n;
    }

}

// 写一个比较器, 用于完成两个学生对象的比较
class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof Student) || !(o2 instanceof Student)) {
            throw new RuntimeException("对象不可比");
        }
        return -(((Student)o1).getGrade() - ((Student)o2).getGrade());
    }
}

public class CollectionTest {

    @Test
    public void test7() {
        MyComparator myComparator = new MyComparator();
        Set set = new TreeSet(myComparator); // 通过构造器传递对象, 99.9%的情况是对象关联.
        Student s1 = new Student(1,"小明", 5, 80);
        Student s2 = new Student(2,"小花", 4, 90);
        Student s3 = new Student(3,"小伟", 2, 100);
        Student s4 = new Student(4,"小芳", 1, 90);
        Student s5 = new Student(5,"小丽", 6, 50);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        for (Object tmp : set) {
            System.out.println(tmp);
        }

        System.out.println("*************************************");
        // 1) 遍历谁, 就向谁要迭代器.
        Iterator iterator = set.iterator();
        // 使用注意事项1 : 迭代器要趁热使用
        // set.remove(s1); 不要随意再修改集合的内容, 否则迭代器会出问题.
        // 2) 循环依次询问当前游标后面有无元素, 如果有, 返回true
        while (iterator.hasNext()) {
            // 真的获取到后面的元素, 并且会引发内部游标的下移
            Object obj = iterator.next();
            // next()在循环中必须只调用一次.
            System.out.println(obj);
        }
        // 使用注意事项 : 迭代器是一次性使用, 用完作废.

    }

    @Test
    public void test6() {
        Set set = new TreeSet();
        Student s1 = new Student(1,"小明", 5, 80);
        Student s2 = new Student(2,"小花", 4, 90);
        Student s3 = new Student(3,"小伟", 2, 100);
        Student s4 = new Student(4,"小芳", 1, 90);
        Student s5 = new Student(5,"小丽", 6, 50);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        for (Object tmp : set) {
            System.out.println(tmp);
        }
    }

    @Test
    public void test5() {
        Set set = new TreeSet();
        //set.add(20);
        //set.add(5);
        //set.add(2);
        //set.add(10);
        set.add("cc");
        set.add("bb");
        set.add("aa");
        //set.add(30);

        for (Object tmp : set) {
            System.out.println(tmp);
        }
    }

    @Test
    public void test4() {
        Set set = new TreeSet();
        set.add(20);
        set.add(5);
        set.add(2);
        set.add(10);
        set.add(80);
        set.add(60);
        set.add(5);

        for (Object tmp : set) {
            System.out.println(tmp);
        }
    }

    @Test
    public void test3() {
        Set set = new HashSet(); // 无序不可重复
        Student s1 = new Student(1, "小明", 3, 80);
        Student s2 = new Student(2, "小丽", 2, 90);
        Student s3 = new Student(1, "小明", 3, 80);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s1);

        for (Object obj : set) {
            System.out.println(obj);
        }
    }

    // 创建一个List集合, 保存10个20以内的随机整数.
    @Test
    public void exer3() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int n = (int)(Math.random() * 20);
            list.add(n);
        }
        // 遍历
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }
    }

    // 创建一个List集合, 保存10个20以内的随机整数, 不要重复的.
    @Test
    public void exer4() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int n = (int)(Math.random() * 20);
            if (list.contains(n)) {
                i--;
                continue;
            }
            list.add(n);
        }

        for (Object tmp : list) {
            System.out.println(tmp);
        }
    }

    @Test
    public void exer42() {
        List list = new ArrayList();
        while (list.size() != 10) {
            int n = (int)(Math.random() * 20);
            if (!list.contains(n)) {
                list.add(n);
            }
        }

        for (Object tmp : list) {
            System.out.println(tmp);
        }
    }

    @Test
    public void exer43() {
        List list = new ArrayList();
        for (int i = 0; i < 10;) {
            int n = (int)(Math.random() * 20);
            if (!list.contains(n)) {
                list.add(n);
                i++;
            }
        }

        for (Object tmp : list) {
            System.out.println(tmp);
        }
    }

    @Test
    public void test2() {
        List list = new ArrayList();
        list.add("abc");
        list.add("yyy");
        list.add(new Integer(200));
        list.add("abc");
        list.add(200);
        list.add(new Student(2, "小丽", 1, 50));
        System.out.println(list);
        list.add(2, "我是汉字"); // 插入
        list.add(1, 3);
        System.out.println(list);
        Object o = list.get(7);
        System.out.println(o);
        list.remove(3); // 整数会优先作为下标来使用
        list.remove(Integer.valueOf(3)); // 删除对象
        System.out.println(list); //[abc, yyy, 200, abc, 200, Student{id=2, name='小丽', grade=1, score=50.0}]
        list.set(3, 3.14); // 替换操作
        System.out.println(list);
        System.out.println("*************************************");
        for (int i = 0; i < list.size(); i++) {
            Object o1 = list.get(i);
            System.out.println(o1);
        }

    }

    // 创建一个Set集合, 保存10个20以内的随机整数.
    @Test
    public void exer1() {
        Set set = new HashSet();
        for (int i = 0; i < 10; i++) {
            set.add((int)(Math.random() * 20));
        }
        // 遍历集合
        for (Object tmp : set) {
            System.out.println(tmp);
        }
    }
    // 创建一个Set集合, 保存10个20以内的随机整数. 保证10个.
    @Test
    public void exer12() {
        Set set = new HashSet();
        while (set.size() != 10) {
            set.add((int)(Math.random() * 20));
        }
        // 遍历集合
        for (Object tmp : set) {
            System.out.println(tmp);
        }
    }

    @Test
    public void exer13() {
        Set set = new HashSet();
        for (int i = 0; i < 10; i++) {
            int n = (int)(Math.random() * 20);
            if (!set.add(n)) {
                i--;
            }
        }
    }

    @Test
    public void exer14() {
        Set set = new HashSet();
        for (int i = 0; i < 10; ) {
            int n = (int)(Math.random() * 20);
            if (set.add(n)) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Set set = new HashSet(); // Set : 无序不可重复
        set.add("abc");
        set.add("yyy");
        set.add(new Integer(200));
        set.add(100); // set.add(Integer.valueOf(100));
        set.add(new Student(1, "小明", 2, 80));
        boolean b1 = set.add("yyy");
        boolean b2 = set.add(200);
        System.out.println(b1);
        System.out.println(b2);

        System.out.println(set.size());

        System.out.println(set);

        System.out.println("***************************************");
        // 遍历集合.
        for (Object tmp : set) {
            System.out.println(tmp);
        }

        boolean contains = set.contains(200); // 判断是否包含
        System.out.println("contains = " + contains);

        set.remove(100); // 删除

        System.out.println(set);
    }
}
