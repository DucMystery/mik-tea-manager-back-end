package com.example.managerterasua.service.Impl;

import com.example.managerterasua.model.Product;
import com.example.managerterasua.model.Store;
import com.example.managerterasua.repository.IProductRepository;
import com.example.managerterasua.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct {

    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByStoresEquals(Store store) {
        return productRepository.findAllByStoresEquals(store);
    }


    @Override
    public List<Product> findAllByStoresEqualsOrderByNameAsc(Store store) {
        return productRepository.findAllByStoresEqualsOrderByNameAsc(store);
    }

    @Override
    public List<Product> findAllByStoresEqualsOrderByNameDesc(Store store) {
        return productRepository.findAllByStoresEqualsOrderByNameDesc(store);
    }

    @Override
    public List<Product> findAllByStoresEqualsOrderByPriceAsc(Store store) {
        return productRepository.findAllByStoresEqualsOrderByPriceAsc(store);
    }

    @Override
    public List<Product> findAllByStoresEqualsOrderByPriceDesc(Store store) {
        return productRepository.findAllByStoresEqualsOrderByPriceDesc(store);
    }


}
