package com.alex.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流的创建方式
 */
public class Test1 {

    public static void main(String[] args) {
        // 1、
        Stream<String> stream1 = Stream.of("hello", "world");

        //2、
        String[] strings = new String[]{"hello", "world"};
        Stream.of(strings);
        Arrays.stream(strings);

        //3、集合
        List<String> list = Arrays.asList("hello", "world");
        list.stream();
    }

}
