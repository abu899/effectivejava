package com.study.effectivejava.ch4.item15.item;

import com.study.effectivejava.ch4.item15.member.MemberService;

public class ItemService {

//    private MemberService memberService;

    MemberService memberService;
    boolean onSale;

    protected int saleRate;

    public ItemService(MemberService memberService) {
        if (memberService == null) {
            throw new IllegalArgumentException("MemberService should not be null.");
        }

        this.memberService = memberService;
    }

    MemberService getMemberService() {
        return memberService;
    }
}
