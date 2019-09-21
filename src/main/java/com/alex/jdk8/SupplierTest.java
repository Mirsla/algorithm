package com.alex.jdk8;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());
    }
}
