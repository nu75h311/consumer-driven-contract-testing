package com.nu75h311.creditcheckservice.service;

import org.springframework.stereotype.Component;

import com.nu75h311.creditcheckservice.gateway.CreditCheckResponse;

@Component
public class CreditCheckService {
    public CreditCheckResponse doCreditCheck(final int citizenNumber) {
        return null; // actual implementation of provider goes here
    }
}
