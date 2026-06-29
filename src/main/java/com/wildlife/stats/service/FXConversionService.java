package com.wildlife.stats.service;

import com.wildlife.stats.dto.FXRatesDTO;
import com.wildlife.stats.exceptions.QueryObjectNotFoundException;
import com.wildlife.stats.repository.FXRateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Service
public class FXConversionService {

    private final FXRateRepository fxRateRepo;

    @Autowired
    public FXConversionService(FXRateRepository fxRateRepo) {
        this.fxRateRepo = fxRateRepo;
    }

    @Transactional
    public FXRatesDTO getFXRate(BigInteger currencyFromType, BigInteger currencyToType) {
        try {
            return fxRateRepo.getLatestFxRate(currencyFromType, currencyToType);
        } catch (EntityNotFoundException ex) {
            throw new QueryObjectNotFoundException("FXRate entity not found");
        } catch (Exception ex) {
            throw ex;
        }
    }
}
