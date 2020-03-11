package com.nu75h311.creditcardservice.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyForCreditCardRequest {
    private int citizenNumber;
    private CardType cardType;

    public enum CardType {
        GOLD
    }
}
