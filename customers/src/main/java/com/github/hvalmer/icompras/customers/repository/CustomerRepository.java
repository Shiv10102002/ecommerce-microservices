package com.github.hvalmer.icompras.customers.repository;

import com.github.hvalmer.icompras.customers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
