package com.example.item.detail.api.dto;

import java.util.Map;

public class ProductAttributeDTO {
    private String category;
    private Map<String, String> attributes;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getCategory() {
        return category;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
