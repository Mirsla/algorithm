package com.alex.jdk8;


@FunctionalInterface
interface MyInterface {
    void test();

}

/**
 * lambda test 1
 */
public class LambdaTest1 {

    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        LambdaTest1 test1 = new LambdaTest1();
        test1.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("匿名内部类");
            }
        });

        System.out.println("---------------------------");
        test1.myTest(() -> {
            System.out.println("lambda 表达式");
        });

        System.out.println("------------------------");

        MyInterface myInterface = () -> {
            System.out.println("构造方法初始化lambda");
        };

        System.out.println("-------------------------");
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);

        System.out.println("-------------------------");

        myInterface.test();
    }
}
