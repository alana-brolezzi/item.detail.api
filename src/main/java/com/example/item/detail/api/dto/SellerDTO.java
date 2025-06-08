package com.example.item.detail.api.dto;

import com.example.item.detail.api.model.Seller;

import java.util.Map;

public class SellerDTO {
    private Long id;
    private String name;
    private Boolean isOfficialStore;
    private String logo;
    Map<String, String> attributes;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOfficialStore(Boolean officialStore) {
        isOfficialStore = officialStore;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getOfficialStore() {
        return isOfficialStore;
    }

    public String getLogo() {
        return logo;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
