package com.study.effectivejava.ch1.item8.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {

    public static void main(String[] args) throws InterruptedException {
        Cleaner cleaner = Cleaner.create();

        List<Object> resourceToCleanUp = new ArrayList<>();
        BigObject bigObject = new BigObject(resourceToCleanUp); // 객체 사용
        // ...
        cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp)); // 자원 반납 요청

        bigObject = null;
        System.gc();
        Thread.sleep(3000L);
    }

}
