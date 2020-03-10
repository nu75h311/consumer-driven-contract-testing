package com.nu75h311.creditcheckservice;

import static com.nu75h311.creditcheckservice.CreditCheckResponse.Score.HIGH;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class BaseContractTest {

    @Before
    public void setup() {
        final CreditCheckService creditCheckService = mock(CreditCheckService.class);
        when(creditCheckService.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(HIGH));
        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(creditCheckService));
    }
}
