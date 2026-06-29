package com.wildlife.stats.service;

import com.wildlife.stats.dto.DeclinedPopulationDTO;
import com.wildlife.stats.exceptions.QueryObjectNotFoundException;
import com.wildlife.stats.repository.PopulationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PopulationStatsService {

    private final PopulationRepository populationRepo;

    @Autowired
    public PopulationStatsService(PopulationRepository populationRepo) {
        this.populationRepo = populationRepo;
    }

    @Transactional
    public List<DeclinedPopulationDTO> getDecliningTrend() {
        try {
            return populationRepo.getDecliningPopulationTred();
        } catch (EntityNotFoundException ex) {
            throw new QueryObjectNotFoundException("Population entity not found");
        } catch (Exception ex) {
            throw ex;
        }
    }
}
