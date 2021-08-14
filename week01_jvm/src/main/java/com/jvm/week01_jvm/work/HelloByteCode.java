package com.jvm.week01_jvm.work;

/**
 * java 字节码
 */
public class HelloByteCode {
    static Integer s = 2;
    public static void main(String[] args) {
        String s = "abc";
        int dd = 100;
        int i = 1;
        i = i++;
        System.out.println(2);
        HelloByteCode helloByteCode = new HelloByteCode();
    }
}
