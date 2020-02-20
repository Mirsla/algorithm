package jvm.classloader;

/**
 * description: 8.8_接口初始化规则与类加载器准备阶段和初始化阶段的重要意义分析(8)
 *
 *
 * author: chenshoujiang
 * date: 2020/2/20
 */
public class SingletonActiveUseDemo {

    public static void main(String[] args) {
        Single single = Single.getInstance();

        /**
         * 输出结果
         *  1
         *  1
         */
//        System.out.println(Single.counter1);
//        System.out.println(Single.counter2);


        /**
         * 输出结果：
         *  1
         *  0
         */
        Single2 single2 = Single2.getInstance();
        System.out.println(Single2.counter1);
        System.out.println(Single2.counter2);

        /**
         * 上面两个的结果为什么会不一样
         *
         *  原因： 在准备阶段会赋予初值，所有counter2 在准备阶段的时候已经是0了。
         *  然后初始化， 先调用构造函数，counter2 = 1了，然后在网下继续执行，执行到public static int counter2 = 0; 又赋值给了0
         *
         */
    }
}

class Single {
    public static int counter1;

    public static int counter2 = 0;

    private static Single single = new Single();

    private Single() {
        counter1 ++;
        counter2 ++;
    }

    public static Single getInstance() {
        return single;
    }
}
class Single2 {
    public static int counter1;

    private static Single2 single = new Single2();

    private Single2() {
        counter1 ++;
        counter2 ++;
    }

    public static int counter2 = 0;

    public static Single2 getInstance() {
        return single;
    }
}

