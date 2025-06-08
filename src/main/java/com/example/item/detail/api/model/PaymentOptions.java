package com.example.item.detail.api.model;

import com.example.item.detail.api.enums.PaymentTypeEnum;

public class PaymentOptions {
    private Long id;
    private PaymentTypeEnum type;
    private String cardBrand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentTypeEnum getType() {
        return type;
    }

    public void setType(PaymentTypeEnum type) {
        this.type = type;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }
}
