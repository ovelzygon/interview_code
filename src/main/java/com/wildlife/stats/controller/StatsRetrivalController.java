package com.wildlife.stats.controller;

import com.wildlife.stats.dto.DeclinedPopulationDTO;
import com.wildlife.stats.service.FXConversionService;
import com.wildlife.stats.service.PopulationStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class StatsRetrivalController {

    @Autowired
    private FXConversionService fxConversionService;

    @Autowired
    private PopulationStatsService populationStatsService;

    @Autowired
    private ConcurrentHashMap<String, Double> idempotencyCacheFXRates;

    @Autowired
    private ConcurrentHashMap<String, List<DeclinedPopulationDTO>> idempotencyCachePopulation;


    @GetMapping("/latestFXRate")
    public double getLatestFXRate(
                              @RequestParam(value = "currencyFromType") BigInteger currencyFromType,
                              @RequestParam(value = "currencyToType") BigInteger currencyToType,
                              @RequestHeader(value = "X-Idempotency-Key", required = true) String idempotencyKey
    ) {

        //Retrieve from cache if there are quick repeat requests
        double result = idempotencyCacheFXRates.computeIfAbsent(
                idempotencyKey, i -> fxConversionService.getFXRate(currencyFromType, currencyToType).getFxRate());

        return result;
    }


    @GetMapping("/decliningTrend")
    public List<DeclinedPopulationDTO> getDecliningTrend(
            @RequestHeader(value = "X-Idempotency-Key", required = true) String idempotencyKey) {

        List<DeclinedPopulationDTO> speciesNYearList =
                idempotencyCachePopulation.computeIfAbsent(idempotencyKey, i -> populationStatsService.getDecliningTrend());

        return speciesNYearList;
    }

}
