package com.example.item.detail.api.controller;

import com.example.item.detail.api.dto.ProductDetailDTO;
import com.example.item.detail.api.mapper.ProductMapper;
import com.example.item.detail.api.model.Product;
import com.example.item.detail.api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController implements ProductApi{

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> getProductDetail(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        ProductDetailDTO dto = productMapper.toDto(product);
        return ResponseEntity.ok(dto);
    }

}
