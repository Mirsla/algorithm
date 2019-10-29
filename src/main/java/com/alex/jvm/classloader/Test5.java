package com.alex.jvm.classloader;

import java.util.Random;

/**
 * 接口初始化规则与类加载器准备阶段
 *
 * 当一个接口初始化时，并不要求其父接口都完成初始化
 * 只有真正使用到父接口时（如引用父接口中所定义的常量），才会初始化
 */
public class Test5 {

    public static void main(String[] args) {

        /**
         *
         * 1、
         * 输出结果6
         *
         * 当一个接口初始化时并不要求其父接口都完成了初始化
         */
//        System.out.println(Child5.b);

        /**
         * 2、
         *
         *  随机数，将 编译完成的文件删除后 会报： java.lang.NoClassDefFoundError: com/alex/jvm/classloader/Child5
         */
//        System.out.println(Child5.b);

        /**
         * 3、在父类中新增 int d = new Random().nextInt(2);
         *
         *  输出6，并没有调用new Random().nextInt(2);的初始化
         *
         */

        System.out.println(Child5.b);
    }

}

interface Parent5 {
    int a = 5;

    int d = new Random().nextInt(2);
}

interface Child5 extends Parent5 {
    // 对于接口来说 public static final 都是默认的
    int b = 6;

//    int c = new Random().nextInt(2); // 对于这种形式累加器在初始化的时候不会将常量c放入常量池中
}
