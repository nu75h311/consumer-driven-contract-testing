package com.nu75h311.creditcardservice.gateway;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCheckResponse {

    private Score score;
    private String uuid;

    public enum Score {
        HIGH, LOW
    }
}
