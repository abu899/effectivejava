package com.study.effectivejava.ch1.item1;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumSet;
import java.util.Set;

public class Product {
    public static void main(String[] args) {
        Settings settings1 = Settings.getInstance();
        Settings settings2 = Settings.getInstance();

        System.out.println(settings1);
        System.out.println(settings2);

        // 위와 마찬가지로 동일한 객체를 리턴
        Boolean.valueOf(false);
        EnumSet.allOf(Difficulty.class);
    }
}
