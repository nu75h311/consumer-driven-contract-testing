package com.nu75h311.creditcheckservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCheckController {

    private final CreditCheckService creditCheckService;

    public CreditCheckController(final CreditCheckService creditCheckService) {
        this.creditCheckService = creditCheckService;
    }

    @PostMapping("/credit-scores")
    public CreditCheckResponse doCreditCheck(@RequestBody CreditCheckRequest creditCheckRequest) {
        return creditCheckService.doCreditCheck(creditCheckRequest.getCitizenNumber());
    }
}
