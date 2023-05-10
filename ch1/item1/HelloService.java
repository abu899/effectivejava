package com.study.effectivejava.ch1.item1;

public interface HelloService {

    String hello();

    static HelloService of(String lang) {
        if (lang.equals("ko")) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }

    static String hi() {
        prepareMessage();
        return "hi";
    }

    static private void prepareMessage() {
    }

    static String hi1() {
        prepareMessage();
        return "hi";
    }

    static String hi2() {
        prepareMessage();
        return "hi";
    }

    default String bye() {
        return "bye";
    }
}
