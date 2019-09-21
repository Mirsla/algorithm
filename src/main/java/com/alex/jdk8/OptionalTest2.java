package com.alex.jdk8;

import java.util.*;

public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee1 = new Employee();
        employee.setName("lisi");

        Employee employee2 = new Employee();
        employee.setName("wangwu");

        List<Employee> employees = Arrays.asList(employee, employee1, employee2);
        Company company = new Company();
//        company.setEmployees(employees);

        // 如果Company中的Employee为空，就返回一个空列表，不为空直接返回

        // 传统方式
        if(null == company.getEmployees()) {
            Collections.emptyList();
        } else {
            company.getEmployees();
        }

        // 容器
        Optional<Company> optional = Optional.ofNullable(company);
        List<Employee> employees1 = optional.map(item -> item.getEmployees()).orElseGet(() -> Collections.emptyList());
        System.out.println(employees1);
    }
}
