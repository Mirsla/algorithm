package com.alex.jvm.classloader;

/**
 * 1、对于静态字段来说，只有直接定义了该字段的类才会被初始化
 *
 *
 *
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 *
 * 在JVM参数中：
 *  -XX:    是固定的
 *  -XX:+<option>    表示开启option选项
 *  -XX:-<option>    表示关闭option选项
 *
 *  -XX:<option>=<value>    表示将option的值赋值为value
 */
public class Test {
    public static void main(String[] args) {

        /**
         * 输出：
         *  init parent
         *  Parent
         *
         *      子类并没有被初始化。
         *      每个类或者接口必须被 首次主动使用 才会被初始化
         */
//        System.out.println(Parent.value);

        /**
         * 输出：
         *      init parent
         *      Parent
         *
         *      子类并没有被初始化。
         *      每个类或者接口必须被 首次主动使用 才会被初始化
         */
//        System.out.println(Child.value);

        /**
         * 输出：
         *      init parent
         *      init Child
         *      Child
         *
         *      子类被初始化必须保证子类的父类初始化完成
         */
        System.out.println(Child.value2);
    }
}
