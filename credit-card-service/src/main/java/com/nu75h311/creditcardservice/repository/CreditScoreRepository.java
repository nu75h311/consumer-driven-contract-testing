package com.nu75h311.creditcardservice.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.nu75h311.creditcardservice.gateway.CreditCheckResponse;

@Component
public class CreditScoreRepository {

    // instead of an actual database
    private final Map<String, CreditCheckResponse.Score> creditScores = new HashMap<>();

    public CreditCheckResponse.Score getScore(final UUID uuid) {
        return creditScores.get(uuid.toString());
    }

    public void save(final String uuid, final CreditCheckResponse.Score score) {
        creditScores.put(uuid, score);
    }
}
