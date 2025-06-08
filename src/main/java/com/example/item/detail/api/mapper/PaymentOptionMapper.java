package com.example.item.detail.api.mapper;

import com.example.item.detail.api.dto.PaymentOptionsDTO;
import com.example.item.detail.api.enums.PaymentTypeEnum;
import com.example.item.detail.api.model.PaymentOptions;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PaymentOptionMapper {

    public List<PaymentOptionsDTO> groupByType(List<PaymentOptions> options) {
        if (options == null || options.isEmpty()) {
            return Collections.emptyList();
        }

        Map<PaymentTypeEnum, List<PaymentOptions>> grouped = options.stream()
                .collect(Collectors.groupingBy(PaymentOptions::getType));

        return grouped.entrySet().stream()
                .map(entry -> {
                    PaymentOptionsDTO dto = new PaymentOptionsDTO();
                    dto.setPaymentType(entry.getKey().toString());

                    List<String> brands = entry.getValue().stream()
                            .map(PaymentOptions::getCardBrand)
                            .filter(Objects::nonNull)
                            .distinct()
                            .collect(Collectors.toList());

                    dto.setBrands(brands);
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
