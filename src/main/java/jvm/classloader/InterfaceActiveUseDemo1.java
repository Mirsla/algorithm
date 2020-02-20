package jvm.classloader;

/**
 * description:
 *
 *  接口的主动使用Demo
 *      8.8_接口初始化规则与类加载器准备阶段和初始化阶段的重要意义分析(8)
 *
 *
 *  当一个接口初始化是并不要求其父接口也完成初始化
 *  只有真正使用到父接口时，比如引用接口中所定义的常量是，才会被初始化
 * author: chenshoujiang
 * date: 2020/2/20
 */
public class InterfaceActiveUseDemo1 {

    public static void main(String[] args) {

        /**
         * 输出结果
         *  6
         */
//        System.out.println(MyChild5.b);

        /**
         * 输出结果5
         *
         */
        System.out.println(MyChild5.a);
    }
}

interface Parent5 {
    public static int a = 5;
}

interface MyChild5 extends Parent5 {
    public static int b = 6;
}

