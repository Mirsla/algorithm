package com.alex.jdk8.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest2 {

    public static void main(String[] args) {
        Student student = new Student("zjangsan", 10);
        Student student1 = new Student("lisi", 30);
        Student student2 = new Student("wangwu", 20);
        Student student3 = new Student("zhaosi", 40);

        List<Student> list = Arrays.asList(student, student1, student2, student3);

//        list.sort((s1, s2) -> Student.compareStudentByScore(s1, s2));
//
//        list.forEach(System.out::println);
//          第一种
//        list.sort(Student::compareStudentByName);
//
//        list.forEach(System.out::println);

        // 第二种
//        StudentComparator comparator = new StudentComparator();
//
//        list.sort((s1, s2) -> comparator.compareStudentByScore(s1, s2));
//
//        list.forEach(System.out::println);
//
//        list.sort(comparator::compareStudentByScore);


//        list.sort(Student::compareByScore);
//
//        list.forEach(System.out::println);

        // 第三种
//        List<String> cities = Arrays.asList("chengdu","beijing","chongqing", "shanghai","xizang");
//        Collections.sort(cities, String::compareToIgnoreCase);
//        cities.forEach(System.out::println);

        //第四种
        MethodReferenceTest2 test = new MethodReferenceTest2();
        System.out.println(test.getString(String::new));
        System.out.println(test.getString2("hhhh",String::new));

    }

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }
}
