package com.study.effectivejava.ch5.item28.erasure;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("brett");
        String name = names.get(0);
        System.out.println(name);

        // 컴파일된 코드
//        List names = new ArrayList();
//        names.add("brett");
//        Object o = names.get(0);
//        String name = (String) o;
    }

}
