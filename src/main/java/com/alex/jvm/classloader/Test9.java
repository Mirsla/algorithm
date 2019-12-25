package com.alex.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Test9 {

    public static void main(String[] args) throws IOException {
        // 获取系统类加载器
//        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//
//        // 打印这个类使用到的所有类加载器
//        System.out.println(systemClassLoader);
//
//        while (null != systemClassLoader) {
//            systemClassLoader = systemClassLoader.getParent();
//
//            System.out.println(systemClassLoader);
//        }


        // 获取当前正在执行的线程对象的类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        // 获取系统资源
        String resourceName = "target/classes/com/alex/jvm/classloader/Test9.class";
        Enumeration<URL> resources = contextClassLoader.getResources(resourceName);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }
    }
}
