package com.alex.jvm.classloader;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中。
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会出发定义常量的类的初始化
 *
 * 在这个地方就是，将常量str放入到Test2的常量池中，之后，Test2和Parent2就没有关系了。
 *
 * 也可以在编译完成后，将Parent2的class文件删除，也不会影响运行结果
 */
public class Test2  {

    public static void main(String[] args) {
        System.out.println(Parent2.i);
    }
}

class Parent2 {
    /**
     * 未加final关键字之前输出：
     *  init Parent2
     * Parent2
     */
//    public static String str = "Parent2";

    /**
     * 加了final关键字
     * 输出：
     * Parent2
     *
     * final关键字修饰的变量表示一个常量，在编译阶段，虚拟机会将该变量放入调用该常量的所在方法的类的常量池中
      */
    public static final String str = "Parent2";

    public static final int i = -1;

    static {
        System.out.println("init Parent2");
    }
}
