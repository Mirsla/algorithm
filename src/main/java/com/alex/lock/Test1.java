package com.alex.lock;

import com.alex.jvm.classloader.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * description: 查看对象头信息，对象到底有多少个字节组成的
 * 对象的组成为
 * 对象头 -- 固定 （12 byte）
 * 实例数据 -- 不固定(可能有，可能没有)
 * 数据对齐 -- 不固定 (可能有，可能没有，这个是不够凑成8的倍数的时候需要这个补充)
 *
 *
 *
 * author: chenshoujiang
 * date: 2020/1/9
 */
public class Test1 {

   static Test2 l = new Test2();

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();

        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }
}
