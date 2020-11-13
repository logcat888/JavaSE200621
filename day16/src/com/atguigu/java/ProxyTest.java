package com.atguigu.java;

/**
 * @author chenhuiup
 * @create 2020-07-14 上午 8:33
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxyB b = new ProxyB();
        b.browse();
    }

}

interface NetWork{

    public abstract void browse();
}

class ProxyA implements NetWork{

    @Override
    public void browse() {
        System.out.println("我会上网");
    }
}

class ProxyB implements NetWork{

    NetWork netWork;

    public ProxyB(){
        netWork = new ProxyA();
    }

    @Override
    public void browse() {
        System.out.println("上网前的检查");
        netWork.browse();
        System.out.println("可以上网");
    }
}
