package com.example.rest_api.model;

public enum Currency {
    USD("Dolar Amerykański"),
    EUR("Euro"),
    PLN("Polski złoty");

    private final String displayValue;

    private Currency(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
