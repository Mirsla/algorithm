package com.alex.jdk8.stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");

        // 转换为数组
//        String[] strings = stream.toArray(length -> new String[length]);
//        Arrays.asList(strings).forEach(System.out::println);

        // 转换为List, 下面有所有转换的不同实现
//        List<String> collect = stream.collect(Collectors.toList());

//        ArrayList<String> collect1 = stream.collect(ArrayList::new, List::add, ArrayList::addAll);
//        collect1.forEach(System.out::println);

//        HashSet<String> collect = stream.collect(HashSet::new, HashSet::add, HashSet::addAll);
//
//        collect.forEach(System.out::println);

        LinkedList<String> collect1 = stream.collect(Collectors.toCollection(LinkedList::new));
    }
}
