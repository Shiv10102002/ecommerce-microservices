package com.github.hvalmer.icompras.orders.controller.mappers;

import com.github.hvalmer.icompras.orders.controller.dto.OrderItemDTO;
import com.github.hvalmer.icompras.orders.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItem map(OrderItemDTO dto);
}
