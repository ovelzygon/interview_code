package com.wildlife.stats.repository;

import com.wildlife.stats.dto.FXRatesDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public class FXRateRepository {

    @Value("latestFXRateQuery")
    String latestFXRateQuery;

    @PersistenceContext
    private EntityManager entityManager;


    public FXRatesDTO getLatestFxRate(BigInteger currencyFromId, BigInteger currencyToId) {
        Optional<FXRatesDTO> opt = entityManager.createQuery(latestFXRateQuery, FXRatesDTO.class)
                .setParameter("fromId", currencyFromId)
                .setParameter("toId", currencyToId)
                .getResultStream()
                .findFirst();

        return opt.orElse(new FXRatesDTO());
    }

}
