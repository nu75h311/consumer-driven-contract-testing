package com.nu75h311.creditcheckservice;

import static com.nu75h311.creditcheckservice.gateway.CreditCheckResponse.Score.HIGH;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import com.nu75h311.creditcheckservice.gateway.CreditCheckResponse;
import com.nu75h311.creditcheckservice.messaging.CreditScoreProducer;

@RunWith(SpringRunner.class) // somehow this is required
@SpringBootTest(classes = CreditCheckServiceApplication.class)
@AutoConfigureMessageVerifier // so the Verifier classes injected into the generated tests are instantiated
public class BaseContractTestMessaging {

    @Autowired
    private CreditScoreProducer creditScoreProducer;

    public void scoreOfHigh() {

        final String uuid = "67bb6459-b718-4cbd-b015-6fc80aef7d31";

        creditScoreProducer.publishScore(new CreditCheckResponse(HIGH, uuid));
    }
}
