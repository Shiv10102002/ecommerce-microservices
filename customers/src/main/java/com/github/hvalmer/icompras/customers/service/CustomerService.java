package com.github.hvalmer.icompras.customers.service;

import com.github.hvalmer.icompras.customers.model.Customer;
import com.github.hvalmer.icompras.customers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    
    private final CustomerRepository repository;

    public Customer salvar(Customer cliente){
        return repository.save(cliente);
    }

    public Optional<Customer> obterPorCodigo(Long codigo){
        return repository.findById(codigo);
    }
}
