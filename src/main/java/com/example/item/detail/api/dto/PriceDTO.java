package com.example.item.detail.api.dto;

import java.math.BigDecimal;

public class PriceDTO {
    private String currency;
    private BigDecimal amount;

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
