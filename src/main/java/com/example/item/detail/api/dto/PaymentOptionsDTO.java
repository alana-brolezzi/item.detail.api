package com.example.item.detail.api.dto;

import java.util.List;

public class PaymentOptionsDTO {
    private String paymentType;
    private List<String> brands;

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public List<String> getBrands() {
        return brands;
    }
}
