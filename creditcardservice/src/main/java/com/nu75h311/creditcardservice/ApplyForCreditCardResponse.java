package com.nu75h311.creditcardservice;

import lombok.Getter;

@Getter
public class ApplyForCreditCardResponse {

    private final Status status;

    public ApplyForCreditCardResponse(final Status status) {
        this.status = status;
    }

    public enum Status {
        GRANTED;
    }
}
