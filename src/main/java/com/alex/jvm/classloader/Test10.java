package com.alex.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test10 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    public Test10(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public Test10(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "Test10{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);

        return this.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try{
            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(name + this.fileExtension);
            baos = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> aClass = classLoader.loadClass("com.alex.jvm.classloader.Test");
        Object o = aClass.newInstance();

        System.out.println(o);
    }

    public static void main(String[] args) throws Exception {
        test(new Test10("TestLoader"));

        // 获取当前正在执行的线程对象的类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
    }
}
