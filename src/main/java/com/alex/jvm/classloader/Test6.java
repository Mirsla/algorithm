package com.alex.jvm.classloader;

public class Test6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();

        /**
         * 输出结果
         *  count1: 1
         *  count2: 0
         *
         * 1、初始化时按照声明变量从上到下的顺序执行的
         *
         *
         * 2、在准备阶段，Singleton静态属性和变量是从上到下执行的
         * 所以：1) 在准备阶段：count1 = 0， count2 = 0, singleton = null；准备阶段赋初值
         *      2) 然后到了初始化阶段： 调public static int count1 = 0； 用 Singleton的构造方法 count1 = 1， count2 = 1,
         *                             执行public static int count2 = 0; count2 = 0；
         *
         */
        System.out.println("count1: " + Singleton.count1);
        System.out.println("count2: " + Singleton.count2);
    }
}


class Singleton {
    public static int count1;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        count1++;
        count2++;

        System.out.println(count1);
        System.out.println(count2);
    }

    public static int count2 = 0;

    public static Singleton getSingleton() {
        return singleton;
    }
}