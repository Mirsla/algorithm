package jvm.classloader;

/**
 * description: 主动使用的Demo
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕了
 *
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 * -XX:+TraceClassOnLoading,用于追踪类的卸载信息并打印出来
 *
 * author: chenshoujiang
 * date: 2020/2/20
 */
public class ActiveUseDemo {
    public static void main(String[] args) {

        /**
         * 执行结果
         *      My Parent1 static block
         *      Hello World
         *
         * 为什么My Child static block 没有执行？ 因为没有对Child1的主动使用
         *
         */
        System.out.println(Child1.str);

        /**
         * 使用的时候请把前面的打印注释掉
         *
         *  My Parent1 static block
         * My Child static block
         * welcome
         */
        System.out.println(Child1.str2);
    }
}

class Parent1{
    static String str = "Hello World";

    static {
        System.out.println("My Parent1 static block");
    }
}

class Child1 extends Parent1 {

    static String str2 = "welcome";

    static {
        System.out.println("My Child static block");
    }
}
