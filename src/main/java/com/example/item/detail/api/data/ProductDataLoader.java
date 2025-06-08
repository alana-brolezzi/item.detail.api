package com.example.item.detail.api.data;

import com.example.item.detail.api.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class ProductDataLoader {

    private final ObjectMapper objectMapper;

    public ProductDataLoader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Product> loadData() throws IOException {
        InputStream inputStream = new ClassPathResource("data/products.json").getInputStream();
        return objectMapper.readValue(inputStream, new TypeReference<>() {});
    }

}
