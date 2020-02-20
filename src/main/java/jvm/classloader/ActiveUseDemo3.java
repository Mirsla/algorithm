package jvm.classloader;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.UUID;

/**
 * description: 主动使用的Demo3
 *
 *  当一个常量的值并非编译期间就可以确定的，那么其值就不会放到调用类的常量池中
 *  这是程序运行时，会导致主动使用这个常量的所在类，显然会导致这个类被初始化。
 *
 * author: chenshoujiang
 * date: 2020/2/20
 */
public class ActiveUseDemo3 {

    public static void main(String[] args) {

        /**
         * 执行结果
         *
         * parent3 init
         * 552a27f9-9a5c-4ac1-bea5-ad475b1ede77
         *
         * 为什么UUID会输出来？
         *
         */
        System.out.println(Parent3.str);
    }
}


class Parent3 {
    static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("parent3 init");
    }
}