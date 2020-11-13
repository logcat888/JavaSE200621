package com.atguigi.myexer;

/**
 *  生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 *  店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何解决线程的安全问题？同步机制,有三种方法
 * 4. 是否涉及线程的通信？是
 *
 * @author chenhuiup
 * @create 2020-07-23 下午 6:45
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);
        Thread thread = new Thread(productor);
        Thread thread1 = new Thread(customer);
        Thread thread2 = new Thread(customer);

        thread.start();
        thread1.start();
        thread2.start();

    }
}

class Clerk{
    private int product = 20;

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public synchronized void produceProduct(){
        if (product < 20){
            product++;
            System.out.println(Thread.currentThread().getName() + "生产第" + product + "个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void customerProduct(){
        if (product > 0){
            System.out.println(Thread.currentThread().getName() + "消费第" + product + "个产品");
            product--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor implements Runnable{

    private Clerk clerk;

    public Productor() {
    }

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.produceProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer implements Runnable{

    private Clerk clerk;

    public Customer() {
    }

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.customerProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}