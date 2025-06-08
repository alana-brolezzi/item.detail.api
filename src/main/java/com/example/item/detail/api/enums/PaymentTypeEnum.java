package com.example.item.detail.api.enums;

public enum PaymentTypeEnum {

    CREDIT_CARD("Cartões de Crédito"),
    DEBIT_CARD("Cartões de Débito"),
    BANK_SLIP("Boleto Bancário"),
    MERCADOPAGO("Linha de Crédito"),
    PIX("Pix");

    private final String description;


    PaymentTypeEnum(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }



}
