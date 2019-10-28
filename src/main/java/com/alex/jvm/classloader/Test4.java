package com.alex.jvm.classloader;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组实例来说，其类型是有JVM在运行期动态生成的，表示为：[Lcom.alex.jvm.classloader.Parent4 这种形式。动态生成的类型，其父类型就是Object
 *
 * 对于数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度后的类型
 */
public class Test4 {

    public static void main(String[] args) {
        Parent4[] parent4s = new Parent4[1];
        List<Parent4> list = new ArrayList<>();
        System.out.println(parent4s.getClass());
    }
}

class Parent4{
    static {
        System.out.println("array init");
    }
}
