package com.alex.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        Person zhangsan = new Person("zhangsan", 20);
        Person lisi = new Person("lisi", 30);
        Person wangwu = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(zhangsan, lisi, wangwu);
        PersonTest test = new PersonTest();

        test.getPersonByUserName("zhangsan", persons).forEach(person -> System.out.println(person.getUsername()));

        test.getPersonByAge(25, persons).forEach(person -> System.out.println(person.getUsername()));

        test.getPersonByAge(25, persons, (ageOfPerson, personList) -> personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList()))
                .forEach(person -> System.out.println(person.getUsername()));

    }

    public List<Person> getPersonByUserName(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    public List<Person> getPersonByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());

        return biFunction.apply(age, persons);
    }

    public List<Person> getPersonByAge(Integer age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> function) {
        return function.apply(age, persons);
    }
}
