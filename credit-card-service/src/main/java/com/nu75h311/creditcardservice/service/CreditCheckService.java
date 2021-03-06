package com.nu75h311.creditcardservice.service;

import static com.nu75h311.creditcardservice.controller.ApplyForCreditCardRequest.CardType.GOLD;
import static com.nu75h311.creditcardservice.controller.ApplyForCreditCardResponse.Status.DENIED;
import static com.nu75h311.creditcardservice.controller.ApplyForCreditCardResponse.Status.GRANTED;
import static com.nu75h311.creditcardservice.gateway.CreditCheckResponse.Score.HIGH;
import static com.nu75h311.creditcardservice.gateway.CreditCheckResponse.Score.LOW;

import org.springframework.stereotype.Component;

import com.nu75h311.creditcardservice.controller.ApplyForCreditCardRequest;
import com.nu75h311.creditcardservice.controller.ApplyForCreditCardResponse;
import com.nu75h311.creditcardservice.gateway.CreditCheckGateway;
import com.nu75h311.creditcardservice.gateway.CreditCheckResponse;

@Component
public class CreditCheckService {

    private final CreditCheckGateway creditCheckGateway;

    public CreditCheckService(CreditCheckGateway creditCheckGateway) {
        this.creditCheckGateway = creditCheckGateway;
    }

    public ApplyForCreditCardResponse doCheckForCitizen(ApplyForCreditCardRequest applyForCreditCardRequest) {

        final CreditCheckResponse creditCheckResponse = creditCheckGateway.doCreditCheckForCitizen(applyForCreditCardRequest.getCitizenNumber());

        final CreditCheckResponse.Score score = creditCheckResponse.getScore();
        final String uuid = creditCheckResponse.getUuid();

        if (applyForCreditCardRequest.getCardType() == GOLD) {
            if (score == HIGH) {
                return new ApplyForCreditCardResponse(GRANTED, uuid);
            } else if (score == LOW) {
                return new ApplyForCreditCardResponse(DENIED, uuid);
            }
        }

        throw new RuntimeException("Card and score not yet implemented");
    }
}
