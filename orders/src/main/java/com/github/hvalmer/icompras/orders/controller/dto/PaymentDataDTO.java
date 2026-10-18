package com.github.hvalmer.icompras.orders.controller.dto;

import com.github.hvalmer.icompras.orders.model.enums.PaymentType;

public record PaymentDataDTO(String dados, PaymentType tipoPagamento) {
}
