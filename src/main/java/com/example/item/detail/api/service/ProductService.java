package com.example.item.detail.api.service;

import com.example.item.detail.api.data.ProductDataLoader;
import com.example.item.detail.api.exception.ProductRetrievalException;
import com.example.item.detail.api.exception.ResourceNotFoundException;
import com.example.item.detail.api.model.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProductService {

    private final ProductDataLoader productDataLoader;

    public ProductService(ProductDataLoader productDataLoader) {
        this.productDataLoader = productDataLoader;
    }

    public Product findProductById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo ou menor/igual a zero.");
        }

        try {
            return this.productDataLoader.loadData().stream()
                    .filter(product -> product.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("Produto", id));
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new ProductRetrievalException("Falha ao ler dados do produto: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ProductRetrievalException("Falha ao buscar produto com ID: " + id, e);
        }

    }


}
