package com.example.item.detail.api.controller;

import com.example.item.detail.api.dto.ProductDetailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Produtos", description = "Página de detalhes do produto")
public interface ProductApi {

    @Operation(
            summary = "Obtém detalhes de um produto por ID",
            description = "Retorna os detalhes completos de um produto específico, incluindo informações de estoque e preço."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Detalhes do produto encontrados com sucesso",
                    content = @Content(schema = @Schema(implementation = ProductDetailDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "ID do produto inválido ou fora das regras de negócio",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Produto não encontrado para o ID fornecido",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor ao buscar o produto",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<ProductDetailDTO> getProductDetail(
            @Parameter(description = "ID único do produto a ser buscado", example = "123")
            @PathVariable Long id);

}
