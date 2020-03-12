package com.nu75h311.creditcheckservice.messaging;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.nu75h311.creditcheckservice.gateway.CreditCheckResponse;

@Component
public class CreditScoreProducer {

    private final Source source;

    public CreditScoreProducer(Source source) {
        this.source = source;
    }

    public void publishScore(CreditCheckResponse creditCheckResponse) {
        source.output().send(MessageBuilder.withPayload(creditCheckResponse).build());
    }
}
