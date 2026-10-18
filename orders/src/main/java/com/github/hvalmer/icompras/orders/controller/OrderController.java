package com.github.hvalmer.icompras.orders.controller;

import com.github.hvalmer.icompras.orders.controller.dto.NewOrderDTO;
import com.github.hvalmer.icompras.orders.controller.mappers.OrderMapper;
import com.github.hvalmer.icompras.orders.model.ErrorResponse;
import com.github.hvalmer.icompras.orders.model.exception.ValidationException;
import com.github.hvalmer.icompras.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    private final OrderMapper mapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NewOrderDTO dto){
        try {
            var pedido = mapper.map(dto);
            var novoPedido = service.criarPedido(pedido);
            return ResponseEntity.ok(novoPedido.getCodigo());
        } catch(ValidationException e){
            var erro = new ErrorResponse("Erro de validação", e.getField(), e.getMessage());
            return  ResponseEntity.badRequest().body(erro);
        }
    }
}
