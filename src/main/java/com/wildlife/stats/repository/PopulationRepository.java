package com.wildlife.stats.repository;

import com.wildlife.stats.dto.DeclinedPopulationDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PopulationRepository {

    @Value("declingTrendQuery")
    private String declingTrendQuery;

    @PersistenceContext
    private EntityManager entityManager;

    public List<DeclinedPopulationDTO> getDecliningPopulationTred() {
        List<DeclinedPopulationDTO> results =
                entityManager.createQuery(declingTrendQuery, DeclinedPopulationDTO.class)
                .getResultList();

        Optional<List<DeclinedPopulationDTO>> opt =
                results.isEmpty() ? Optional.empty() : Optional.of(results);

        return opt.orElse(new ArrayList<>());
    }
}
