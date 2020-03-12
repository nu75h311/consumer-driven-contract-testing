package com.nu75h311.creditcardservice;

import static com.nu75h311.creditcardservice.gateway.CreditCheckResponse.Score.HIGH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringSummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import com.nu75h311.creditcardservice.gateway.CreditCheckResponse;
import com.nu75h311.creditcardservice.gateway.CreditCheckResponse.Score;
import com.nu75h311.creditcardservice.repository.CreditScoreRepository;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMockMvc // instantiates a MockMvc bean configured to point to a mock web environment
@AutoConfigureStubRunner(ids = "com.nu75h311:credit-check-service:+:stubs:8080",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL) // boot WireMock and import the stubs
class CreditCardServiceApplicationMessagingTests {

    @Autowired
    private StubTrigger stubTrigger; // so a message can be dispatched to the consumer

    @Autowired
    private CreditScoreRepository creditScoreRepository;

    @Test
    public void should_store_results_of_a_credit_check(){
        final UUID uuid = UUID.fromString("67bb6459-b718-4cbd-b015-6fc80aef7d31");

        stubTrigger.trigger("score_of_high");

        final Score score = creditScoreRepository.getScore(uuid);

        assertThat(score).isEqualTo(HIGH);
    }
}
