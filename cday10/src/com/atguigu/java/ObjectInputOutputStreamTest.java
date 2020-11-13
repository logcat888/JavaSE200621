package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 对象流
 * 1.ObjectInputStream 和ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。他的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *      序列化：用ObjectOutputStream类保存基本数据类型或对象的机制
 *      反序列化：用ObjectInputStream类读取基本数据类型或对象的机制
 *      ObjectInputStream和ObjectOutputStream不能序列化static和transient修饰的成员变量。
 *
 *  3.要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *
 *   * Person需要满足如下的要求，方可序列化
 *  * 1.需要实现接口:Serializable,否则报报异常，NotSerializableException
 *  * 2.当前类提供一个全局常量：serialVersionUID；如果不提供系统会自动生成一个序列号，
 *                          但是当类修改时系统又会自动生成一个序列号，对于之前已经序列化的对象，就找到之前的序列号进行反序列化了。
 *    3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的。(默认情况下，基本数据类型可序列化)
 *
 *    补充点：
 *    ObjectInputStream和ObjectOutputStream不能序列化static和transient修饰的成员变量。因为static归类所有，transient声明不想被序列化的属性。
 *
 *  * 4.序列化机制：
 *  * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种
 *  * 二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 *  * 当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 *
 * @author chenhuiup
 * @create 2020-07-18 上午 12:08
 */
public class ObjectInputOutputStreamTest {

    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream
     */
    @Test
    public void testObjectOutputStream(){
        //1.
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            //2.
            oos.writeObject(new String("我爱北京天安门"));

            oos.flush();//刷新操作

            oos.writeObject(new Person("张三",23));
            oos.flush();

            oos.writeObject(new Person("李四",26,69,new Account(22)));
            oos.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));

            Object object = ois.readObject();
            String string = (String) object;
            Person p = (Person)ois.readObject();
            Person p1 = (Person)ois.readObject();
            System.out.println(string);
            System.out.println(p);
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
