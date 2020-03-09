package com.nu75h311.creditcardservice;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc // instantiates a MockMvc bean configured to point to a mock web environment
@AutoConfigureStubRunner(ids = "com.nu75h311:creditcheckservice:+:stubs:8080", stubsMode = StubRunnerProperties.StubsMode.LOCAL) // boot WireMock and import the stubs
class CreditCardServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_grant_application_when_credit_score_is_high() throws Exception {
        mockMvc.perform(
                post("/credit-card-applications")
                        .contentType(APPLICATION_JSON)
                        .content("{" +
                                "\"citizenNumber\": 1234," +
                                "\"cardType\": \"GOLD\"" +
                                "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "\"status\":\"GRANTED\"" +
                        "}"))
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }

}
