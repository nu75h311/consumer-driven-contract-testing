package com.nu75h311.creditcardservice.controller;

import lombok.Getter;

@Getter
public class ApplyForCreditCardResponse {

    private final Status status;
    private final String uuid;

    public ApplyForCreditCardResponse(final Status status, final String uuid) {
        this.status = status;
        this.uuid = uuid;
    }

    public enum Status {
        GRANTED, DENIED
    }
}
