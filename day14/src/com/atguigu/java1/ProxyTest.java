package com.atguigu.java1;

/**
 * 代理 : 把代理对象当成被代理对象来使用.
 * 场景 :
 *      1 使用者无法直接创建被代理对象
 *      2 对于被代理对象的方法有改进的需求.但是同时不能修改被代理类.
 */
interface HouseRent {
    void rent();
}

class FangDong implements HouseRent {

    @Override
    public void rent() {
        System.out.println("我有房子要出租, 刚结婚用的, 请爱护.... 账号1234567");
    }
}

class FangDong2 implements HouseRent {

    @Override
    public void rent() {
        System.out.println("我有房子要出租, 刚死了2个人, 不用开空调...");
    }
}

class LianJia implements HouseRent {

    private HouseRent hr = new FangDong2();

    @Override
    public void rent() {
        System.out.println("请交中介费5000");
        hr.rent(); // 原始方法调用, 这里是切面, 体现AOP
        System.out.println("及时交房租, 不然赶走... 支持微信, 支付宝");
    }
}


public class ProxyTest {

    public static void main(String[] args) {
        // 用户 : 只能new代理对象
        HouseRent hr = new LianJia();
        hr.rent();
    }
}
