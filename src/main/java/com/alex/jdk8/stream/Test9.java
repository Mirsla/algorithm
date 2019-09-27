package com.alex.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class Test9 {

    public static void main(String[] args) {
        // 找出长度为5的第一个单词并打印出来
        List<String> list = Arrays.asList("hello", "world", "hello world");

//        list.stream().mapToInt(item -> item.length()).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

        // 流的操作是如何执行的可以看下面的例子,  流中也存在短路操作和短路运算的 ，就像java中的 && || 前面满足了，后面的就不会执行
        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }
}
