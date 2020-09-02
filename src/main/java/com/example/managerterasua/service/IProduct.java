package com.example.managerterasua.service;

import com.example.managerterasua.model.Product;
import com.example.managerterasua.model.Store;

import java.util.List;

public interface IProduct extends GenericService<Product> {
    List<Product> findAllByStoresEquals(Store store);
    List<Product> findAllByStoresEqualsOrderByNameAsc(Store store);
    List<Product> findAllByStoresEqualsOrderByNameDesc(Store store);
    List<Product> findAllByStoresEqualsOrderByPriceAsc(Store store);
    List<Product> findAllByStoresEqualsOrderByPriceDesc(Store store);
}
