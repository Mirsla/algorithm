package com.alex.jdk8;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test = new FunctionTest2();

        System.out.println(test.compute(2, value ->value * 3, value -> value * value));
        System.out.println(test.compute2(2, value ->value * 3, value -> value * value));

        System.out.println(Predicate.isEqual("test").test("test"));


    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }
    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }
}
