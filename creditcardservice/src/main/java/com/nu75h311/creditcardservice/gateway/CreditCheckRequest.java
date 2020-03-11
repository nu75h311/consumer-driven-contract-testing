package com.nu75h311.creditcardservice.gateway;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class CreditCheckRequest {

    private final int citizenNumber;
    private final String requestedDate = LocalDate.now().toString();

    public CreditCheckRequest(final int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }
}
