package com.example.item.detail.api.service;

import com.example.item.detail.api.data.ProductDataLoader;
import com.example.item.detail.api.exception.ProductRetrievalException;
import com.example.item.detail.api.exception.ResourceNotFoundException;
import com.example.item.detail.api.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProductService Tests")
class ProductServiceTest {

    @Mock 
    private ProductDataLoader productDataLoader;

    @InjectMocks 
    private ProductService productService;

    private Product testProduct1;
    private Product testProduct2;
    private Long existingProductId = 1L;
    private Long nonExistingProductId = 99L;

    @BeforeEach
    void setUp() {
        testProduct1 = new Product();
        testProduct1.setId(existingProductId);
        testProduct1.setTitle("Test Product A");
        testProduct1.setStock(50);

        testProduct2 = new Product();
        testProduct2.setId(2L);
        testProduct2.setTitle("Test Product B");
        testProduct2.setStock(30);
    }

    @Test
    @DisplayName("Deve retornar o produto correto quando o ID existe nos dados carregados")
    void shouldReturnProductWhenIdExistsInLoadedData() throws IOException {
        // Dado: Mockar o loadData() para retornar uma lista controlada de produtos
        List<Product> mockProducts = Arrays.asList(testProduct1, testProduct2);
        when(productDataLoader.loadData()).thenReturn(mockProducts);

        // Quando: Chamar o método findProductById do serviço
        Product foundProduct = productService.findProductById(existingProductId);

        // Então: Verificar se o produto retornado é o esperado
        assertNotNull(foundProduct);
        assertEquals(existingProductId, foundProduct.getId());
        assertEquals("Test Product A", foundProduct.getTitle());

        // Verificar se o método loadData() do dataLoader foi chamado exatamente uma vez
        verify(productDataLoader, times(1)).loadData();
    }

    @Test
    @DisplayName("Deve retornar exception ResourceNotFoundException quando o ID não existe nos dados carregados")
    void shouldThrowResourceNotFoundExceptionWhenIdDoesNotExistInLoadedData() throws IOException {
        // Dado: Mockar loadData() para retornar uma lista que NÃO contém o produto procurado
        List<Product> mockProducts = Arrays.asList(testProduct1, testProduct2);
        when(productDataLoader.loadData()).thenReturn(mockProducts);

        // Quando/Então: Verificar se o método lança ResourceNotFoundException
        ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class, () -> {
            productService.findProductById(nonExistingProductId);
        });

        // Verificar a mensagem da exceção
        assertTrue(thrown.getMessage().contains("Produto com ID '" + nonExistingProductId + "' não encontrado."));

        // Verificar se o método loadData() foi chamado
        verify(productDataLoader, times(1)).loadData();
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException quando o ID é nulo")
    void shouldThrowIllegalArgumentExceptionWhenIdIsNull() throws IOException {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            productService.findProductById(null);
        });
        assertEquals("O ID do produto não pode ser nulo ou menor/igual a zero.", thrown.getMessage());
        // Verificar que o método loadData() NÃO foi chamado
        verify(productDataLoader, never()).loadData();
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException quando o ID é zero")
    void shouldThrowIllegalArgumentExceptionWhenIdIsZero() throws IOException {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            productService.findProductById(0L);
        });
        assertEquals("O ID do produto não pode ser nulo ou menor/igual a zero.", thrown.getMessage());
        verify(productDataLoader, never()).loadData();
    }

    @Test
    @DisplayName("Deve retornar IllegalArgumentException quando o ID é negativo")
    void shouldThrowIllegalArgumentExceptionWhenIdIsNegative() throws IOException {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            productService.findProductById(-5L);
        });
        assertEquals("O ID do produto não pode ser nulo ou menor/igual a zero.", thrown.getMessage());
        verify(productDataLoader, never()).loadData();
    }

    @Test
    @DisplayName("Deve lançar ProductRetrievalException quando loadData() lança IOException")
    void shouldThrowProductRetrievalExceptionWhenloadDataThrowsIOException() throws IOException {
        // Dado: Mockar loadData() para lançar uma IOException
        when(productDataLoader.loadData()).thenThrow(new IOException("Simulated file read error"));

        // Quando/Então: Verificar se o método lança ProductRetrievalException
        ProductRetrievalException thrown = assertThrows(ProductRetrievalException.class, () -> {
            productService.findProductById(existingProductId);
        });

        // Verificar a mensagem da exceção e a causa raiz
        assertTrue(thrown.getMessage().contains("Falha ao ler dados do produto:"));
        assertEquals("Simulated file read error", thrown.getCause().getMessage());

        // Verificar se o método loadData() foi chamado
        verify(productDataLoader, times(1)).loadData();
    }

    @Test
    @DisplayName("Deve lançar ProductRetrievalException quando loadData() lança outra exceção")
    void shouldThrowProductRetrievalExceptionWhenloadDataThrowsOtherException() throws IOException {
        // Dado: Mockar loadData() para lançar uma RuntimeException
        when(productDataLoader.loadData()).thenThrow(new NullPointerException("Simulated data parsing error"));

        // Quando/Então: Verificar se o método lança ProductRetrievalException
        ProductRetrievalException thrown = assertThrows(ProductRetrievalException.class, () -> {
            productService.findProductById(existingProductId);
        });

        // Verificar a mensagem da exceção e a causa raiz
        assertTrue(thrown.getMessage().contains("Falha ao buscar produto com ID:"));
        assertEquals("Simulated data parsing error", thrown.getCause().getMessage());

        // Verificar se o método loadData() foi chamado
        verify(productDataLoader, times(1)).loadData();
    }

}