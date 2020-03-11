package com.nu75h311.creditcheckservice.gateway;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCheckResponse {

    private String uuid;
    private Score score;

    public CreditCheckResponse(final Score score, final String uuid) {
        this.uuid = uuid;
        this.score = score;
    }

    public enum Score {
        HIGH, LOW
    }
}
