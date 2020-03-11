package com.nu75h311.creditcheckservice.gateway;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCheckResponse {

    private final String uuid = UUID.randomUUID().toString();
    private Score score;

    public CreditCheckResponse(final Score score) {
        this.score = score;
    }

    public enum Score {
        HIGH, LOW
    }
}
