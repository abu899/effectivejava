package com.study.effectivejava.ch1.item8.finalizer;

public class FinalizerIsBad {

    @Override
    protected void finalize() throws Throwable {
        System.out.print("");
    }
}
