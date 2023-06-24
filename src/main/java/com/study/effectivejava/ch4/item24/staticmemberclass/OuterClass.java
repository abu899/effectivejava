package com.study.effectivejava.ch4.item24.staticmemberclass;

public class OuterClass {

    private static int number = 10;

    static private class InnerClass {
        void doSomething() {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();

    }
}
