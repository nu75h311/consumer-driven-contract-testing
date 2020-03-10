package com.nu75h311.creditcardservice.gateway;

import lombok.Getter;

@Getter
public class CreditCheckRequest {

    private final int citizenNumber;

    public CreditCheckRequest(final int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }
}