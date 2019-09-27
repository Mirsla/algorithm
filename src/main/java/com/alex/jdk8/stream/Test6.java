package com.alex.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class Test6 {

    public static void main(String[] args) {
//        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);
//        generate.findFirst().ifPresent(System.out::println);

        // skip 忽略多少个元素
//        System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum());

        // 如果说要对上面的过滤条件之后的数据 求和，求最大值，最小值的操作，都需要，可以按照下面的方式来处理
        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();

        long count = intSummaryStatistics.getCount();
        System.out.println(count);
        long sum = intSummaryStatistics.getSum();
        System.out.println(sum);
        int max = intSummaryStatistics.getMax();
        System.out.println(max);
    }
}
