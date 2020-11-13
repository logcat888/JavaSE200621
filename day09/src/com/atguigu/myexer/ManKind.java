package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 1:43
 */
public class ManKind {
    int sex;
    int salary;

    public void manOrWoman(){
        if (sex == 1){
            System.out.println("man");
        }else{
            System.out.println("woman");
        }
    }

    public void employeed(){
        if (salary != 0){
            System.out.println("job");
        }else{
            System.out.println("no job");
        }
    }
}
