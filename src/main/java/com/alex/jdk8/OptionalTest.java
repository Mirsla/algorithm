package com.alex.jdk8;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
//        Optional<String> optional = Optional.of("xxxxxx");


        // 不推荐的方式
//        if(optional.isPresent()) {
//            System.out.println(optional.get());
//        }
//
//        // 推荐的使用方式
//        optional.ifPresent(item -> System.out.println(item));


        Optional<String> optional = Optional.empty();

        System.out.println(optional.orElse("world"));
        System.out.println(optional.orElseGet(() -> "xxxxx"));
    }
}
