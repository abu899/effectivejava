package com.study.effectivejava.ch4.item21;

public interface MarkerInterface {

    default void hello() {
        System.out.println("hello interface");
    }

}
