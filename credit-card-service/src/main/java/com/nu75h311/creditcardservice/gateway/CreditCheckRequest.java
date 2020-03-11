package com.nu75h311.creditcardservice.gateway;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;

@Getter
public class CreditCheckRequest {

    private final int citizenNumber;
    private final String requestedDate = LocalDate.now().toString();
    private final String uuid = UUID.randomUUID().toString();

    public CreditCheckRequest(final int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }
}
