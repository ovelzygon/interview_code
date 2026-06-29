package com.wildlife.stats.dto;

import jakarta.validation.constraints.NotBlank;

public class DeclinedPopulationDTO {

    @NotBlank
    private String speciesName;

    private int year;

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
}
