package com.example.managerterasua.repository;

import com.example.managerterasua.model.Product;
import com.example.managerterasua.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByStoresEquals(Store store);
    List<Product> findAllByStoresEqualsOrderByNameAsc(Store store);
    List<Product> findAllByStoresEqualsOrderByNameDesc(Store store);
    List<Product> findAllByStoresEqualsOrderByPriceAsc(Store store);
    List<Product> findAllByStoresEqualsOrderByPriceDesc(Store store);


}
