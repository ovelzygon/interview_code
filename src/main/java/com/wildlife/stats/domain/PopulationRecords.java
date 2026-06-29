package com.wildlife.stats.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class PopulationRecords {

    @Id
    private BigInteger population_id;

    @NotNull
    private BigInteger species_group_id;

    @NotNull
    private BigInteger survey_id;

    @NotNull
    private BigInteger health_id;

    @NotNull
    private int count;


    public BigInteger getPopulation_id() {
        return population_id;
    }

    public void setPopulation_id(BigInteger population_id) {
        this.population_id = population_id;
    }

    public BigInteger getSpecies_group_id() {
        return species_group_id;
    }

    public void setSpecies_group_id(BigInteger species_group_id) {
        this.species_group_id = species_group_id;
    }

    public BigInteger getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(BigInteger survey_id) {
        this.survey_id = survey_id;
    }

    public BigInteger getHealth_id() {
        return health_id;
    }

    public void setHealth_id(BigInteger health_id) {
        this.health_id = health_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


