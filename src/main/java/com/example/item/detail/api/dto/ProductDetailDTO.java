package com.example.item.detail.api.dto;

import java.util.List;

public class ProductDetailDTO {
    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private PriceDTO price;
    private List<String> images;
    private SellerDTO seller;
    private List<ProductAttributeDTO> attributes;
    private List<PaymentOptionsDTO> availablePaymentMethods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriceDTO getPrice() {
        return price;
    }

    public void setPrice(PriceDTO price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerDTO seller) {
        this.seller = seller;
    }

    public List<ProductAttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ProductAttributeDTO> attributes) {
        this.attributes = attributes;
    }

    public List<PaymentOptionsDTO> getAvailablePaymentMethods() {
        return availablePaymentMethods;
    }

    public void setAvailablePaymentMethods(List<PaymentOptionsDTO> availablePaymentMethods) {
        this.availablePaymentMethods = availablePaymentMethods;
    }
}
