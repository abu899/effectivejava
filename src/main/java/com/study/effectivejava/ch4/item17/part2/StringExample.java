package com.study.effectivejava.ch4.item17.part2;

public class StringExample {

    public static void main(String[] args) {
        String name = "whiteship";

        StringBuilder nameBuilder = new StringBuilder(name);
        nameBuilder.append("keesun");
    }
}
