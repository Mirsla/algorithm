package com.alex.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 有一个整型的集合，现在需要将整型集合的所有元素 * 2， 然后在求和
 */
public class Test3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 6);

        System.out.println(list.stream().map(item -> item * 2).mapToInt(item -> item).sum());

        System.out.println(list.stream().map(item -> item * 2).reduce(0, Integer::sum));
    }
}
