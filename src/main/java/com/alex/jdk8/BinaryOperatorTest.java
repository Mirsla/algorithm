package com.alex.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperatorTest test = new BinaryOperatorTest();

        System.out.println(test.compute(10,20, (a, b) -> a> b? a: b));
        System.out.println(test.compute(10,20, (a, b) -> a + b));
        System.out.println(test.compute(10,20, (a, b) -> a - b));
        System.out.println(test.compute(10,20, (a, b) -> a * b));


        System.out.println(BinaryOperator.maxBy((a, b) -> 1).apply(2, 3));

        System.out.println("-----------------------------------------");

        System.out.println(test.getMin(1, 2, (a, b) -> 0));
        System.out.println(test.getMin("hello123", "world", (a, b) -> a.length() - b.length()));
    }

    public int compute(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    public <T> T getMin (T t1, T t2, Comparator<T> comparator) {
        return BinaryOperator.minBy(comparator).apply(t1, t2);
    }

}
