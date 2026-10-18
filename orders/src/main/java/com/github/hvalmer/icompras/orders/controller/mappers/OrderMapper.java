package com.github.hvalmer.icompras.orders.controller.mappers;

import com.github.hvalmer.icompras.orders.controller.dto.OrderItemDTO;
import com.github.hvalmer.icompras.orders.controller.dto.NewOrderDTO;
import com.github.hvalmer.icompras.orders.model.OrderItem;
import com.github.hvalmer.icompras.orders.model.Order;
import com.github.hvalmer.icompras.orders.model.enums.OrderStatus;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderItemMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(source = "itens", target = "itens", qualifiedByName = "mapItens")
    //@Mapping(source = "dadosPagamento", target = "dadosPagamento")
    Order map(NewOrderDTO dto);

    @Named("mapItens")
    default List<OrderItem> mapItens(List<OrderItemDTO> dtos){
        return dtos.stream().map(ITEM_PEDIDO_MAPPER::map).toList();
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Order pedido){
        pedido.setStatus(OrderStatus.REALIZADO);
        pedido.setDataPedido(LocalDateTime.now());

        var total = calcularTotal(pedido);

        pedido.setTotal(total);

        pedido.getItens().forEach(item ->item.setPedido(pedido));
    }

    private static BigDecimal calcularTotal(Order pedido) {
        return pedido.getItens().stream().map(item ->
                item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()))
        ).reduce(BigDecimal.ZERO, BigDecimal::add).abs();
    }

}
