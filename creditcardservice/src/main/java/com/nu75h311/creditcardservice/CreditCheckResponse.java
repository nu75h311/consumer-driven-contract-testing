package com.nu75h311.creditcardservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCheckResponse {

    private Score score;

    public enum Score {
        HIGH
    }
}
