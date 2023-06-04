package com.study.effectivejava.ch1.item6;

public class Strings {

    public static void main(String[] args) {
        String hello = "hello";

        // 이 경우 새로운 인스턴스가 생성됨.
        String hello2 = new String("hello");

        String hello3 = "hello";

        System.out.println(hello == hello2);
        System.out.println(hello.equals(hello2));
        System.out.println(hello == hello3);
        System.out.println(hello.equals(hello3));
    }
}
