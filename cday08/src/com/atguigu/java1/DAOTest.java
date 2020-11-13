package com.atguigu.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author chenhuiup
 * @create 2020-07-16 下午 1:38
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> forList = dao1.getForList(10);

        StudentDAO studentDAO = new StudentDAO();
        Student index = studentDAO.getIndex(1);
    }
}
