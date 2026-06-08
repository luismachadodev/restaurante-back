package com.example.restauranteback.dto;

import java.math.BigDecimal;

public record ProdutoDTO(
        Long id,
        String nome,
        String descricao,
        String categoria,
        BigDecimal preco,
        String imagem,
        Boolean ativo
) {}
