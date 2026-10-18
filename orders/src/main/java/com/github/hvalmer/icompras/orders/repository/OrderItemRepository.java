package com.github.hvalmer.icompras.orders.repository;

import com.github.hvalmer.icompras.orders.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
