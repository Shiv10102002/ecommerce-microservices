package com.github.hvalmer.icompras.orders.client;

import com.github.hvalmer.icompras.orders.client.representation.ProductRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produtos", url = "${icompras.pedidos.clients.produtos.url}")
public interface ProductsClient {

    //requisição para a API de produtos
    @GetMapping("{codigo}")
    ResponseEntity<ProductRepresentation> obterDados(@PathVariable("codigo") Long codigo);

}
