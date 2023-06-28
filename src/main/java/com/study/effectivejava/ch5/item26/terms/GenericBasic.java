package com.study.effectivejava.ch5.item26.terms;

import java.util.ArrayList;
import java.util.List;

public class GenericBasic {

    public static void main(String[] args) {
        // Generic 사용하기 전
        usingRawType();
        // Generic 등장 이후
        usingGenericType();

    }

    private static void usingRawType() {
        List numbers = new ArrayList();
        numbers.add(10);
        numbers.add("whiteship");

        for (Object number: numbers) {
            System.out.println((Integer)number);
        }
    }

    private static void usingGenericType() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
//        numbers.add("aaa"); // 컴파일 타임에 잘못 들어가는 걸 찾을 수 있음

        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
