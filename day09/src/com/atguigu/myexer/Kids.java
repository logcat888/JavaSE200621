package com.atguigu.myexer;

/**
 *
 * 修改方法重写的练习中定义的类Kids中employeed()方法，在该方法中调用父类ManKind的employeed()方法，
 * 然后再输出“but Kids should study and no job.”
 *
 * @author chenhuiup
 * @create 2020-07-04 下午 1:46
 */
public class Kids extends ManKind{
    int yearsOld;

    public void printAge(){
        System.out.println(yearsOld);
    }

    @Override
    public void employeed() {
        System.out.println("but Kids should study and no job.");
    }
}
