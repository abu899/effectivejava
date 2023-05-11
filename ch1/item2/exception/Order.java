package com.study.effectivejava.ch1.item2.exception;

import java.time.LocalDate;

public class Order {

    public void updateDeliveryDate(LocalDate deliveryDate) {
        if (deliveryDate == null) {
            throw new NullPointerException("deliveryDate can't be null");
        }

        if (deliveryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("deliveryDate can't be earlier than " + LocalDate.now());
        }
    }

}
