package com.alex.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        PredicateTest test = new PredicateTest();

        test.conditionFilter(list, item -> item % 2 == 0);
    }

    /**
     * 条件过滤器
     */
    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
//        list.stream().filter(item -> predicate.test(item)).collect(Collectors.toList());
        for (Integer integer: list) {
            if(predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        for (Integer integer: list) {
            if(predicate1.and(predicate2).test(integer)) {
                System.out.println(integer);
            }
        }
    }
}
