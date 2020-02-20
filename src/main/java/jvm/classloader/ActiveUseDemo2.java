package jvm.classloader;

/**
 * description: 主动使用的Demo2
 *
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 *
 * 这里指的是将常量存放到了 ActiveUseDemo2 的常量池中，这里就和 Parent2 没啥关系了
 *
 * 在使用一次（编译好了之后）， 删除Parent2的文件也可以正确的执行
 *
 *
 * javap -c 可以反编译class文件
 *
 * javap -c ActiveUseDemo2.class
 * Compiled from "ActiveUseDemo2.java"
 * public class jvm.classloader.ActiveUseDemo2 {
 *   public jvm.classloader.ActiveUseDemo2();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #4                  // String hello world
 *        5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: return
 * }
 *
 *  助记符：
 *  ldc 表示将，int float String 的常量值从常量池总推送值栈顶
 *
 * author: chenshoujiang
 * date: 2020/2/20
 */
public class ActiveUseDemo2 {
    public static void main(String[] args) {
        /**
         * 执行结果如下：
         *
         * Parent2 init
         * hello world str2
         */
//        System.out.println(Parent2.str2);

        /**
         *
         * 执行结果如下：
         *
         * hello world
         */
        System.out.println(Parent2.str);
    }
}

class Parent2 {
    static final String str = "hello world";

    static String str2 = "hello world str2";

    static {
        System.out.println("Parent2 init");
    }
}
