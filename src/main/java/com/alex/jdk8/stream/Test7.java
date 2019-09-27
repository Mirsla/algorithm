package com.alex.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试流的执行顺序及效果
 */
public class Test7 {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("hello", "world", "hello world");
//
//        // stream 流中有一个容器，会将所有的命令按照顺序放入这个容器中，等遇到及早操作的时候，按照顺序统一操作，也就是也是执行一次
//        list.stream().map(item -> {
//            String result = item.toUpperCase();
//            System.out.println("test");
//            return result;
//        }).forEach(System.out::println);

        /**
         * 下面的程序执行结果有点奇怪，需要注意
         *      只是打印出来了0，1 但是程序并没有终止运行，还是在继续运行中
         *
         *      执行顺序是： iterate会一直创建数字  0，1，0，1，0，1，0，1......
         *                  ->  distinct 然后去重 之后只有 0，1
         *                  -> limit 需要6 个所以会执行卡在这个地方，
         *
         *                  替换limit和distinct的顺序即可，需要注意的是执行的顺序问题
         */
        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
    }
}
