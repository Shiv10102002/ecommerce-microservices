package com.github.hvalmer.icompras.products.repository;

import com.github.hvalmer.icompras.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
