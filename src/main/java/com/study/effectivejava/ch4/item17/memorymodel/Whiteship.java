package com.study.effectivejava.ch4.item17.memorymodel;

public class Whiteship {

    private final int x;

    private final int y;

    public Whiteship() {
        this.x = 1;
        this.y = 2;
    }

    public static void main(String[] args) {
        // final 을 사용하면 아래와 같은 문제가 발생하지 않음
        // Object w = new Whiteship()
        // whiteship = w -> 이렇게 실행 될 수도 있음(불완전한 초기화)
        // w.x = 1
        // w.y = 2

        Whiteship whiteship = new Whiteship();
    }


}
