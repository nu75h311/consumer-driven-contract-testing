package com.nu75h311.creditcheckservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCheckResponse {

    private Score score;

    public CreditCheckResponse(final Score score) {
        this.score = score;
    }

    public enum Score {
        HIGH
    }
}
