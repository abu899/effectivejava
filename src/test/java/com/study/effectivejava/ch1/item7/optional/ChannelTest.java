package com.study.effectivejava.ch1.item7.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class ChannelTest {

    @Test
    void npe() {
        Channel channel = new Channel();
        Optional<MemberShip> optional = channel.defaultMemberShip();
        optional.ifPresent(MemberShip::hello);
    }

}