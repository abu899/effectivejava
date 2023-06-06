package com.study.effectivejava.ch4.item15.item;

import com.study.effectivejava.ch4.item15.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    MemberService memberService;

    @Test
    void itemTest() {
        ItemService itemService = new ItemService(memberService);
        assertThat(itemService).isNotNull();
        assertThat(itemService.getMemberService()).isNotNull();
        assertThat(itemService.memberService).isNotNull();
    }
}