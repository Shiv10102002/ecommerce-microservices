package com.github.hvalmer.icompras.products.service;

import com.github.hvalmer.icompras.products.model.Product;
import com.github.hvalmer.icompras.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product salvar(Product produto){
        return repository.save(produto);
    }

    public Optional<Product> obterPorCodigo(Long codigo){
        return repository.findById(codigo);
    }
}
