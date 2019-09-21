package com.alex.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        list.forEach(item -> System.out.println(item));

        list.forEach(System.out::println);
    }
}
