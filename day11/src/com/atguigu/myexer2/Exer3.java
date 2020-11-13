package com.atguigu.myexer2;

import java.util.Scanner;
import java.util.Vector;

/**
 *   利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。而向量类java.util.Vector可以根据需要动态伸缩。
 * 创建Vector对象：Vector v=new Vector();
 * 给向量添加元素：v.addElement(Object obj);   //obj必须是对象
 * 取出向量中的元素：Object  obj=v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 计算向量的长度：v.size();
 * 若与最高分相差10分内：A等；20分内：B等；
 *       30分内：C等；其它：D等
 * @author chenhuiup
 * @create 2020-07-07 下午 6:17
 */
public class Exer3 {
    public static void main(String[] args) {
        Exer3 test = new Exer3();
        Vector vector= test.inputScore();//输入学生成绩
        System.out.println("学生的最高分为： " +  test.maxScore(vector));//获取学生最高分
        test.sortScore(vector);//给学生按分等级
    }

    /**
     * 输入学生成绩
     * @return 返回学生含有成绩数组对象
     */
    public Vector inputScore(){
        Vector v=new Vector();
        Scanner scanner = new Scanner(System.in);
        for (;;){
            System.out.println("请输入学生成绩（输入负数代表结束）");
            Integer num = scanner.nextInt();
            if (num < 0 ){
                System.out.println("请输入学生成绩结束");
                break;
            }
            if (num > 100){
                System.out.println("请输入学生成绩有误，重新输入");
                continue;
            }
            v.addElement(num);
        }
        return v;
    }

    /**
     * 找出学生最高分
     * @return 返回最高分
     */
    public int maxScore(Vector vector){
        int maxScore = (Integer) vector.elementAt(0);
        for (int i = 1; i < vector.size();i++){
            maxScore = (maxScore > (Integer)vector.elementAt(i))? maxScore:(Integer)vector.elementAt(i);
        }
        return maxScore;
    }

    /**
     * 给学生分等级
     * 若与最高分相差10分内：A等；20分内：B等；
     *  *       30分内：C等；其它：D等
     * @param vector 含学生成绩的变量
     */
    public void sortScore(Vector vector){
        int maxscore = maxScore(vector);//找出学生最高分
        for (int i = 0; i < vector.size(); i++) {
            if ((Integer)vector.elementAt(i) - maxscore >= -10)
                System.out.println("学生 " + (i + 1) + " 的分数为 " + (Integer)vector.elementAt(i) + " 等级为 " + "A");
            else if ((Integer)vector.elementAt(i) - maxscore >= -20)
                System.out.println("学生 " + (i + 1) + " 的分数为 " + (Integer)vector.elementAt(i) + " 等级为 " + "B");
            else if ((Integer)vector.elementAt(i) - maxscore >= -30)
                System.out.println("学生 " + (i + 1) + " 的分数为 " + (Integer)vector.elementAt(i) + " 等级为 " + "C");
            else
                System.out.println("学生 " + (i + 1) + " 的分数为 " + (Integer)vector.elementAt(i) + " 等级为 " + "D");
        }
    }
}
