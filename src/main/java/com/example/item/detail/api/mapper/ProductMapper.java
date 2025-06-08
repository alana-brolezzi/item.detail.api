package com.example.item.detail.api.mapper;

import com.example.item.detail.api.dto.ProductDetailDTO;
import com.example.item.detail.api.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDetailDTO toDto(Product product) {
        if (product == null) {
            return null;
        }

        ProductDetailDTO dto = new ProductDetailDTO();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setSubtitle(product.getSubtitle());
        dto.setDescription(product.getDescription());
        dto.setImages(product.getImages());
        dto.setSeller(new SellerMapper().toSellerDTO(product.getSeller()));
        dto.setPrice(new PriceMapper().toPriceDTO(product.getPrice()));
        dto.setAvailablePaymentMethods(new PaymentOptionMapper().groupByType(product.getPaymentOptions()));
        dto.setAttributes(new ProductAttributeMapper().groupByCategory(product.getAttributes()));

        return dto;
    }

}
