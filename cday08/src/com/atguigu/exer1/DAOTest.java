package com.atguigu.exer1;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author chenhuiup
 * @create 2020-07-16 下午 3:30
 *
 *  定义一个 测试类：
 * 创建 DAO 类的对象， 分别调用其 save、 get、 update、 list、 delete 方
 * 法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 */
public class DAOTest {

    @Test
    public void test(){
        DAO<User> userDAO = new DAO<>();

        User u1 = new User(1001,12,"Tom1");
        User u2 = new User(1002,13,"Tom2");
        User u3 = new User(1003,14,"Tom3");
        User u4 = new User(1004,15,"Tom4");
        userDAO.save("1",u1);
        userDAO.save("2",u2);
        userDAO.save("3",u3);
        userDAO.save("4",u4);

        System.out.println(userDAO);
        System.out.println("***************");
        User user = userDAO.get("1");
        System.out.println(user);
        userDAO.update("1",new User(1005,15,"Tom5"));
        System.out.println(userDAO);

        List<User> list = userDAO.list();
        for (User s : list) {
            System.out.println(s);
        }
        //jdk8新特性，方法引用，forEach
        list.forEach(System.out::println);
    }

}
