package com.alex.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());

        collect.forEach(System.out::println);

        //  针对Steam 里面的元素，每个元素都是List等集合的操作，使用flatMap
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        listStream.flatMap(thisList -> thisList.stream()).map(item -> item * item).forEach(System.out::println);
    }

}
