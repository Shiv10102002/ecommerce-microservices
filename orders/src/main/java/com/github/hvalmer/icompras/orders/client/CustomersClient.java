package com.github.hvalmer.icompras.orders.client;

import com.github.hvalmer.icompras.orders.client.representation.CustomerRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clientes", url = "${icompras.pedidos.clients.clientes.url}")
public interface CustomersClient {

    @GetMapping("{codigo}")
    ResponseEntity<CustomerRepresentation> obterDados(@PathVariable("codigo") Long codigo);
}
