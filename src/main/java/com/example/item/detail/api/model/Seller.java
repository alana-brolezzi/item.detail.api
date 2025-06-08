package com.example.item.detail.api.model;

import java.util.List;

public class Seller {
    private Long id;
    private Long cnpj;
    private String name;
    private Boolean isOfficialStore;
    private String logo;
    private String location;
    private List<SellerAttribute> attributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOfficialStore() {
        return isOfficialStore;
    }

    public void setOfficialStore(Boolean officialStore) {
        isOfficialStore = officialStore;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<SellerAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<SellerAttribute> attributes) {
        this.attributes = attributes;
    }
}
