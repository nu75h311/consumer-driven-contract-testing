package com.nu75h311.creditcheckservice.messaging;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import com.nu75h311.creditcheckservice.gateway.CreditCheckRequest;
import com.nu75h311.creditcheckservice.gateway.CreditCheckResponse;
import com.nu75h311.creditcheckservice.service.CreditCheckService;

@Component
public class CreditScoreConsumer {

    private final CreditCheckService creditCheckService;
    private final CreditScoreProducer creditScoreProducer;

    public CreditScoreConsumer(final CreditCheckService creditCheckService, CreditScoreProducer creditScoreProducer) {
        this.creditCheckService = creditCheckService;
        this.creditScoreProducer = creditScoreProducer;
    }

    @StreamListener(Sink.INPUT)
    public void consume(CreditCheckRequest creditCheckRequest) {
        final CreditCheckResponse creditCheckResponse = creditCheckService.doCreditCheck(creditCheckRequest.getCitizenNumber());
        creditScoreProducer.publishScore(creditCheckResponse);
    }
}
