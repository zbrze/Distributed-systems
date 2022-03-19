package com.example.rest_api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

public class CurrencyForm {
    @NotNull
    private Currency fromCurrency;
    private float fromAmount;
    @NotNull
    private Currency toCurrency;

    @NotNull
    @Positive
    private float toAmount;

    @PastOrPresent
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date time;

    public CurrencyForm(Currency fromCurrency, float fromAmount, Currency toCurrency, float toAmount, Date time){
        this.fromCurrency = fromCurrency;
        this.fromAmount = fromAmount;
        this.toCurrency = toCurrency;
        this.toAmount = toAmount;
        this.time = time;
    }

    public CurrencyForm(Currency fromCurrency, float fromAmount, Currency toCurrency, float toAmount){
        this.fromCurrency = fromCurrency;
        this.fromAmount = fromAmount;
        this.toCurrency = toCurrency;
        this.toAmount = toAmount;
        this.time = new Date(System.currentTimeMillis());
    }
    public CurrencyForm(){}

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setToAmount(float toAmount) {
        this.toAmount = toAmount;
    }

    public void setFromAmount(float fromAmount) {
        this.fromAmount = fromAmount;
    }
    public void setTime(Date time) {
        this.time = time;
    }

    public Currency getFromCurrency(){
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public float getToAmount() {
        return toAmount;
    }

    public float getFromAmount() {
        return fromAmount;
    }

    public Date getTime() {
        return time;
    }
}