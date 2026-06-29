package com.wildlife.stats.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
public class FXRates {

    @Id
    private BigInteger fx_rate_id;

    @NotNull
    private LocalDate date;

    @NotNull
    private int currencyFromId;

    @NotNull
    private int currencyToId;

    @NotNull
    private double fxRate;


    public BigInteger getFx_rate_id() {
        return fx_rate_id;
    }

    public void setFx_rate_id(BigInteger fx_rate_id) {
        this.fx_rate_id = fx_rate_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCurrencyFromId() {
        return currencyFromId;
    }

    public void setCurrencyFromId(int currencyFromId) {
        this.currencyFromId = currencyFromId;
    }

    public int getCurrencyToId() {
        return currencyToId;
    }

    public void setCurrencyToId(int currencyToId) {
        this.currencyToId = currencyToId;
    }

    public double getFxRate() {
        return fxRate;
    }

    public void setFxRate(double fxRate) {
        this.fxRate = fxRate;
    }
}
