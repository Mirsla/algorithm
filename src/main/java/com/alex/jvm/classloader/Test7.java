package com.alex.jvm.classloader;

/**
 * 类加载器相关，双亲委托机制
 */
public class Test7 {

    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 输出null， 说明这是一个启动类加载器（根类加载器）
         */
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.alex.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader());
    }
}

class C {

}
