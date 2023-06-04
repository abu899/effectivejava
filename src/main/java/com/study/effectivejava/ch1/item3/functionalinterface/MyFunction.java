package com.study.effectivejava.ch1.item3.functionalinterface;

// @FunctionalInterface annotation 이 없어도 인스턴스 메서드하가 하나만 있으면 함수형 인터페이스로 인식
@FunctionalInterface
public interface MyFunction {

    String valueOf(Integer integer);

    static String hello() {
        return "hello";
    }
}
