package com.study.effectivejava.ch1.item8.outerclass;

import java.lang.reflect.Field;

public class OuterClass {

    private void hi() {

    }

    // outer class 에 굉장히 종속적인 관계
    class InnerClass {
        public void hello() {
            OuterClass.this.hi();
        }

    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        System.out.println(innerClass);

        outerClass.printFiled();
    }

    private void printFiled() {
        Field[] declaredFields = InnerClass.class.getDeclaredFields();
        for(Field field : declaredFields) {
            System.out.println("field type:" + field.getType());
            System.out.println("field name:" + field.getName());
        }
    }
}
