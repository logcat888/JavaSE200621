package com.atguigu.java;

import org.junit.Test;

import java.util.Objects;

/**
 * @author chenhuiup
 * @create 2020-07-12 下午 4:50
 */
public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Double.compare(goods.price, price) == 0 &&
                Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
// 指明商品比较大小的方式：按照价格从低到高排序，再按照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods) o;
            //方式一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return -name.compareTo(goods.name);
            }
//            //方式二：
//            return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }


}
