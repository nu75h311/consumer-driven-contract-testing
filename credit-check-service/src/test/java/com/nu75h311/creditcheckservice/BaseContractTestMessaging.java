package com.nu75h311.creditcheckservice;

import static com.nu75h311.creditcheckservice.gateway.CreditCheckResponse.Score.HIGH;

import javax.annotation.PostConstruct;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.nu75h311.creditcheckservice.gateway.CreditCheckResponse;
import com.nu75h311.creditcheckservice.messaging.CreditScoreProducer;
import com.nu75h311.creditcheckservice.service.CreditCheckService;

@RunWith(SpringRunner.class) // somehow this is required
@SpringBootTest(classes = { CreditCheckServiceApplication.class, BaseContractTestMessaging.TestConfiguration.class })
@AutoConfigureMessageVerifier // so the Verifier classes injected into the generated tests are instantiated
public class BaseContractTestMessaging {

    @Autowired
    private CreditScoreProducer creditScoreProducer;

    @Autowired
    private CreditCheckService creditCheckService;

    public void scoreOfHigh() {

        final String uuid = "67bb6459-b718-4cbd-b015-6fc80aef7d31";

        creditScoreProducer.publishScore(new CreditCheckResponse(HIGH, uuid));
    }

    @PostConstruct
    public void postConstruct() {
        Mockito.when(creditCheckService.doCreditCheck(1234))
                .thenReturn(new CreditCheckResponse(HIGH, "29799ba2-b8db-4a98-8d12-46e09e129122"));
    }

    @Configuration
    public static class TestConfiguration {

        @MockBean
        private CreditCheckService creditCheckService;
    }
}
