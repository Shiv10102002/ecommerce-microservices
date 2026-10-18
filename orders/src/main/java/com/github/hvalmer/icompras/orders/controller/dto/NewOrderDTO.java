package com.github.hvalmer.icompras.orders.controller.dto;

import java.util.List;

public record NewOrderDTO(
        Long codigoCliente,
        PaymentDataDTO dadosPagamentoDTO,
        List<OrderItemDTO> itens) {
}
