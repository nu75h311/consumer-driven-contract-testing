package com.nu75h311.creditcardservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController // handles requests
public class CreditCardApplicationsController {

    private final RestTemplate restTemplate;

    public CreditCardApplicationsController(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/credit-card-applications")
    public ApplyForCreditCardResponse applyForCreditCard(final ApplyForCreditCardRequest applyForCreditCardRequest) {
        final int citizenNumber = applyForCreditCardRequest.getCitizenNumber();
        final CreditCheckResponse creditCheckResponse = restTemplate.postForObject("http://localhost:8080/credit-scores",
                new CreditCheckRequest(citizenNumber),
                CreditCheckResponse.class);
        if (creditCheckResponse.getScore() == CreditCheckResponse.Score.HIGH &&
                applyForCreditCardRequest.getCardType() == ApplyForCreditCardRequest.CardType.GOLD) {
            return new ApplyForCreditCardResponse(ApplyForCreditCardResponse.Status.GRANTED);
        }
        throw new RuntimeException("Card and score not yet implemented.");
    }
}
