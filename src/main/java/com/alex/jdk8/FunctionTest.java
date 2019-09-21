package com.alex.jdk8;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();

        System.out.println(test.compute(2, value -> 2 * value));

        System.out.println(test.convert(2, value -> value + " hello world"));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);

        return result;
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }
}
