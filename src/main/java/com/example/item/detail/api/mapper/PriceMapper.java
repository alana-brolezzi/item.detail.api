package com.example.item.detail.api.mapper;

import com.example.item.detail.api.dto.PriceDTO;
import com.example.item.detail.api.model.Price;

public class PriceMapper {

    public PriceDTO toPriceDTO(Price price) {
        if (price == null) {
            return null;
        }

        PriceDTO dto = new PriceDTO();
        dto.setCurrency(price.getCurrency());
        dto.setAmount(price.getAmount());

        return dto;
    }

}
