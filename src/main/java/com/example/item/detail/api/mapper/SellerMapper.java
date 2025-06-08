package com.example.item.detail.api.mapper;

import com.example.item.detail.api.dto.SellerDTO;
import com.example.item.detail.api.model.Seller;
import com.example.item.detail.api.model.SellerAttribute;

import java.util.stream.Collectors;

public class SellerMapper {

    public SellerDTO toSellerDTO(Seller seller) {
        if (seller == null) {
            return null;
        }

        SellerDTO dto = new SellerDTO();
        dto.setId(seller.getId());
        dto.setName(seller.getName());
        dto.setOfficialStore(seller.getOfficialStore());
        dto.setLogo(seller.getLogo());
        dto.setAttributes(seller.getAttributes().stream()
                .collect(Collectors.toMap(SellerAttribute::getKey, SellerAttribute::getValue)));

        return dto;
    }


}
