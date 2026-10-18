package com.github.hvalmer.icompras.orders.controller.dto;

import java.math.BigDecimal;

public record OrderItemDTO(
        Long codigoProduto,
        Integer quantidade,
        BigDecimal valorUnitario) {
}
