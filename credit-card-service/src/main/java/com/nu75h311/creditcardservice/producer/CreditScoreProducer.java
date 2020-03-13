package com.nu75h311.creditcardservice.producer;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.nu75h311.creditcardservice.gateway.CreditCheckRequest;

@Component
public class CreditScoreProducer {

    private final Source source;

    public CreditScoreProducer(final Source source) {
        this.source = source;
    }

    public void requestScore(final CreditCheckRequest creditCheckRequest) {
        source.output().send(MessageBuilder.withPayload(creditCheckRequest).build());
    }
}
