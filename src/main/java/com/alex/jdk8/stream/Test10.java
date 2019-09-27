package com.alex.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 将下面的字符串数组中的元素按照空格分隔，然后去重显示
 */
public class Test10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");

        /**
         * flatMap(Arrays::stream) 将 Stream<String []> -> 转换为 Stream<String>
         */
        list.stream().map(item ->  item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }
}
