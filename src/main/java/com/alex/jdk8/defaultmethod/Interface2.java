package com.alex.jdk8.defaultmethod;

public interface Interface2 {

    default void method() {
        System.out.println("Interface1");
    }
}
