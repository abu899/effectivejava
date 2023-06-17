package com.study.effectivejava.ch4.item21;

public class SubClass extends SuperClass implements MarkerInterface {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.hello(); // 당연히 구체적인 Class(SuperClass) 에 있는게 동작해야 맞음 -> 하지만 SuperClass 내 hello 는 private
    }
}
