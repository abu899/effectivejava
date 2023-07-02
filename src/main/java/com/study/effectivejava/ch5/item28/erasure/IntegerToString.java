package com.study.effectivejava.ch5.item28.erasure;

import java.util.ArrayList;
import java.util.List;

public class IntegerToString {

    public static void main(String[] args) {
        // 공변
        Object[] anything = new String[10];
        anything[0] = 1; // 개밸적으로 본다면 아무 문제가 없음

        // 불공변
        List<String> names = new ArrayList<>();
//        List<Object> objects = names;


        // 제네릭과 배열을 같이 사용할 수 있다면...
//        List<String>[] stringLists = new ArrayList<String>[1];
//        List<Integer> intList = List.of(42);
//        Object[] objects = stringLists;
//        objects[0] = intList;
//        String s = stringLists[0].get(0);
//        System.out.println(s);
    }
}
