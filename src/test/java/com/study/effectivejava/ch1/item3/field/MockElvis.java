package com.study.effectivejava.ch1.item3.field;

public class MockElvis implements IElvis {
    @Override
    public void leaveTheBuilding() {

    }

    @Override
    public void sing() {
        System.out.println("You ain't nothin' but a hound dog.");
    }
}
