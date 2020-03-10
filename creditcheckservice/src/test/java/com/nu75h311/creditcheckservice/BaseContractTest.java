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
        when(creditCheckService.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(HIGH));
        when(creditCheckService.doCreditCheck(4444)).thenReturn(new CreditCheckResponse(LOW));
        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(creditCheckService));
    }
}
