package com.study.effectivejava.ch1.item3.field;

import java.io.Serializable;

// 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
public class Elvis implements IElvis, Serializable {

    /**
     * 싱글턴 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();
    private static boolean created;

    private Elvis() {
        if (created) {
            throw new UnsupportedOperationException("can't be created by constructor.");
        }
        created = true;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public void sing() {
        System.out.println("I'll have a blue~ Christmas without you~");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    // 역직렬화시, 이 메서드를 사용하게 됨.
    // 오버라이딩이 아니지만 오버라이딩처럼 동작
    private Object readResolve() {
        return INSTANCE;
    }

}
