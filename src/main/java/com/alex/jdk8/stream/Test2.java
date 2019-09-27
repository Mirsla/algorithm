package com.alex.jdk8.stream;

import java.util.stream.IntStream;

/**
 *  关于IntStream ，LongStream的简单使用
 */
public class Test2 {

    public static void main(String[] args) {
        IntStream.of(new int[]{5,6,7}).forEach(System.out::print);
        System.out.println("-------------------------");

        IntStream.range(3, 7).forEach(System.out::print);
        System.out.println("-------------------------");

        IntStream.rangeClosed(3, 7).forEach(System.out::println);
    }
}
