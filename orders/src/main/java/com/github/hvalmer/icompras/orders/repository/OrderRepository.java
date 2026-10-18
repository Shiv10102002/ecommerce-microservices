package com.github.hvalmer.icompras.orders.repository;

import com.github.hvalmer.icompras.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
