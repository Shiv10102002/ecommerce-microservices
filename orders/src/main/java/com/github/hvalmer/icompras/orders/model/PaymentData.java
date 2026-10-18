package com.github.hvalmer.icompras.orders.model;

import com.github.hvalmer.icompras.orders.model.enums.PaymentType;
import lombok.Data;

@Data
public class PaymentData {

    private String dados;
    private PaymentType tipoPagamento;
}
