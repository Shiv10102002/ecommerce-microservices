package com.github.hvalmer.icompras.orders.client.representation;

import java.math.BigDecimal;

public record ProductRepresentation(
        Long codigo, String nome, BigDecimal valorUnitario) {
}
