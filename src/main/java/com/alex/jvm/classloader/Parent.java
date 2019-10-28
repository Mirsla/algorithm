package com.alex.jvm.classloader;

public class Parent {

    public static String value = "Parent";

    static {
        System.out.println("init parent");
    }
}
