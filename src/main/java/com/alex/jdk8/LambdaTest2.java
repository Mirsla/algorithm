package com.alex.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTest2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world" ,"hello world");
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
