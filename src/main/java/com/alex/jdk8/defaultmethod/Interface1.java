package com.alex.jdk8.defaultmethod;

public interface Interface1 {

    default void method() {
        System.out.println("Interface1");
    }
}
