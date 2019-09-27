package com.alex.jdk8.defaultmethod;

public class Test implements Interface1, Interface2{

    @Override
    public void method() {
        Interface1.super.method();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.method();
    }
}
