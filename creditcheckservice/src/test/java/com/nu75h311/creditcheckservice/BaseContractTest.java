package com.nu75h311.creditcheckservice;

import static com.nu75h311.creditcheckservice.gateway.CreditCheckResponse.Score.HIGH;
import static com.nu75h311.creditcheckservice.gateway.CreditCheckResponse.Score.LOW;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;

import com.nu75h311.creditcheckservice.controller.CreditCheckController;
import com.nu75h311.creditcheckservice.gateway.CreditCheckResponse;
import com.nu75h311.creditcheckservice.service.CreditCheckService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class BaseContractTest {

    @Before
    public void setup() {
        final CreditCheckService creditCheckService = mock(CreditCheckService.class);
        when(creditCheckService.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(HIGH, "66ce29f3-ae87-4097-94e8-60b3b10c3855"));
        when(creditCheckService.doCreditCheck(4444)).thenReturn(new CreditCheckResponse(LOW, "66ce29f3-ae87-4097-94e8-60b3b10c3855"));
        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(creditCheckService));
    }
}
