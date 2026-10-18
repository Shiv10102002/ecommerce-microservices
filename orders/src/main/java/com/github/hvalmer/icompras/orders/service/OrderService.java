package com.github.hvalmer.icompras.orders.service;

import com.github.hvalmer.icompras.orders.client.BankingServiceClient;
import com.github.hvalmer.icompras.orders.model.Order;
import com.github.hvalmer.icompras.orders.repository.OrderItemRepository;
import com.github.hvalmer.icompras.orders.repository.OrderRepository;
import com.github.hvalmer.icompras.orders.validator.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderItemRepository itemPedidoRepository;
    private final OrderValidator validator;
    private final BankingServiceClient servicoBancarioClient;

    @Transactional
    public Order criarPedido(Order pedido){
        validator.validar(pedido);
        realizarPersistencia(pedido);
        enviarSolicitacaoPagamento(pedido);
        return pedido;
    }

    private void enviarSolicitacaoPagamento(Order pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Order pedido) {
        repository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
    }

}
