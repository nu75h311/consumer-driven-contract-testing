package com.nu75h311.creditcardservice.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import com.nu75h311.creditcardservice.gateway.CreditCheckResponse;
import com.nu75h311.creditcardservice.repository.CreditScoreRepository;

@Component
public class CreditScoreListener { // consumes messages from the credit scores queue

    private final CreditScoreRepository creditScoreRepository;

    public CreditScoreListener(final CreditScoreRepository creditScoreRepository) {
        this.creditScoreRepository = creditScoreRepository;
    }

    @StreamListener(Sink.INPUT) // calls this method when a message is received
    public void receiveScore(CreditCheckResponse creditCheckResponse) {
        creditScoreRepository.save(creditCheckResponse.getUuid(), creditCheckResponse.getScore());
    }
}
