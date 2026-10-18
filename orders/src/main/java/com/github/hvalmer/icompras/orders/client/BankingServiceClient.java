package com.github.hvalmer.icompras.orders.client;

import com.github.hvalmer.icompras.orders.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class BankingServiceClient {

    public String solicitarPagamento(Order pedido){
        log.info("Solicitando pagamento para o pedido de código: {}.", pedido.getCodigo());
        return UUID.randomUUID().toString();
    }
}
