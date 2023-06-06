package com.study.effectivejava.ch4.item15.member;

import java.util.Arrays;

// package-private class
// 구현체이며 밖에서 접근해서 사용하진 않을 거니까
class DefaultMemberService implements MemberService {

    private String name;

    // 외부 인스턴스를 참조하지 않고 관계가 없음
    // 즉 독립적인 존재
    private static class PrivateStaticClass {

    }

    // 외부 인스턴스(DefaultMemberService) 를 항상 참조
    private class PrivateClass {
        void print() {
            // 인스턴스를 참조하기에 내부 필드에 접근 가능
            System.out.println("name = " + name);
        }
    }

    public static void main(String[] args) {
        Arrays.stream(PrivateClass.class.getDeclaredFields()).forEach(System.out::println);
    }

}
