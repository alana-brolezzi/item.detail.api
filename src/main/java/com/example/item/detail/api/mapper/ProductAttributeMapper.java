package com.example.item.detail.api.mapper;

import com.example.item.detail.api.dto.ProductAttributeDTO;
import com.example.item.detail.api.model.Category;
import com.example.item.detail.api.model.ProductAttribute;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductAttributeMapper {

    public List<ProductAttributeDTO> groupByCategory(List<ProductAttribute> attributeList) {
        if (attributeList == null || attributeList.isEmpty()) {
            return List.of();
        }

        Map<Category, List<ProductAttribute>> groupedAttributes = attributeList.stream()
                .collect(Collectors.groupingBy(ProductAttribute::getCategory));

        return groupedAttributes.entrySet().stream()
                .map(entry -> {
                    ProductAttributeDTO dto = new ProductAttributeDTO();
                    dto.setCategory(entry.getKey().getName());
                    Map<String, String> attributes = entry.getValue().stream()
                            .collect(Collectors.toMap(ProductAttribute::getKey, ProductAttribute::getValue));
                    dto.setAttributes(attributes);
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
