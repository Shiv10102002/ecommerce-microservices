package com.github.hvalmer.icompras.orders.validator;

import com.github.hvalmer.icompras.orders.client.CustomersClient;
import com.github.hvalmer.icompras.orders.client.ProductsClient;
import com.github.hvalmer.icompras.orders.client.representation.CustomerRepresentation;
import com.github.hvalmer.icompras.orders.client.representation.ProductRepresentation;
import com.github.hvalmer.icompras.orders.model.OrderItem;
import com.github.hvalmer.icompras.orders.model.Order;
import com.github.hvalmer.icompras.orders.model.exception.ValidationException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderValidator {

    private final ProductsClient produtosClient;
    private final CustomersClient clientesClient;

    public void validar(Order pedido){

        Long codigoCliente = pedido.getCodigoCliente();
        validarCliente(codigoCliente);
        pedido.getItens().forEach(this::validarItem);

    }

    private void validarCliente(Long codigoCliente){
        //verificando se o cliente existe
        try{
            //fazendo a chamada para a API de cllientes
            var response = clientesClient.obterDados(codigoCliente);
            CustomerRepresentation cliente = response.getBody();
            log.info("Cliente de código {} encontrado: {}", cliente.codigo(), cliente.nome());
        } catch (FeignException.NotFound e) {
            var message = String.format("Cliente de código %d não é encontrado!", codigoCliente);
            throw new ValidationException("codigoCliente", message);
        }
    }

    private void validarItem(OrderItem item){
        //verificando se o produto existe
        try {

            var response = produtosClient.obterDados(item.getCodigoProduto());
            ProductRepresentation produto = response.getBody();
            log.info("Produto de código {} encontrado: {}", produto.codigo(), produto.nome());
        } catch (FeignException.NotFound e){
            var message = String.format("Produto de código %d não é encontrado!", item.getCodigoProduto());
            throw new ValidationException("codigoProduto", message);
        }
    }
}
