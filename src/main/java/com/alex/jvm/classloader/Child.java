package com.alex.jvm.classloader;

public class Child extends Parent {

    public static String value2 = "Child";

    static {
        System.out.println("init Child");
    }
}
