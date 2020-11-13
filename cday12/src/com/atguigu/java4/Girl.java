package com.atguigu.java4;

/**
 * @author chenhuiup
 * @create 2020-08-16 下午 7:06
 */
public class Girl {
    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
