package com.study.effectivejava.ch4.item20.templatemethod;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Plus("number.txt");
        System.out.println(fileProcessor.process());
    }
}
