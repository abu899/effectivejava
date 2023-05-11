package com.study.effectivejava.ch1.item2.varargs;

import java.util.Arrays;

public class VarargsSamples {

    public void printNumbers(int... numbers) {
        System.out.println(numbers.getClass().getCanonicalName()); // 어떤 타입인지
        System.out.println(numbers.getClass().getComponentType()); // 배열이 갖는 타입
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static void main(String[] args) {
        VarargsSamples samples = new VarargsSamples();
        samples.printNumbers(1, 20, 20, 39, 59);
    }
}
