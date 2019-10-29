package com.alex.jvm.classloader;

class FinalTest{
    public static final int x = 3;

    static {
        System.out.println("FinalTest");
    }
}

public class Test8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
